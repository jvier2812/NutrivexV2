package com.nutrivex.platform.app.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nutrivex.platform.app.models.Person;
import com.nutrivex.platform.app.models.Template;
import com.nutrivex.platform.app.service.PersonService;
import com.nutrivex.platform.app.service.TemplateService;

@Controller
@RequestMapping("/template")
@SessionAttributes("template")
public class TemplateController {
	public static Person sessionUser;

	@Autowired
	private PersonService personService;
	@Autowired
	private TemplateService templateService;

	@GetMapping("/list")
	public String listTemplates(@RequestParam Long id_nut, Model model) {

		model.addAttribute("sessionUser", personService.findPerson(id_nut));

		try {
			model.addAttribute("title", "Template de Plan Nutricional");
			model.addAttribute("templates", templateService.fetchTemplatesByNutritionistId(id_nut));

			return "/nutritionalTemplate/list";
			
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "nutritionist/menu";
		}
	}

	@GetMapping("/new")
	public String newTemplate(@RequestParam Long id, Model model, RedirectAttributes flash) {

		sessionUser = personService.findPerson(id);
		
		
		Template template = new Template();
		template.setDate(new Date());
		template.setNutritionist(sessionUser.getUser());

		model.addAttribute("template", template);
		model.addAttribute("title", "Nuevo Template");
		model.addAttribute("sessionUser", sessionUser);
		return "nutritionalTemplate/new";
	}
	@PostMapping("/save")
	public String saveTemplate(@Valid Template template, BindingResult result, Model model, SessionStatus status) throws Exception {
		model.addAttribute("sessionUser", sessionUser);
		if (result.hasErrors()) {
			return "/nutrionalTemplate/new?id="+sessionUser.getId();
		} else {
			templateService.save(template);
			model.addAttribute("success", "Solicitud enviada!");
			status.setComplete();
		}
		return "nutritionalTemplate/list";
	}


}
