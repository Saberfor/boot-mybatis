package com.spring.cloud.mybatis;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AnotherController {

	@RequestMapping("/index")
	public ModelAndView listUser(ModelMap map, String id) {
		map.addAttribute("id", id);
		return new ModelAndView("index", map);
	}
}
