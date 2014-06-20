package cas.client.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cas.client.test.utils.ConfigUtil;
import cas.client.test.utils.SessionUtil;


/**
 * 拦截指定path，进行权限验证，及用户的本地session过期后，重新进行赋值
 */
public class TestInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private ConfigUtil configUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {

		Assertion assertion=AssertionHolder.getAssertion();
		//实际cas-client-core中org.jasig.cas.client.authentication.AuthenticationFilter已经进行了单点登录认证，这里主要是为了获得权限
		if(assertion==null 
				|| assertion.getPrincipal()==null
				|| assertion.getPrincipal().getName()==null)
		{
			//没有登录，跳转到没有登录页面
			response.sendRedirect(configUtil.getCasServerUrl());
			return false;
		}

		String user = SessionUtil.getSessionUser(request);
		
		if(user == null)
		{	
			//授权操作（查询权限系统等操作
			//授权结束，存入session
			request.getSession().setAttribute(SessionUtil.SessionSystemLoginUserName,user);
		}
		
		//判断权限，没有权限，进入没有权限页面
		
		return true;	
		
	}
}
