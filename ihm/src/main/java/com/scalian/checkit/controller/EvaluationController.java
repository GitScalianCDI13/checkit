package com.scalian.checkit.controller;

import com.scalian.checkit.model.EvaluationEntity;
import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.model.TestEntity;
import com.scalian.checkit.service.impl.EvaluationBU;
import com.scalian.checkit.service.model.UserBO;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EvaluationController {

    @Autowired
    EvaluationBU evaluationBU;

	@RequestMapping("/candidat/evaluation")
    @Transactional
	public String assesment(HttpServletRequest request, HttpSession session, ModelMap model) {

	    // Récupération des infos de session
	    UserBO user = (UserBO) session.getAttribute("user");
	    ResultEvaluationEntity resultEvaluation = (ResultEvaluationEntity) session.getAttribute("resultEvaluation");

	    // Récupération de l'évaluation
        //EvaluationEntity evaluation  = evaluationBU.findOne(resultEvaluation.getEvaluation().getEvaluationId());
        EvaluationEntity evaluation = resultEvaluation.getEvaluation();
        Hibernate.initialize(evaluation.getTests());

        // Récupération des tests
        List<TestEntity> tests = evaluation.getTests();

        // Passage des données dans le ModelMap
        model.addAttribute("evaluation", evaluation);
        model.addAttribute("tests", tests);

	    return "assesment";
	}
}
