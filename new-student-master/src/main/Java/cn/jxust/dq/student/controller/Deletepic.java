package cn.jxust.dq.student.controller;

import cn.jxust.dq.student.dao.MysocialMapper;
import cn.jxust.dq.student.entity.*;
import cn.jxust.dq.student.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.AssociationOverride;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/5/29.
 */
@Controller
public class Deletepic {
    @Autowired
    private activityitems activityitems;
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private User user;
    @Autowired
    private Items Items;
    @Autowired
    private IUserService userService;

    @Autowired
    private MygroupExample mygroupExample;

    @Autowired
    private MysocialMapper mysocialMapper;

    @Autowired
    private  MysocialExample mysocialExample;

    @Autowired
    private Myvolunteer myvolunteer;
    private Mygroup mygroup;
    @Autowired
    private cn.jxust.dq.student.service.mygroupservice mygroupservice;
    @Autowired
    private Items item;
    @Autowired
    private mysocialservice mysocialservice;
    @Autowired
    private Mysocial mysocial;
    @Autowired
    private Items items;
    @Autowired
    private cn.jxust.dq.student.service.mycreativeservice mycreativeservice;
    @Autowired
    private cn.jxust.dq.student.service.myimportantservice myimportantservice;
    @Autowired
    private myqualityservice myqualityservice;
    @Autowired
    private myvolunteerservice myvolunteerservice;
    @Autowired
    private Myimportant myimportant;
    @Autowired
    private Mycreative mycreative;
    @RequestMapping("/deletepic")
    public String deletepic(HttpServletRequest request, Model model) {
        String mygrouppic = request.getParameter("mygrouppic");
        //先获得username再获得id；
        String name =request.getParameter("username");
        System.out.println("name = " + name);
        User userByUsername = userService.getUserByUsername(name);
        int userid=userByUsername.getId();
        //输出userid；
        System.out.println("userid = " + userid);
        System.out.println("mygrouppic = " + mygrouppic);
        //在对应的mygroupservice中删除把对应的图片删除
        mygroupservice.deletebygrouppic(mygrouppic);
        //现在为principal而努力，装配好；根据传过来的图片名称，可以获取对应的数据；
        User userById = userService.getUserById(userid);
        String username = userById.getUsername();
        String password = userById.getPassword();
        String college = userById.getCollege();
        int classes = userById.getClassess();
        String idnumber = userById.getIdnumber();
        String[] socialpics = new String[1000];
        String[] grouppics = new String[1000];
        String[] qualitypics = new String[1000];
        String[] creativepics = new String[1000];
        String[] importantpics = new String[1000];
        String[] volunteerpics =new String[1000];
        //获取删除后其余的图片名称
        //先获取由userid获得的items，应该是只有一个
        List<Items> findbyuserid = itemsService.findbyuserid(userid);
        if(findbyuserid!=null)
        {
            item=findbyuserid.get(0);
            List<Mygroup> mygroups = mygroupservice.findbyitemsid(item.getId());
            for (int i = 0; i <mygroups.size() ; i++) {
                grouppics[i]=mygroups.get(i).getMygrouppic();
            }
            List<Mysocial> mysocials = mysocialservice.findbyitemsid(item.getId());
            if(mysocials !=null)
            {
                for(int i=0;i<mysocials.size();i++)
                {
                    socialpics[i]=mysocials.get(i).getMysocialpic();
                }
            }
            //根据itemid获得creative的对象，然后取出里面的照片
            List<Myimportant> mycreatives = myimportantservice.findbyitemsid(item.getId());
            if(mycreatives !=null)
            {
                for(int i=0;i<mycreatives.size();i++)
                {
                    importantpics[i]=mycreatives.get(i).getMyimportantpic();
                }
            }

            //根据itemid获得quality的对象，然后取出里面的照片
            List<Myquality> myqualities =myqualityservice.findbyitemsid(item.getId());
            if(myqualities !=null)
            {
                for(int i=0;i<myqualities.size();i++)
                {
                    qualitypics[i]=myqualities.get(i).getMyqualitypic();
                }
            }
            //根据itemid获得的对象，然后取出里面的照片
            List<Myvolunteer> myvolunteers =myvolunteerservice.findbyitemsid(item.getId());
            if(myvolunteers !=null)
            {
                for(int i=0;i<myvolunteers.size();i++)
                {
                    volunteerpics[i]=myvolunteers.get(i).getMyvolunteerpic();
                }
            }
            List<Mycreative> mycreativeList = mycreativeservice.findbyitemsid(item.getId());
            if(mycreativeList!=null) {
                for (int i = 0; i < mycreativeList.size(); i++) {
                    creativepics[i] = mycreativeList.get(i).getMycreativepic();
                }
            }
        }

        activityitems = new activityitems(username, password, userid, college, classes, idnumber, grouppics);
        //还要设置大文本，直接设置items就可以了；
        activityitems.setMysocialpic(socialpics);
        activityitems.setMycreativepic(creativepics);
        activityitems.setMyimportantpic(importantpics);
        activityitems.setMyqualitypic(qualitypics);
        activityitems.setMyvolunteerpic(volunteerpics);
        activityitems.setItem(item);
        model.addAttribute("principal",activityitems);
        return "forward:/pages/secondcourse.jsp";
    }
    @RequestMapping("/deletesocialpic")
    public String deletesocialpic(HttpServletRequest request, Model model) {
        String mysocialpic = request.getParameter("mysocialpic");
        //先获得username再获得id；
        String name =request.getParameter("username");
        System.out.println("name = " + name);
        User userByUsername = userService.getUserByUsername(name);
        int userid=userByUsername.getId();
        //输出userid；
        System.out.println("userid = " + userid);
        System.out.println("mygrouppic = " + mysocialpic);
        //在对应的mygroupservice中删除把对应的图片删除
        mysocialservice.deletebygrouppic(mysocialpic);
        //现在为principal而努力，装配好；根据传过来的图片名称，可以获取对应的数据；
        User userById = userService.getUserById(userid);
        String username = userById.getUsername();
        String password = userById.getPassword();
        String college = userById.getCollege();
        int classes = userById.getClassess();
        String idnumber = userById.getIdnumber();

        String[] socialpics = new String[1000];
        String[] grouppics = new String[1000];
        String[] qualitypics = new String[1000];
        String[] creativepics = new String[1000];
        String[] importantpics = new String[1000];
        String[] volunteerpics =new String[1000];
        //获取删除后其余的图片名称
        //先获取由userid获得的items，应该是只有一个
        List<Items> findbyuserid = itemsService.findbyuserid(userid);
        if(findbyuserid!=null)
        {
            item=findbyuserid.get(0);
            List<Mygroup> mygroups = mygroupservice.findbyitemsid(item.getId());
            for (int i = 0; i <mygroups.size() ; i++) {
                grouppics[i]=mygroups.get(i).getMygrouppic();
            }
            List<Mysocial> mysocials = mysocialservice.findbyitemsid(item.getId());
            if(mysocials !=null)
            {
                for(int i=0;i<mysocials.size();i++)
                {
                    socialpics[i]=mysocials.get(i).getMysocialpic();
                }
            }
            //根据itemid获得creative的对象，然后取出里面的照片
            List<Myimportant> mycreatives = myimportantservice.findbyitemsid(item.getId());
            if(mycreatives !=null)
            {
                for(int i=0;i<mycreatives.size();i++)
                {
                    importantpics[i]=mycreatives.get(i).getMyimportantpic();
                }
            }

            //根据itemid获得quality的对象，然后取出里面的照片
            List<Myquality> myqualities =myqualityservice.findbyitemsid(item.getId());
            if(myqualities !=null)
            {
                for(int i=0;i<myqualities.size();i++)
                {
                    qualitypics[i]=myqualities.get(i).getMyqualitypic();
                }
            }
            //根据itemid获得的对象，然后取出里面的照片
            List<Myvolunteer> myvolunteers =myvolunteerservice.findbyitemsid(item.getId());
            if(myvolunteers !=null)
            {
                for(int i=0;i<myvolunteers.size();i++)
                {
                    volunteerpics[i]=myvolunteers.get(i).getMyvolunteerpic();
                }
            }
            List<Mycreative> mycreativeList = mycreativeservice.findbyitemsid(item.getId());
            if(mycreativeList!=null) {
                for (int i = 0; i < mycreativeList.size(); i++) {
                    creativepics[i] = mycreativeList.get(i).getMycreativepic();
                }
            }
        }

        activityitems = new activityitems(username, password, userid, college, classes, idnumber, grouppics);
        //还要设置大文本，直接设置items就可以了；
        activityitems.setItem(findbyuserid.get(0));
        activityitems.setMysocialpic(socialpics);
        activityitems.setMycreativepic(creativepics);
        activityitems.setMyimportantpic(importantpics);
        activityitems.setMyqualitypic(qualitypics);
        activityitems.setMyvolunteerpic(volunteerpics);
        activityitems.setItem(item);
        model.addAttribute("principal",activityitems);
        return "forward:/pages/secondcourse.jsp";
    }
    @RequestMapping("/deletemyvolunteerpic")
    public String deletemyvolunteerpic(HttpServletRequest request, Model model) {
        String myvolunteerpic = request.getParameter("myvolunteerpic");
        //先获得username再获得id；
        String name =request.getParameter("username");
        System.out.println("name = " + name);
        User userByUsername = userService.getUserByUsername(name);
        int userid=userByUsername.getId();
        //输出userid；
        System.out.println("userid = " + userid);
        System.out.println("mygrouppic = " + myvolunteerpic);
        //在对应的mygroupservice中删除把对应的图片删除
        myvolunteerservice.deletebypic(myvolunteerpic);

        //现在为principal而努力，装配好；根据传过来的图片名称，可以获取对应的数据；
        User userById = userService.getUserById(userid);
        String username = userById.getUsername();
        String password = userById.getPassword();
        String college = userById.getCollege();
        int classes = userById.getClassess();
        String idnumber = userById.getIdnumber();
        String[] socialpics = new String[1000];
        String[] grouppics = new String[1000];
        String[] qualitypics = new String[1000];
        String[] creativepics = new String[1000];
        String[] importantpics = new String[1000];
        String[] volunteerpics =new String[1000];
        List<Items> findbyuserid = itemsService.findbyuserid(userid);
        if(findbyuserid!=null)
        {
            item=findbyuserid.get(0);
            List<Mygroup> mygroups = mygroupservice.findbyitemsid(item.getId());
            for (int i = 0; i <mygroups.size() ; i++) {
                grouppics[i]=mygroups.get(i).getMygrouppic();
            }
            List<Mysocial> mysocials = mysocialservice.findbyitemsid(item.getId());
            if(mysocials !=null)
            {
                for(int i=0;i<mysocials.size();i++)
                {
                    socialpics[i]=mysocials.get(i).getMysocialpic();
                }
            }
            //根据itemid获得creative的对象，然后取出里面的照片
            List<Myimportant> mycreatives = myimportantservice.findbyitemsid(item.getId());
            if(mycreatives !=null)
            {
                for(int i=0;i<mycreatives.size();i++)
                {
                    importantpics[i]=mycreatives.get(i).getMyimportantpic();
                }
            }

            //根据itemid获得quality的对象，然后取出里面的照片
            List<Myquality> myqualities =myqualityservice.findbyitemsid(item.getId());
            if(myqualities !=null)
            {
                for(int i=0;i<myqualities.size();i++)
                {
                    qualitypics[i]=myqualities.get(i).getMyqualitypic();
                }
            }
            //根据itemid获得的对象，然后取出里面的照片
            List<Myvolunteer> myvolunteers =myvolunteerservice.findbyitemsid(item.getId());
            if(myvolunteers !=null)
            {
                for(int i=0;i<myvolunteers.size();i++)
                {
                    volunteerpics[i]=myvolunteers.get(i).getMyvolunteerpic();
                }
            }
            List<Mycreative> mycreativeList = mycreativeservice.findbyitemsid(item.getId());
            if(mycreativeList!=null) {
                for (int i = 0; i < mycreativeList.size(); i++) {
                    creativepics[i] = mycreativeList.get(i).getMycreativepic();
                }
            }
        }

        activityitems = new activityitems(username, password, userid, college, classes, idnumber, grouppics);
        //还要设置大文本，直接设置items就可以了；
        activityitems.setItem(findbyuserid.get(0));
        activityitems.setMysocialpic(socialpics);
        activityitems.setMycreativepic(creativepics);
        activityitems.setMyimportantpic(importantpics);
        activityitems.setMyqualitypic(qualitypics);
        activityitems.setMyvolunteerpic(volunteerpics);
        model.addAttribute("principal",activityitems);
        return "forward:/pages/secondcourse.jsp";
    }
    @RequestMapping("/deletemycreativepic")
    public String deletemycreativepic(HttpServletRequest request, Model model) {
        String mycreativepic = request.getParameter("mycreativepic");
        //先获得username再获得id；
        String name =request.getParameter("username");
        System.out.println("name = " + name);
        User userByUsername = userService.getUserByUsername(name);
        int userid=userByUsername.getId();
        //输出userid；
        System.out.println("userid = " + userid);
        System.out.println("mygrouppic = " + mycreativepic);
        //在对应的mygroupservice中删除把对应的图片删除
        mycreativeservice.deletebypic(mycreativepic);

        //现在为principal而努力，装配好；根据传过来的图片名称，可以获取对应的数据；
        User userById = userService.getUserById(userid);
        String username = userById.getUsername();
        String password = userById.getPassword();
        String college = userById.getCollege();
        int classes = userById.getClassess();
        String idnumber = userById.getIdnumber();

        String[] socialpics = new String[1000];
        String[] grouppics = new String[1000];
        String[] qualitypics = new String[1000];
        String[] creativepics = new String[1000];
        String[] importantpics = new String[1000];
        String[] volunteerpics =new String[1000];
        List<Items> findbyuserid = itemsService.findbyuserid(userid);
        if(findbyuserid!=null)
        {
            item=findbyuserid.get(0);
            List<Mygroup> mygroups = mygroupservice.findbyitemsid(item.getId());
            for (int i = 0; i <mygroups.size() ; i++) {
                grouppics[i]=mygroups.get(i).getMygrouppic();
            }
            List<Mysocial> mysocials = mysocialservice.findbyitemsid(item.getId());
            if(mysocials !=null)
            {
                for(int i=0;i<mysocials.size();i++)
                {
                    socialpics[i]=mysocials.get(i).getMysocialpic();
                }
            }
            //根据itemid获得creative的对象，然后取出里面的照片
            List<Myimportant> mycreatives = myimportantservice.findbyitemsid(item.getId());
            if(mycreatives !=null)
            {
                for(int i=0;i<mycreatives.size();i++)
                {
                    importantpics[i]=mycreatives.get(i).getMyimportantpic();
                }
            }

            //根据itemid获得quality的对象，然后取出里面的照片
            List<Myquality> myqualities =myqualityservice.findbyitemsid(item.getId());
            if(myqualities !=null)
            {
                for(int i=0;i<myqualities.size();i++)
                {
                    qualitypics[i]=myqualities.get(i).getMyqualitypic();
                }
            }
            //根据itemid获得的对象，然后取出里面的照片
            List<Myvolunteer> myvolunteers =myvolunteerservice.findbyitemsid(item.getId());
            if(myvolunteers !=null)
            {
                for(int i=0;i<myvolunteers.size();i++)
                {
                    volunteerpics[i]=myvolunteers.get(i).getMyvolunteerpic();
                }
            }
            List<Mycreative> mycreativeList = mycreativeservice.findbyitemsid(item.getId());
            if(mycreativeList!=null) {
                for (int i = 0; i < mycreativeList.size(); i++) {
                    creativepics[i] = mycreativeList.get(i).getMycreativepic();
                }
            }
        }

        activityitems = new activityitems(username, password, userid, college, classes, idnumber, grouppics);
        //还要设置大文本，直接设置items就可以了；
        activityitems.setItem(findbyuserid.get(0));
        activityitems.setMysocialpic(socialpics);
        activityitems.setMycreativepic(creativepics);
        activityitems.setMyimportantpic(importantpics);
        activityitems.setMyqualitypic(qualitypics);
        activityitems.setMyvolunteerpic(volunteerpics);
        model.addAttribute("principal",activityitems);
        return "forward:/pages/secondcourse.jsp";
    }
    @RequestMapping("/deletemyimportantpic")
    public String deletemyimportantpic(HttpServletRequest request, Model model) {
        String myimportantpic = request.getParameter("myimportantpic");
        //先获得username再获得id；
        String name =request.getParameter("username");
        System.out.println("name = " + name);
        User userByUsername = userService.getUserByUsername(name);
        int userid=userByUsername.getId();
        //输出userid；
        System.out.println("userid = " + userid);
        System.out.println("mygrouppic = " + myimportantpic);
        //在对应的mygroupservice中删除把对应的图片删除
        myimportantservice.deletebypic(myimportantpic);

        //现在为principal而努力，装配好；根据传过来的图片名称，可以获取对应的数据；
        User userById = userService.getUserById(userid);
        String username = userById.getUsername();
        String password = userById.getPassword();
        String college = userById.getCollege();
        int classes = userById.getClassess();
        String idnumber = userById.getIdnumber();

        String[] socialpics = new String[1000];
        String[] grouppics = new String[1000];
        String[] qualitypics = new String[1000];
        String[] creativepics = new String[1000];
        String[] importantpics = new String[1000];
        String[] volunteerpics =new String[1000];
        List<Items> findbyuserid = itemsService.findbyuserid(userid);
        if(findbyuserid!=null)
        {
            item=findbyuserid.get(0);
            List<Mygroup> mygroups = mygroupservice.findbyitemsid(item.getId());
            for (int i = 0; i <mygroups.size() ; i++) {
                grouppics[i]=mygroups.get(i).getMygrouppic();
            }
            List<Mysocial> mysocials = mysocialservice.findbyitemsid(item.getId());
            if(mysocials !=null)
            {
                for(int i=0;i<mysocials.size();i++)
                {
                    socialpics[i]=mysocials.get(i).getMysocialpic();
                }
            }
            //根据itemid获得creative的对象，然后取出里面的照片
            List<Myimportant> mycreatives = myimportantservice.findbyitemsid(item.getId());
            if(mycreatives !=null)
            {
                for(int i=0;i<mycreatives.size();i++)
                {
                    importantpics[i]=mycreatives.get(i).getMyimportantpic();
                }
            }

            //根据itemid获得quality的对象，然后取出里面的照片
            List<Myquality> myqualities =myqualityservice.findbyitemsid(item.getId());
            if(myqualities !=null)
            {
                for(int i=0;i<myqualities.size();i++)
                {
                    qualitypics[i]=myqualities.get(i).getMyqualitypic();
                }
            }
            //根据itemid获得的对象，然后取出里面的照片
            List<Myvolunteer> myvolunteers =myvolunteerservice.findbyitemsid(item.getId());
            if(myvolunteers !=null)
            {
                for(int i=0;i<myvolunteers.size();i++)
                {
                    volunteerpics[i]=myvolunteers.get(i).getMyvolunteerpic();
                }
            }
            List<Mycreative> mycreativeList = mycreativeservice.findbyitemsid(item.getId());
            if(mycreativeList!=null) {
                for (int i = 0; i < mycreativeList.size(); i++) {
                    creativepics[i] = mycreativeList.get(i).getMycreativepic();
                }
            }
        }

        activityitems = new activityitems(username, password, userid, college, classes, idnumber, grouppics);
        //还要设置大文本，直接设置items就可以了；
        activityitems.setItem(findbyuserid.get(0));
        activityitems.setMysocialpic(socialpics);
        activityitems.setMycreativepic(creativepics);
        activityitems.setMyimportantpic(importantpics);
        activityitems.setMyqualitypic(qualitypics);
        activityitems.setMyvolunteerpic(volunteerpics);
        model.addAttribute("principal",activityitems);
        return "forward:/pages/secondcourse.jsp";
    }
    @RequestMapping("/deletemyqualitypic")
    public String deletemyqualitypic(HttpServletRequest request, Model model) {
        String myqualitypic = request.getParameter("myqualitypic");
        //先获得username再获得id；
        String name =request.getParameter("username");
        System.out.println("name = " + name);
        User userByUsername = userService.getUserByUsername(name);
        int userid=userByUsername.getId();
        //输出userid；
        System.out.println("userid = " + userid);
        System.out.println("mygrouppic = " + myqualitypic);
        //在对应的mygroupservice中删除把对应的图片删除
        myimportantservice.deletebypic(myqualitypic);

        //现在为principal而努力，装配好；根据传过来的图片名称，可以获取对应的数据；
        User userById = userService.getUserById(userid);
        String username = userById.getUsername();
        String password = userById.getPassword();
        String college = userById.getCollege();
        int classes = userById.getClassess();
        String idnumber = userById.getIdnumber();

        String[] socialpics = new String[1000];
        String[] grouppics = new String[1000];
        String[] qualitypics = new String[1000];
        String[] creativepics = new String[1000];
        String[] importantpics = new String[1000];
        String[] volunteerpics =new String[1000];
        List<Items> findbyuserid = itemsService.findbyuserid(userid);
        if(findbyuserid!=null)
        {
            item=findbyuserid.get(0);
            List<Mygroup> mygroups = mygroupservice.findbyitemsid(item.getId());
            for (int i = 0; i <mygroups.size() ; i++) {
                grouppics[i]=mygroups.get(i).getMygrouppic();
            }
            List<Mysocial> mysocials = mysocialservice.findbyitemsid(item.getId());
            if(mysocials !=null)
            {
                for(int i=0;i<mysocials.size();i++)
                {
                    socialpics[i]=mysocials.get(i).getMysocialpic();
                }
            }
            //根据itemid获得creative的对象，然后取出里面的照片
            List<Myimportant> mycreatives = myimportantservice.findbyitemsid(item.getId());
            if(mycreatives !=null)
            {
                for(int i=0;i<mycreatives.size();i++)
                {
                    importantpics[i]=mycreatives.get(i).getMyimportantpic();
                }
            }

            //根据itemid获得quality的对象，然后取出里面的照片
            List<Myquality> myqualities =myqualityservice.findbyitemsid(item.getId());
            if(myqualities !=null)
            {
                for(int i=0;i<myqualities.size();i++)
                {
                    qualitypics[i]=myqualities.get(i).getMyqualitypic();
                }
            }
            //根据itemid获得的对象，然后取出里面的照片
            List<Myvolunteer> myvolunteers =myvolunteerservice.findbyitemsid(item.getId());
            if(myvolunteers !=null)
            {
                for(int i=0;i<myvolunteers.size();i++)
                {
                    volunteerpics[i]=myvolunteers.get(i).getMyvolunteerpic();
                }
            }
            List<Mycreative> mycreativeList = mycreativeservice.findbyitemsid(item.getId());
            if(mycreativeList!=null) {
                for (int i = 0; i < mycreativeList.size(); i++) {
                    creativepics[i] = mycreativeList.get(i).getMycreativepic();
                }
            }
        }

        activityitems = new activityitems(username, password, userid, college, classes, idnumber, grouppics);
        //还要设置大文本，直接设置items就可以了；
        activityitems.setItem(findbyuserid.get(0));
        activityitems.setMysocialpic(socialpics);
        activityitems.setMycreativepic(creativepics);
        activityitems.setMyimportantpic(importantpics);
        activityitems.setMyqualitypic(qualitypics);
        activityitems.setMyvolunteerpic(volunteerpics);
        model.addAttribute("principal",activityitems);
        return "forward:/pages/secondcourse.jsp";
    }
}
