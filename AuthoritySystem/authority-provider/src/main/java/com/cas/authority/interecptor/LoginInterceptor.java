package com.cas.authority.interecptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cas.authority.controller.RegistController;
import com.cas.authority.model.User;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			return true;
		}

		final HandlerMethod handlerMethod = (HandlerMethod) handler;
		final Method method = handlerMethod.getMethod();
		final Class<?> clazz = method.getDeclaringClass();
		if (clazz == RegistController.class) {
			PostMapping active = method.getAnnotation(PostMapping.class);
			if (active != null) {
				String[] values = active.value();
				for (String string : values) {
					if ("active".equals(string)) {
						return true;
					}
				}
			} else {
				GetMapping time = method.getAnnotation(GetMapping.class);
				if (time != null) {
					String[] paths = time.value();
					for (String string : paths) {
						if ("time_mills".equals(string)) {
							return true;
						}
					}
				}
			}
		}

		User user = (User) request.getSession().getAttribute("LoginUser");
		if (user != null) {
			return user.getRole() == 3; //管理员
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

}
