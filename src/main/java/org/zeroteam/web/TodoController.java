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
	
	private static final int EMPTY_BNO = -1;
	
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
	public String regist(@ModelAttribute("todo") TodoVO vo, Model model){
		
		logger.info("regist get");
		
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
		
		model.addAttribute("result", SUCCESS_REGIST);
		model.addAttribute("nextPage","list");
		return "redirect:/todo/actionResult";
		
	}
	
	@RequestMapping(value="/actionResult", method=RequestMethod.GET)
	public void actionResult(){
	
		logger.info("action result");
		
		
	}
	
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void list(@ModelAttribute("cri")TodoCriteria cri,Model model){
		
		logger.info("list get");
		
		model.addAttribute("list",service.listTodo(cri));
		
		logger.info(cri.toString());
		logger.info(""+ cri.getStart()+":" + cri.getEnd());
		
		
	}
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String detail(@ModelAttribute("cri")TodoCriteria cri, @RequestParam("bno") Integer bno,  Model model){
		
		logger.info("detail get");
		
		if(bno != EMPTY_BNO){
			model.addAttribute("todo",service.view(bno));
		}
		
		logger.info(cri.toString());
		
		return "/todo/detail";
	}	
	
	

	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute("cri") TodoCriteria cri, 
			@Valid  TodoVO vo, RedirectAttributes redirectAttributes){
		
		logger.info("modify post");
		
		logger.info(vo.toString());
		
		logger.info(cri.toString());
		
		redirectAttributes.addFlashAttribute("cri", cri);
		redirectAttributes.addAttribute("result",SUCCESS_MODIFY);
		return "redirect:/todo/actionResult";
		
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute("cri")TodoCriteria cri, @RequestParam("bno") Integer bno,  Model model){
		
		logger.info("delete post");
		
		logger.info(""+bno);
		
		logger.info(cri.toString());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("result",SUCCESS_DELETE);
		
		mav.setViewName("redirect:/todo/actionResult");
		return mav;
	}	



	
}





























