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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zeroteam.core.todo.TodoCriteria;
import org.zeroteam.core.todo.TodoService;
import org.zeroteam.core.todo.TodoVO;

@Controller
@RequestMapping("/todo/*")
public class TodoController {

	private static final String SUCCESS_DELETE = "success_delete";

	private static final String SUCCESS_MODIFY = "success_modify";

	private static final String SUCCESS_REGIST = "success_regist";

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
	public String regist(@ModelAttribute("todo") TodoVO vo){
		
		logger.info("regist get");
		
		return "/todo/form";
	}
	
	@RequestMapping(value="/registAction", method = RequestMethod.POST)
	public String registAction(@Valid  @ModelAttribute("todo")TodoVO vo,  
			                   BindingResult bindingResult, 
			                   RedirectAttributes redirectAttributes){
		
		logger.info("regist post");
		
		logger.info(vo.toString());
		
		if (bindingResult.hasErrors()) {
            logger.info("Returning regist.jsp page");
            return "/todo/form";
            
        }
		
		service.addTodo(vo);
		
		readyRedirect(redirectAttributes,null,SUCCESS_REGIST, "/todo/list" );
		return "redirect:/todo/actionResult";
		
	}
	
	@RequestMapping(value="/actionResult", method=RequestMethod.GET)
	public void actionResult(){
	
		logger.info("action result");
		
		
	}
	
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void list(@ModelAttribute("cri")TodoCriteria cri,
					 Model model){
		
		logger.info("list get");
		
		model.addAttribute("list",service.listTodo(cri));
		
		logger.info(cri.toString());
		
		
	}
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public void detail(@ModelAttribute("cri")TodoCriteria cri, 
			           @RequestParam("bno") Integer bno,  
			           Model model){
		
		logger.info("detail get");
		
		model.addAttribute("todo",service.viewTodo(bno));
		
		logger.info(cri.toString());
		
	}	
	
	

	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute("cri") TodoCriteria cri, 
						 @Valid  TodoVO vo, 
						 RedirectAttributes redirectAttributes){
		
		logger.info("modify post");
		logger.info(vo.toString());		
		logger.info(cri.toString());
		
		service.modifyTodo(vo);
		
		
		readyRedirect(redirectAttributes,cri,SUCCESS_MODIFY, "/todo/list" );
		return "redirect:/todo/actionResult";
		
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute("cri")TodoCriteria cri, 
			                   @RequestParam("bno") Integer bno,  
			                   RedirectAttributes redirectAttributes){
		
		logger.info("delete post");
		logger.info(""+bno);		
		logger.info(cri.toString());
		
		service.removeTodo(bno);
		
		
		readyRedirect(redirectAttributes,cri,SUCCESS_DELETE, "/todo/list" );

		return "redirect:/todo/actionResult";
	}
	
	private void readyRedirect(RedirectAttributes redirectAttributes, 
			                     Object cri, 
			                     String result, 
			                     String nextPage){
		
		
		if(cri != null){
			redirectAttributes.addFlashAttribute("cri", cri);
		}
		
		redirectAttributes.addAttribute("result",result);
		redirectAttributes.addAttribute("nextPage",nextPage);
		
		
	}



	
}





























