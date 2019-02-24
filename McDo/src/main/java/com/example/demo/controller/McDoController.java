package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.McDoDao;
import com.example.demo.entities.McDo;

@RestController
@CrossOrigin("*")
public class McDoController {
	
	@Autowired 
	private McDoDao	mcDoDoa;
	
	
	@RequestMapping(value="/McDos",method=RequestMethod.GET)
	@ResponseBody
	public List<McDo> getMcDos(){
		return mcDoDoa.findAll();
	}
	
	@RequestMapping(value="/searchMcDo",method=RequestMethod.GET)
	public Page<McDo> search(
			@RequestParam(name="mc",defaultValue="") String mc,
			@RequestParam(name="page",defaultValue="0")  int page,
			@RequestParam(name="size",defaultValue="100") int size)
	{
		return mcDoDoa.search("%"+mc+"%",new PageRequest(page, size));
	}

}
