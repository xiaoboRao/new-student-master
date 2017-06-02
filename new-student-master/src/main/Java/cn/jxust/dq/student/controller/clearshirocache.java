package cn.jxust.dq.student.controller;

import cn.jxust.dq.student.shiro.MyRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/5/18.
 */
@Controller
public class clearshirocache {
    //将来在service创建
 @Autowired
 private  MyRealm realm;
    @RequestMapping("/clearcache")
    public String clear()
    {
        realm.clearCached();
        return  "/pages/success.jsp";
    }
}
