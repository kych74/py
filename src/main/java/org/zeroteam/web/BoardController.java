package org.zeroteam.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zeroteam.core.board.BoardCriteria;
import org.zeroteam.core.board.BoardService;
import org.zeroteam.core.board.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	BoardService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@RequestMapping(value ="/regist", method = {RequestMethod.GET})
	public String regist(@ModelAttribute("board") BoardVO vo){
		
		logger.info("regist get");
		
		
		return "/board/form";
	}
	
	
	@RequestMapping(value="/regist", method ={RequestMethod.POST})
	public @ResponseBody String registAction(@ModelAttribute("board") BoardVO vo){
		
		logger.info("regist post");
	
		service.addBoard(vo);
		
		return "success";
	
	}
	
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void list(@ModelAttribute("cri")BoardCriteria cri,
					 Model model){
		
		logger.info("list get");
		
		model.addAttribute("list",service.listBoard(cri));
		
		logger.info(cri.toString());
		
		
	}
	
	
	
	
}
