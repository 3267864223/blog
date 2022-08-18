package blog.aop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws IOException, ServletException {
	/**
		 最后一个参数,可以得到调用的方法的相关信息
		HandlerMethod handlerMethod = (HandlerMethod) o;
		System.out.println("当前拦截的方法为："+ handlerMethod.getMethod().getName()  );
		System.out.println("当前拦截的方法参数长度为: "+handlerMethod.getMethod().getParameters());
		System.out.println("当前拦截执行这个方法的类是: "+ handlerMethod.getBean().getClass().getName());
	*/

		if (request.getSession().getAttribute("session_user") == null) {
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			return false;
		}
		
		return true;
	}
}
