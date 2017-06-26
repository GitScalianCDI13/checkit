package com.scalian.checkit.controller;

import com.scalian.checkit.model.EvaluationEntity;
import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.model.TestEntity;
import com.scalian.checkit.service.impl.EvaluationBU;
import com.scalian.checkit.service.impl.ResultEvaluationBU;
import com.scalian.checkit.service.impl.TestBU;
import com.scalian.checkit.service.impl.UserBU;
import com.scalian.checkit.service.model.UserBO;
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
public class EvaluationController {

    @Autowired
    UserBU userBU;
    @Autowired
    ResultEvaluationBU resultEvaluationBU;
    @Autowired
    EvaluationBU evaluationBU;
    @Autowired
    TestBU testBU;

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
System.out.println(test.getTestDescription());
        model.addAttribute("test", test);

        return "assesment_test";
    }
}
