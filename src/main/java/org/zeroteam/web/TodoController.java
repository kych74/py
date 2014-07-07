package org.zeroteam.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zeroteam.core.todo.TodoCriteria;
import org.zeroteam.core.todo.TodoService;
import org.zeroteam.core.todo.TodoVO;

@Controller
@RequestMapping("/todo/*")
public class TodoController {

	private static final Logger logger = LoggerFactory.getLogger(TodoController.class);
	
	@Inject
	TodoService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	
	@RequestMapping(value ="/regist", method = RequestMethod.GET)
	public String regist(Model model){
		
		logger.info("regist get");
		
		model.addAttribute("todo", new TodoVO());
		
		return "/todo/form";
	}
	
	@RequestMapping(value="/registAction", method = RequestMethod.POST)
	public String registAction(@Valid  @ModelAttribute("todo")TodoVO vo,  BindingResult bindingResult, Model model){
		
		logger.info("regist post");
		logger.info(vo.toString());
		
		if (bindingResult.hasErrors()) {
            logger.info("Returning regist.jsp page");
            return "/todo/form";
        }
		
		model.addAttribute("result", "success");
		model.addAttribute("nextPage","list");
		return "redirect:/todo/regist";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void list(TodoCriteria cri, Model model){
		
		logger.info("list get");
		
		model.addAttribute("list",service.listTodo(cri));
		model.addAttribute("cri", cri);
		
	}
	
	
}




