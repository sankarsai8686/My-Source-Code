package com.gontuseries.hellocontroller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {
	
	public boolean preHandle(
			  HttpServletRequest request,
			  HttpServletResponse response, 
			  Object handler) throws Exception
	{
		System.out.println("preHandle");
		
		Calendar cal = Calendar.getInstance();
		
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
		System.out.println("dayOfWeek : "+dayOfWeek);
		long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
		
        System.out.println("startTime : "+startTime);
		/*if(dayOfWeek == 7)
		{
			response.getWriter().write("Saturday hoilday");
			return false;
		}*/
		
		 return true;
	}
	
	
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		request.removeAttribute("startTime");

		long endTime = System.currentTimeMillis();
		modelAndView.addObject("totalTime", endTime - startTime);

		System.out.println("Request Prcessing Time :: " + (endTime - startTime));
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exceptionIfAny) throws Exception {
		System.out.println("View Rendered !!");
	}
	
	
	

}
