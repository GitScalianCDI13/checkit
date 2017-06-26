package com.scalian.checkit.controller;

import com.scalian.checkit.model.EvaluationEntity;
import com.scalian.checkit.model.QuestionEntity;
import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.model.TestEntity;
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
import java.util.List;

@Controller
public class AssesmentController {

    @Autowired
    UserBU userBU;
    @Autowired
    ResultEvaluationBU resultEvaluationBU;
    @Autowired
    EvaluationBU evaluationBU;
    @Autowired
    TestBU testBU;
    @Autowired
    QuestionBU questionBU;

	@RequestMapping("/assesment")
    @Transactional
	public String assesment(HttpServletRequest request, HttpSession session, ModelMap model) {

	    // Récupération des infos de session
	    Integer userId = (Integer) session.getAttribute("user");
	    Integer resultEvaluationId = (Integer) session.getAttribute("resultEvaluation");

	    // Récupération de l'utilisateur
        UserBO user = userBU.findOne(userId);

        // Récupération des infos de RésultEvaluation
        ResultEvaluationEntity resultEvaluation = resultEvaluationBU.findOne(resultEvaluationId);

	    // Récupération de l'évaluation
        EvaluationEntity evaluation  = resultEvaluation.getEvaluation();

        // Récupération des tests de l'évaluation
        resultEvaluation.getEvaluation().getTests().size(); // NE PAS SUPPRIMER CETTE LIGNE !!! INDISPENSABLE CAR ON EST EN LAZY !!!
        List<TestEntity> tests = resultEvaluation.getEvaluation().getTests();

        // Passage des données dans le ModelMap
        model.addAttribute("userFirstname", user.getUserFirstname());
        model.addAttribute("userLastname", user.getUserLastname());
        model.addAttribute("resultEvaluation", resultEvaluation);
        model.addAttribute("evaluation", evaluation);
        model.addAttribute("tests", tests);

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
        test.getQuestions().size();
        List<QuestionEntity> questions = test.getQuestions();

        // Passer la liste des questions en session
        // session.setAttribute("questions",  questions);

        // Récupération de l'id de la première question
        Integer idFirstQuestion = questions.get(0).getQuestionId();

        // Rediriger vers le controleur de la page d'affichage de la question
        return "redirect:/assesment/test/" + id + "/question/" + idFirstQuestion;
    }

    @RequestMapping("assesment/test/{id_test}/question/{id_question}")
    @Transactional
    public String assesmentTestQuestion(HttpServletRequest request, HttpSession session, ModelMap model, @PathVariable String idTest, @PathVariable String idQuestion){

        // Récupération du test
        TestEntity test = testBU.findOne(Integer.valueOf(idTest));

        // Récupération des questions du test
        test.getQuestions().size();
        List<QuestionEntity> questions = test.getQuestions();

        // Récupération de la question en coursr
        QuestionEntity question = questionBU.findOne(Integer.valueOf(idQuestion));

        // Récupération position courante
        Integer index = questions.indexOf(question);

        // Récupération question précédente
        Integer indexPrevious = index - 1;
        Integer idPreviousQuestion = null;
        if (indexPrevious >= 0){
            idPreviousQuestion = questions.get(indexPrevious).getQuestionId();
        }

        // Récupération question suivante
        Integer indexNext = index + 1;
        Integer idNextQuestion = null;
        if (indexNext >= questions.size() - 1){
            idNextQuestion = questions.get(indexNext).getQuestionId();
        }

        // Passage des données dans le ModelMap
        model.addAttribute("id_previous_question", idPreviousQuestion);
        model.addAttribute("id_next_question", idNextQuestion);
        model.addAttribute("test", test);
        model.addAttribute("question", question);
        model.addAttribute("index", index);

        return "assesment_test_question";
    }
}
