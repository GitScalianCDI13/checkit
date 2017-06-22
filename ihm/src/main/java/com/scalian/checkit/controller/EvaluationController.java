package com.scalian.checkit.controller;

import com.scalian.checkit.model.EvaluationEntity;
import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.model.TestEntity;
import com.scalian.checkit.model.UserEntity;
import com.scalian.checkit.service.impl.EvaluationBU;
import com.scalian.checkit.service.impl.ResultEvaluationBU;
import com.scalian.checkit.service.impl.TestBU;
import com.scalian.checkit.service.impl.UserBU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EvaluationController {

    @Autowired
    EvaluationBU evaluationBU;

	@RequestMapping("/candidat/evaluation")
	public String assessment(HttpServletRequest request, HttpSession session, ModelMap model) {

	    // Récupération des infos de session
	    UserEntity user = (UserEntity) session.getAttribute("user");
	    ResultEvaluationEntity resultEvaluation = (ResultEvaluationEntity) session.getAttribute("resultEvaluation");

	    // Récupération de l'évaluation
        EvaluationEntity evaluation  = evaluationBU.findOne(resultEvaluation.getEvaluationId());

        System.out.print(evaluation.getEvaluationLabel());

	    return "assesment";
	}
}
