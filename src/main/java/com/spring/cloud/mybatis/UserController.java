package com.spring.cloud.mybatis;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public ModelAndView listUser(ModelMap map) {
		List<User> list = userService.listUser();
		map.addAttribute("list", list);
		return new ModelAndView("user/list", map);
	}
	
	@RequestMapping("/add")
	public ModelAndView add(ModelMap map) {
		return new ModelAndView("user/add", map);
	}
	
	@RequestMapping("/add_submit")
	public void addUser(@RequestParam("name")String name, @RequestParam("gender")String gender, @RequestParam("age")Integer age
			,@RequestParam("id")Integer id ,HttpServletResponse response) throws IOException{
		User user = new User(name, gender, age);
		if (id == null) {
			userService.addUser(user);
		} else {
			user.setId(id);
			userService.updateUser(user);
		}
		response.sendRedirect("list");//  重定向
	}
	
	@RequestMapping("/delete")
	public void deleteUser(User user, HttpServletResponse response) throws IOException {
		userService.deleteUser(user);
		//response.sendRedirect("http://localhost:8080/index");
		response.sendRedirect("list");//  重定向
		//response.sendRedirect("/index?id=5");
	}
	
	@RequestMapping("/edit")
	public ModelAndView editUser(ModelMap map, Integer id) {
		User userId = new User();
		userId.setId(id);
		User user = userService.findById(userId);
		map.addAttribute("user", user);
		return new ModelAndView("user/edit", map);
	}
	
	@RequestMapping("/info")
	public ModelAndView infoUser(ModelMap map, Integer id) {
		User userId = new User();
		userId.setId(id);
		User user = userService.findById(userId);
		map.addAttribute("user", user);
		return new ModelAndView("user/info", map);
	}
	
	@RequestMapping("/list2")
	public ModelAndView listUser2(ModelMap map) {
		List<User> list = userService.listUser2();
		map.addAttribute("list", list);
		return new ModelAndView("user/list", map);
	}
	
	@RequestMapping("/list3")
	public ModelAndView listUser3(ModelMap map) {
		List<User> list = userService.listUser3();
		map.addAttribute("list", list);
		return new ModelAndView("user/list", map);
	}
	
	@RequestMapping("/list4")
	public ModelAndView listUser4(ModelMap map) {
		List<User> list = userService.listUser4(3);
		/*List<UserRelation> lists = userService.findUserRelation(1);
		lists.stream().forEach(a -> System.out.println(a.getRelationId()));*/
		if(list.get(0).getUserRelations() != null){
			list.stream().forEach(user -> user.getUserRelations().stream().forEach(
					actionRelation -> {
						System.out.println(actionRelation.getCompany());
						System.out.println(actionRelation.getRelationId());
					}));
		}
		map.addAttribute("list", list);
		return new ModelAndView("user/list", map);
	}
}
