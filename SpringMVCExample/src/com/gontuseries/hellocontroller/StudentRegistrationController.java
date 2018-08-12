package com.gontuseries.hellocontroller;

/*import java.sql.Date;*/

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
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

@Controller
public class StudentRegistrationController {
	
	
	
	@InitBinder
	public void initbinder(WebDataBinder binder)
	{
		System.out.println("@InitBinder");
		//binder.setDisallowedFields(new String[]{"mobileNo"});
		SimpleDateFormat sd = new SimpleDateFormat("yyyy--MM--dd");
		binder.registerCustomEditor(Date.class, "dob",new CustomDateEditor(sd, false));
		binder.registerCustomEditor(String.class, "name",new StudentNameEditor());
	}

	@RequestMapping(value="/Registration",method = RequestMethod.GET)
	public ModelAndView getRegistrationForm()
	{
		ModelAndView model = new ModelAndView("StudentRegistration");
	/*	model.addObject("headermsg", "welcome user");*/  // we will add this msg in modelattribute
		return model;
		
	}
	
	@ModelAttribute
	public void commonData(Model model)
	{
		model.addAttribute("headermsg", "welcome user");
		model.addAttribute("msg", "Successfully Registerd ........... ");
		
	}
	
/*	@RequestMapping(value="/Register",method = RequestMethod.POST)
	//public ModelAndView doRegister(@RequestParam(value="name" ,defaultValue="ABCXYZ") String name,@RequestParam("password") String password)
	public ModelAndView doRegister(@RequestParam Map<String, String> val)
	{
		String name = val.get("name");
		if(name.isEmpty())
		{
			System.out.println("user not entered name");
		}
		System.out.println("name is : "+name);
		String password = val.get("password");
		ModelAndView model = new ModelAndView("StudentRegistrationSuccess");
		model.addObject("msg", "Successfully Registerd Details is : name ->"+name+" : password : "+password);
		return model;
	}
	
*/

	@RequestMapping(value="/Register",method = RequestMethod.POST)
	public ModelAndView doRegister(@Valid @ModelAttribute("student") Student student, BindingResult result)
	{
		System.out.println("doRegister");
		
		if(result.hasErrors())
		{
			System.out.println("errors");
			ModelAndView model = new ModelAndView("StudentRegistration");
			return model;
		}
		
		ModelAndView model = new ModelAndView("StudentRegistrationSuccess");
		/*model.addObject("msg", "Successfully Registerd ........... ");*/
		/*model.addObject("student", student);*/
		return model;
	}
	
	
	
	
}
