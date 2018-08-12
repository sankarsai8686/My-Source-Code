package com.gontuseries.hellocontroller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
/*@RequestMapping("/first")*/
public class HelloController 
/*public class HelloController extends AbstractController */  //without using configuration.
{

	/*@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("handleRequestInternal");
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage", "Welcome to spring tutorial");
		return modelAndView;
	}*/

	@RequestMapping(value= {"/","index"})
	public ModelAndView index()
	{
		System.out.println("index");
		ModelAndView model  = new ModelAndView("firstpage");
		model.addObject("welcomeMessage", "Welcome to spring tutorial");
		return model;
	}
	
	@RequestMapping("/welcome")
	public ModelAndView hellojava()
	{
		System.out.println("hellojava");
		ModelAndView model  = new ModelAndView("HelloPage");
		model.addObject("welcomeMessage", "Welcome to spring tutorial");
		return model;
	}
	@RequestMapping("/hi")
	public ModelAndView hijava()
	{
		System.out.println("hijava");
		ModelAndView model  = new ModelAndView("HelloPage");
		model.addObject("welcomeMessage", "hi hi hi hi");
		return model;
	}
	
	
	@RequestMapping("/welcome/{user}")
	public ModelAndView welcomeuser(@PathVariable("user") String user)
	{
		System.out.println("welcomeuser");
		ModelAndView model  = new ModelAndView("HelloPage");
		model.addObject("welcomeMessage", "Welcome to spring tutorial user is : "+user);
		return model;
	}
	
/*	@RequestMapping("/welcome/{user}/{country}")
	public ModelAndView welcomeusercountry(@PathVariable("user") String user,@PathVariable("country") String country)
	{
		System.out.println("welcomeuser");
		ModelAndView model  = new ModelAndView("HelloPage");
		model.addObject("welcomeMessage", "Welcome to spring tutorial user is : "+user+" : country : "+country);
		return model;
	}
*/	
	@RequestMapping("/welcome/{user}/{country}")
	public ModelAndView welcomeusercountry(@PathVariable Map<String, String> value)  //<mvc:annotation-driven />
	{
		System.out.println("welcomeuser");
		String user = value.get("user");
		String country = value.get("country");
		ModelAndView model  = new ModelAndView("HelloPage");
		model.addObject("welcomeMessage", "Welcome to spring tutorial user is : "+user+" : country : "+country);
		return model;
	}
	
	
	
	
}
