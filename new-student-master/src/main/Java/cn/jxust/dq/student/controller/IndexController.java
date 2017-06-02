package cn.jxust.dq.student.controller;

import cn.jxust.dq.student.entity.*;
import cn.jxust.dq.student.service.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by xixi on 2017/5/11.
 */

@Controller
public class IndexController {

    @Autowired
    private IUserService userService;
    @Autowired
    private UserRoleservice userRoleservice;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RolePermissionService rolePermissionService;
    @Autowired
    private PermissionService permissionService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
        String username = request.getParameter("username");
//        String password = BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt());
        String loginpassword = request.getParameter("password");
        SimpleHash hash = new SimpleHash("md5", loginpassword, username, 1024);

        System.out.printf("注册时的密码"+hash.toString());

        if (((username != null) && username.trim()!="")) {

            User user = userService.getUserByUsername(username);
            if (hash.toString().equals(user.getPassword()))
                return "forward:/admin1.jsp";
            else
                return "redirect:/pages/error.jsp";
        }
        return "redirect:/pages/error.jsp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister() {
        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request) throws UnsupportedEncodingException {
        String username = request.getParameter("username");

//        String password = BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt());
        String password = request.getParameter("password");
        SimpleHash hash = new SimpleHash("md5", password, username, 1024);
        password=hash.toString();
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String college = request.getParameter("college");
        String idnumber = request.getParameter("idnumber");
        Byte sex = (byte) Integer.parseInt(request.getParameter("sex"));
        int classes = Integer.parseInt(request.getParameter("classes"));
        User user = new User(username, password, email, phone, college, idnumber, sex, classes);


        userService.insertUser(user);
        System.out.println("user = " + user.getEmail());
        User userByUsername = userService.getUserByUsername(username);
        System.out.println("userByUsername.getId() = " + userByUsername.getId());
        //创建对应的角色权限类，由注册过来的，都是固定的角色和权限
        Role role=new Role();
        role.setAvalable((byte)1);
        role.setName("query");
        roleService.insert(role);
        Role selectByUsername = roleService.findByname(role.getName());
        System.out.println("selectByUsername.getId() = " + selectByUsername.getId());

        //创建用户角色表，并将用户表和角色表的id放入，插入到数据库中
        UserRole userRole=new UserRole();
        userRole.setRoleId(selectByUsername.getId());
        userRole.setUserId(userByUsername.getId());
        userRoleservice.insert(userRole);

        //对权限进行编码
        String content="查询";
        byte[] bytes=content.getBytes("ISO-8859-1");
        content=new String(bytes,"UTF-8");
        //定义好权限，放入表中并获取放入数据库后的权限对象
        Permission permission =new Permission();
        permission.setType("query");
        permission.setName(content);
        permission.setAvalable((byte) 1);
        permission.setUrl("/pages/index.jsp");
        permissionService.insert(permission);
        Permission findpermissionbyname = permissionService.findpermissionbyname(permission.getName());

        //将角色和权限的信息放在角色权限表中
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(selectByUsername.getId());
        rolePermission.setPermissionId(findpermissionbyname.getId());
        rolePermissionService.insert(rolePermission);

        return  "redirect:/pages/index.jsp";
    }

    @RequestMapping("/check")
    @ResponseBody//必须加入的注解,为了响应ajax
    public int Checkname(HttpServletRequest request)
    {
        User username = userService.getUserByUsername(request.getParameter("user_code"));

        if (username != null) {
            return 0;
        } else {
            return 1;
        }
    }
}
