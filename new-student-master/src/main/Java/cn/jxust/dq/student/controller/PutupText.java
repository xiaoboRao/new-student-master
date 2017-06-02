package cn.jxust.dq.student.controller;

import cn.jxust.dq.student.entity.*;
import cn.jxust.dq.student.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/5/30.
 */
@Controller
public class PutupText {

    @Autowired
    private ItemsService itemsService;
    @Autowired
    private IUserService userService;

    @Autowired
    private cn.jxust.dq.student.entity.activityitems activityitems;
    @Autowired
    private Mygroup mygroup;
    @Autowired
    private cn.jxust.dq.student.service.mygroupservice mygroupservice;
    @Autowired
    private Items item;
    @Autowired
    private cn.jxust.dq.student.service.mysocialservice mysocialservice;
    @Autowired
    private Mysocial mysocial;

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
    @RequestMapping("/putuptext")
    public String putupText(HttpServletRequest request, Model model) {
        int userid = Integer.parseInt(request.getParameter("userid"));
        //按照userid找到user；
        User userById = userService.getUserById(userid);
        System.out.println("userid = " + userid);
        String mygroup = request.getParameter("mygroup");
        String mysocial = request.getParameter("mysocial");
        String myvolunteer = request.getParameter("myvolunteer");
        String mycreative = request.getParameter("mycreative");
        String myimportant = request.getParameter("myimportant");
        String myquality = request.getParameter("myquality");

        String[] pics=new String[1000];
        String[] socialpics=new String[1000];
        String[] creativepics=new String[1000];
        String[] importantpics=new String[1000];
        String[] qualitypics=new String[1000];
        String[] volunteerpics=new String[1000];
        //按照userid找到属于这个学生的items,更新，如果没有则创建一个；
            List<Items> list = itemsService.findbyuserid(userid);
        if(list!=null) {

                //还要判断图片到底有没有
                item=list.get(0);
                //获得团学的对象，取出里面的图片
                List<Mygroup> findbyitemsid = mygroupservice.findbyitemsid(item.getId());
                if (findbyitemsid != null) {
                    for (int i = 0; i < findbyitemsid.size(); i++) {
                        pics[i] = findbyitemsid.get(i).getMygrouppic();
                    }
                    //根据itemid获得社会履历的对象，然后取出里面的照片
                    List<Mysocial> mysocials = mysocialservice.findbyitemsid(item.getId());
                    if(mysocials !=null)
                    {
                        for(int i=0;i<mysocials.size();i++)
                        {
                            socialpics[i]=mysocials.get(i).getMysocialpic();
                        }
                    }
                    //根据itemid获得creative的对象，然后取出里面的照片
                    List<Mycreative> mycreatives = mycreativeservice.findbyitemsid(item.getId());
                    if(mycreatives !=null)
                    {
                        for(int i=0;i<mycreatives.size();i++)
                        {
                            creativepics[i]=mycreatives.get(i).getMycreativepic();
                        }
                    }
                    //根据itemid获得important的对象，然后取出里面的照片
                    List<Myimportant> myimportants = myimportantservice.findbyitemsid(item.getId());
                    if(myimportants !=null)
                    {
                        for(int i=0;i<myimportants.size();i++)
                        {
                            importantpics[i]=myimportants.get(i).getMyimportantpic();
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
                    List<Myvolunteer> myvolunteers = myvolunteerservice.findbyitemsid(item.getId());
                    if(myvolunteers !=null)
                    {
                        for(int i=0;i<myvolunteers.size();i++)
                        {
                            volunteerpics[i]=myvolunteers.get(i).getMyvolunteerpic();
                        }
                    }

            }
            item.setMygroup(mygroup);
            item.setMycreative(mycreative);
            item.setMyquality(myquality);
            item.setMysocial(mysocial);
            item.setMyvolunteer(myvolunteer);
            item.setMyimportant(myimportant);
            item.setUserid(userid);
            itemsService.updateitems(item);
            //将传过来的数据装配到activityitems中
        }
        else {
            //如果数据库里没有这个东西，则创建一个，

            item.setUserid(userid);

            item.setMygroup(mygroup);
            item.setMycreative(mycreative);
            item.setMyquality(myquality);
            item.setMysocial(mysocial);
            item.setMyvolunteer(myvolunteer);
            item.setMyimportant(myimportant);
            item.setUserid(userid);
            itemsService.insert(item);
           //装配activityitems
        }
        activityitems = new activityitems(userById.getUsername(), userById.getPassword(), userById.getId(), userById.getCollege(), userById.getClassess(), userById.getIdnumber(), pics);
        activityitems.setItems(item);
        activityitems.setMysocialpic(socialpics);
        activityitems.setMycreativepic(creativepics);
        activityitems.setMyimportantpic(importantpics);
        activityitems.setMyqualitypic(qualitypics);
        activityitems.setMyvolunteerpic(volunteerpics);
        model.addAttribute("principal", activityitems);
        return "forward:/pages/secondcourse.jsp";
    }
}
