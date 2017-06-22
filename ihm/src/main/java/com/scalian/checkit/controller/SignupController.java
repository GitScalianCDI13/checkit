package com.scalian.checkit.controller;

import com.scalian.checkit.model.ResultEvaluationEntity;
import com.scalian.checkit.model.UserEntity;
import com.scalian.checkit.service.impl.ResultEvaluationBU;
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
public class SignupController {

    @Autowired
    UserBU userBU;
    @Autowired
    ResultEvaluationBU resultEvaluationBU;
	
	@RequestMapping("/signup")
	public String signup(HttpServletRequest request, ModelMap model) {
		return "signup";
	}
	
	@RequestMapping("/subscribe")
	public String subscribe(HttpServletRequest request, HttpSession session, ModelMap model, RedirectAttributes redirectAttrs) {

	    // Get list of users with same email
	    List<UserEntity> usersList = userBU.findByUserEmail(request.getParameter("email"));

	    // If exists a user with this email
	    if(usersList.size() > 0){

	        try {

                // Add error msg
                redirectAttrs.addFlashAttribute("error_email", "Cet email est déjà utilisé par un autre candidat !");

                // Redirect to the same page to display error
                return "redirect:/signup";

            } catch (Exception e) {
                return null;
            }

        // If not
        } else {

	        try {

                // Add User
                UserEntity user = userBU.addNewCandidat(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("email"));

                // Init ResultEvaluation
                ResultEvaluationEntity resultEvaluation = resultEvaluationBU.addNewResultEvaluation(user.getUserId(), 1);

                // Redirect to the candidat home page
                session.setAttribute("user", user);
                session.setAttribute("resultEvaluation", resultEvaluation);
                return "redirect:/candidat/evaluation";

            } catch (Exception e) {
                return null;
            }

        }
	}
}
