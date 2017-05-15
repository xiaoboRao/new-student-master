package cn.jxust.dq.student.controller;

import cn.jxust.dq.student.entity.User;
import cn.jxust.dq.student.service.IUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xixi on 2017/5/11.
 */

@Controller
public class IndexController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index() {

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt());
        if (!(username != null && !username.equals(""))) {
           return "/pages/error.jsp";
        }
        User user = userService.getUserByUsername(username);
        if (BCrypt.checkpw(password,user.getPassword()))
            return "/pages/error.jsp";
        else
            return "/pages/index.jsp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister() {
        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt());
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String realName = request.getParameter("realName");
        String nickName = request.getParameter("nickName");
        Byte sex = (byte) Integer.parseInt(request.getParameter("sex"));
        int userClass = Integer.parseInt(request.getParameter("userClass"));
        User user = new User(username, password, phone, email, realName, nickName, sex, userClass);
        userService.insertUser(user);
        return  "redirect:/pages/index.jsp";
    }


}
