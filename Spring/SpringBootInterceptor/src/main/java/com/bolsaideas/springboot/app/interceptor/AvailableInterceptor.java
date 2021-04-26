package com.bolsaideas.springboot.app.interceptor;

import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("AvailableInterceptor")
public class AvailableInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(AvailableInterceptor.class);
	
	@Value("${config.horario.apertura}")
	private Integer apertura;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(handler instanceof HandlerMethod) {
			HandlerMethod metodo = (HandlerMethod) handler;
			logger.info("Metodo del controlador llamado es -> "+metodo.getMethod().getName());
		}
		
		logger.info("TimeoutInterceptor preHandle entrando....");
		long timeout = System.currentTimeMillis();
		
		request.setAttribute("timeStart", timeout);
		
		Random random = new Random();
		Integer time = random.nextInt(1000);
		
		Thread.sleep(time);
		
		Calendar calender = Calendar.getInstance();
		
		int hour = calender.get(Calendar.HOUR_OF_DAY);
		
		if(hour >= apertura && hour <= cierre) {
			StringBuilder mensaje = new StringBuilder("Bienvenido al banco");
			
			mensaje.append(",inicio ").append(apertura).append(" cierre ").append(cierre);
			
			request.setAttribute("message", mensaje.toString());
			
			return true;
		}
		
		response.sendRedirect(request.getContextPath().concat("/close"));
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		long timeoutEnd = System.currentTimeMillis();
		long timeout = (Long)request.getAttribute("timeStart");
		
		long during = timeoutEnd-timeout;
		
		String mensaje = (String)request.getAttribute("message");
		
		if(handler instanceof HandlerMethod &&  modelAndView!=null) {
			modelAndView.addObject("horario", mensaje);
			modelAndView.addObject("timeout", during);
		}
		
	}

	
}
