package cn.jxust.dq.student.controller;

import cn.jxust.dq.student.entity.activityuser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/5/18.
 */
@Controller
@RequestMapping("/index")
public class Firstaction {

    @RequestMapping(value = "/secondindex" )
    public String firstjsp(Model modle)
    {
        //获取当前用户的信息
        Subject subject =SecurityUtils.getSubject();
        activityuser principal = (activityuser) subject.getPrincipal();

        modle.addAttribute("principal",principal);
        return  "forward:/pages/secondcourse.jsp";
    }
    @RequestMapping(value = "/index")

    public String index()
    {
        return  "/admin123.jsp";
    }

}
