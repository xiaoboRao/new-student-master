package cn.jxust.dq.student.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/16.
 */
@Controller
public class LogonTest {
    @RequestMapping(value = "/logon1" , method = RequestMethod.GET)
    public String logon(HttpServletRequest request) {
        //1.创建subject实例

        return  "/admin1.jsp";
    }
    @RequestMapping(value = "/logon1",method = RequestMethod.POST)
    public String logon1(HttpServletRequest request)
    {

        //shiro已经弄好了加密方式
        String password = request.getParameter("password");
        String username = request.getParameter("username");

        Subject currentuser = SecurityUtils.getSubject();

        //2.判断是否登录
        if (currentuser.isAuthenticated() == false) {
            UsernamePasswordToken Token = new UsernamePasswordToken(username,password);
            Token.setRememberMe(true);

            try {
                currentuser.login(Token);
            } catch (AuthenticationException e) {
                e.printStackTrace();
                return  "/pages/error.jsp";
            }
        }

        //第一次授权完成转发的url是不被拦截的
        return "forward:/index/secondindex.action";
    }
}