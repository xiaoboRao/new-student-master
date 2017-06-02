package cn.jxust.dq.student.Filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * 
 * <p>Title: CustomFormAuthenticationFilter</p>
 * <p>Description:自定义FormAuthenticationFilter，认证之前实现 验证码校验 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-3-25下午4:53:15
 * @version 1.0
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

	//原FormAuthenticationFilter的认证方法
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		return super.onAccessDenied(httpServletRequest, response);
	}

		
}
