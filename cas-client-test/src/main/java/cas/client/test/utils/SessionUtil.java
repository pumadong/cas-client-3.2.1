package cas.client.test.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
	
	/**
	 * 系统登录用户名
	 */
	public static final String SessionSystemLoginUserName = "SessionSystemLoginUserName";
	
	/**
	 * 清空session
	 */
	public static final void clearSession(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		
		session.removeAttribute(SessionUtil.SessionSystemLoginUserName);

		session.invalidate();//非必须，单点登出接收到服务器消息时，会自动销毁session
	}

	/**
	 * 返回session中的用户名
	 * @param request
	 * @return
	 */
	public static final String getSessionUser(HttpServletRequest request)
	{
		return (String) request.getSession().getAttribute(SessionUtil.SessionSystemLoginUserName);
	}
}
