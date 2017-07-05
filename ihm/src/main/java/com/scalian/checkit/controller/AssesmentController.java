package com.scalian.checkit.controller;

import com.scalian.checkit.model.*;
import com.scalian.checkit.repository.TestRepository;
import com.scalian.checkit.service.impl.*;
import com.scalian.checkit.service.model.UserBO;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AssesmentController {

    @Autowired
    UserBU userBU;
    @Autowired
    ResultEvaluationBU resultEvaluationBU;
    @Autowired
    TestBU testBU;
    @Autowired
    QuestionBU questionBU;
    @Autowired
    TestResultBU testResultBU;
    @Autowired
    PossibleResponseBU possibleResponseBU;
    @Autowired
    UserResponseBU userResponseBU;

	@RequestMapping("/assesment")
    @Transactional
	public String assesment(HttpServletRequest request, HttpSession session, ModelMap model) {

	    // Get session datas
	    Integer userId = (Integer) session.getAttribute("user");
	    Integer resultEvaluationId = (Integer) session.getAttribute("resultEvaluation");

	    // Get user
        UserBO user = userBU.findOne(userId);

        //
        if(user == null){
            return "error";
        }

        // Get RésultEvaluation
        ResultEvaluationEntity resultEvaluation = resultEvaluationBU.findOne(resultEvaluationId);

	    // Get Evaluation
        EvaluationEntity evaluation  = resultEvaluation.getEvaluation();

        // Get Evaluation's tests
        List<TestEntity> tests = testBU.findAllByEvaluationsEqualsOrderByTestId(evaluation);

        // Get testResult
        List<TestResultEntity> testResultEntities = testResultBU.findAllByResultEvaluation(resultEvaluation);
        List<Integer> testsOk = new ArrayList<>();
        for (TestResultEntity testResult: testResultEntities){
            testsOk.add(testResult.getTest().getTestId());
        }

        // Send datas to ModelMap
        model.addAttribute("userFirstname", user.getUserFirstname());
        model.addAttribute("userLastname", user.getUserLastname());
        model.addAttribute("resultEvaluation", resultEvaluation);
        model.addAttribute("evaluation", evaluation);
        model.addAttribute("tests", tests);
        model.addAttribute("testsOk", testsOk);

	    return "assesment";
	}

    @RequestMapping("/assesment/test/{id}")
    @Transactional
    public String assesmentTest(HttpServletRequest request, HttpSession session, ModelMap model, @PathVariable String id) {

        // Récupération du test
        TestEntity test = testBU.findOne(Integer.valueOf(id));
        model.addAttribute("test", test);

        return "assesment_test";
    }

    @RequestMapping("/assesment/test/{id}/start")
    @Transactional
    public String  assesmentTestStart(HttpServletRequest request, HttpSession session, @PathVariable String id){

	    // Récupération du test
        TestEntity test = testBU.findOne(Integer.valueOf(id));

        // Récupération des questions du test
        List<QuestionEntity> questions = questionBU.findAllByTestsEqualsOrderByQuestionId(test);

        // Récupération de l'id de la première question
        Integer idFirstQuestion = questions.get(0).getQuestionId();

        // Création du TestResult
        TestResultEntity testResultEntity = testResultBU.addNewTestResult((Integer) session.getAttribute("resultEvaluation"), test.getTestId());
        session.setAttribute("testResult", testResultEntity.getTestResultId());
        session.setAttribute("timeStart", System.currentTimeMillis());

        // Rediriger vers le controleur de la page d'affichage de la question
        return "redirect:/assesment/test/" + id + "/question/" + idFirstQuestion;
    }


    @RequestMapping("assesment/test/{idTest}/questions")
    @Transactional
    public String assesmentTestQuestions(HttpServletRequest request, HttpSession session, ModelMap model, @PathVariable String idTest) {

        // Récupération du testResult
        TestResultEntity testResult = testResultBU.findOne((Integer)(session.getAttribute("testResult")));

        // Récupération du test
        TestEntity test = testBU.findOne(Integer.valueOf(idTest));

        // Récupération des questions du test
        List<QuestionEntity> questions = questionBU.findAllByTestsEqualsOrderByQuestionId(test);

        // Récupération des questions auxquelles le candidat a déjà répondu
        List<UserResponseEntity> userResponseEntities = userResponseBU.findByTestResult(testResult);
        Integer userResponseSize = userResponseEntities.size();
        Integer[] questionsOk = new Integer[userResponseSize];
        Integer i = 0;
        for (UserResponseEntity userResponseEntity : userResponseEntities){
            questionsOk[i] = userResponseEntity.getQuestion().getQuestionId();
            i++;
        }

        model.addAttribute("questions", questions);
        model.addAttribute("questionsOk", Arrays.asList(questionsOk));
        model.addAttribute("test", test);

        return "assesment_test_questions";
    }

    @RequestMapping("assesment/test/{idTest}/question/{idQuestion}")
    @Transactional
    public String assesmentTestQuestion(HttpServletRequest request, HttpSession session, ModelMap model, @PathVariable String idTest, @PathVariable String idQuestion){

        // Récupération du test
        TestEntity test = testBU.findOne(Integer.valueOf(idTest));

        // Récupération des questions du test
        List<QuestionEntity> questions = questionBU.findAllByTestsEqualsOrderByQuestionId(test);

        // Récupération de la question en cours
        QuestionEntity question = questionBU.findOne(Integer.valueOf(idQuestion));

        // Récupération des réponses possibles
        List<PossibleResponseEntity> possibleResponses = possibleResponseBU.findAllByQuestionOrderByPossibleResponseId(question);
//        question.getPossibleResponses().size();
//        List<PossibleResponseEntity> possibleResponses = question.getPossibleResponses();

        // Récupération position courante
        Integer index = questions.indexOf(question);

        // Récupération question précédente
        Integer indexPrevious = index - 1;
        Integer idPreviousQuestion = 0;
        if (indexPrevious >= 0){
            idPreviousQuestion = questions.get(indexPrevious).getQuestionId();
        }

        // Récupération question suivante
        Integer indexNext = index + 1;
        Integer idNextQuestion = 0;
        if (indexNext <= questions.size() - 1){
            idNextQuestion = questions.get(indexNext).getQuestionId();
        }

        // Récupération du testResult
        TestResultEntity testResult = testResultBU.findOne((Integer)(session.getAttribute("testResult")));

        // Récupération des réponses candidat si déja répondu à cette question
        List<UserResponseEntity> userResponseEntities = userResponseBU.findByTestResultByQuestion(testResult, question);
        Integer userResponseSize = userResponseEntities.size();
        Integer[] userResponseIdList = getUserResponsesArray(userResponseEntities, userResponseSize);

        // Passage des données dans le ModelMap
        model.addAttribute("id_previous_question", idPreviousQuestion);
        model.addAttribute("id_next_question", idNextQuestion);
        model.addAttribute("test", test);
        model.addAttribute("question", question);
        model.addAttribute("index", index);
        model.addAttribute("tot_question", questions.size());
        model.addAttribute("possible_responses", possibleResponses);
        model.addAttribute("user_response_id_list", Arrays.asList(userResponseIdList));

        return "assesment_test_question";
    }

    @RequestMapping("assesment/response/save")
    @Transactional
    public String assesmentSaveResponse(HttpServletRequest request, HttpSession session, ModelMap model){

        // Récupération du testResult
        TestResultEntity testResult = testResultBU.findOne((Integer)(session.getAttribute("testResult")));

        // Vérifier si le candidat a déjà répondu à cette question
        // Si oui, on supprime les anciennes réponses avant d'ajouter les nouvelles réponses
        QuestionEntity currentQuestion = questionBU.findOne(Integer.parseInt(request.getParameter("question_id")));
        List<UserResponseEntity> oldUserResponses = userResponseBU.findByTestResultByQuestion(testResult, currentQuestion);
        for(UserResponseEntity oldUserResponse : oldUserResponses){
            userResponseBU.delete(oldUserResponse);
        }

        // Récupération des réponses sélectionnées par le candidat
        String[] userResponses = request.getParameterValues("possible_response_id");

        if(userResponses != null) {
            for (String userResponse : userResponses) {
                // Création de la réponse du candidat
                UserResponseEntity userResponseEntity = userResponseBU.addNewUserResponse((Integer) session.getAttribute("user"), (Integer) session.getAttribute("testResult"), Integer.parseInt(request.getParameter("question_id")), Integer.parseInt(userResponse));
            }
        }

        // Traitements en fonction du bouton submit cliqué (Question suivante, Question précédente, Liste des questions, Terminer le test)
        switch (request.getParameter("submit")) {
            case "previous":
                return "redirect:/assesment/test/" + request.getParameter("id_test") + "/question/" + request.getParameter("id_previous_question");
            case "next":
                return "redirect:/assesment/test/" + request.getParameter("id_test") + "/question/" + request.getParameter("id_next_question");
            case "list":
                return "redirect:/assesment/test/" + testResult.getTest().getTestId() + "/questions";
            case "end":
            default:
                return "redirect:/assesment/test/" + testResult.getTest().getTestId() + "/save";
        }
    }

    @RequestMapping("assesment/test/{id}/save")
    @Transactional
    public String saveTestResult(HttpSession session){

        // Récupération du testResult
        TestResultEntity testResult = testResultBU.findOne((Integer)(session.getAttribute("testResult")));

        // Calcul du nombre de secondes entres le début et la fin du test
        Long duration = System.currentTimeMillis() - (Long)session.getAttribute("timeStart");
        Integer testResultTime = duration.intValue();
        /*long second = (testResultTime / 1000) % 60;
        long minute = (testResultTime / (1000 * 60)) % 60;
        long hour = (testResultTime / (1000 * 60 * 60)) % 24;
        String time = String.format("%02d:%02d:%02d", hour, minute, second);*/

        /************** Calcul de la note ********************/
        // Récupération du test
        TestEntity test = testResult.getTest();

        // Récupération des questions
        Integer questionSize = test.getQuestions().size();
        List<QuestionEntity> questions = test.getQuestions();

        // Note
        Integer note = 0;

        for (QuestionEntity question : questions){

            // Récupération des bonnes réponses de la question
            List<PossibleResponseEntity> possibleResponseEntities = possibleResponseBU.findByQuestionAndPossibleResponseChecked(question, true);
            Integer possibleResponseSize = possibleResponseEntities.size();

            // Récupération des réponses du candidat sur cette question
            List<UserResponseEntity> userResponseEntities = userResponseBU.findByTestResultByQuestion(testResult, question);
            Integer userResponseSize = userResponseEntities.size();
            Integer[] userResponseIdList = getUserResponsesArray(userResponseEntities, userResponseSize);

            if (possibleResponseSize == userResponseSize){

                Boolean error = false;

                for (PossibleResponseEntity possibleResponseEntity : possibleResponseEntities){
                    Integer possibleResponseId = possibleResponseEntity.getPossibleResponseId();

                    if (!Arrays.asList(userResponseIdList).contains(possibleResponseId)) {
                        error = true;
                        break;
                    }
                }
                if(error == false){
                    note++;
                }
            }

        }
        /****************** Fin note ***************/

        // Mettre à jour le testresult
        testResult.setTestResultScore(note);
        testResult.setTestResultTime(testResultTime);
        testResultBU.save(testResult);

        return "redirect:/assesment";
    }

    // Méthode pour récupérer les réponses d'un candidat à une question d'un TestResult
    public Integer[] getUserResponsesArray(List<UserResponseEntity> userResponses, Integer size){
        Integer[] userResponseIdList = new Integer[size];
        Integer i = 0;
        for (UserResponseEntity userResponseEntity : userResponses){
            userResponseIdList[i] = userResponseEntity.getPossibleResponse().getPossibleResponseId();
            i++;
        }
        return userResponseIdList;
    }
}
