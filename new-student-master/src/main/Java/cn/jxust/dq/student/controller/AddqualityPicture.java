package cn.jxust.dq.student.controller;

import cn.jxust.dq.student.entity.*;
import cn.jxust.dq.student.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/1.
 */
@Controller
public class AddqualityPicture {
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
    private Myquality myquality;
    @RequestMapping(value = "/addmyqualitypic")
    public String addimportantpic(MultipartFile myqualitypic, Model model, HttpServletRequest request) throws IOException {
        String filestr=myqualitypic.getOriginalFilename();
        int userid = Integer.parseInt(request.getParameter("userid"));
        User userById = userService.getUserById(userid);
        //新的文件名，防止文件重名；
        String filename = (UUID.randomUUID().toString() + filestr.substring(filestr.lastIndexOf(".")));
        System.out.println("filename = " + filename);
        //先定义好，用来装图片名称
        String[] socialpics = new String[30];
        String[] grouppics = new String[30];
        String[] qualitypics = new String[30];
        String[] creativepics = new String[30];
        String[] importantpics = new String[30];
        String[] volunteerpics =new String[30];
        //由于是添加社会实践图片，所以其他的图片可以先放入到包装类中
        List<Items> findgroup= itemsService.findbyuserid(userid);

        if(findgroup!=null)
        {
            item=findgroup.get(0);
            List<Mygroup> mygroups = mygroupservice.findbyitemsid(findgroup.get(0).getId());
            if(mygroups!=null) {
                for (int i = 0; i < mygroups.size(); i++) {
                    grouppics[i] = mygroups.get(i).getMygrouppic();
                }
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
            List<Mycreative> mycreatives = mycreativeservice.findbyitemsid(item.getId());
            if(mycreatives !=null)
            {
                for(int i=0;i<mycreatives.size();i++)
                {
                    creativepics[i]=mycreatives.get(i).getMycreativepic();
                }
            }

            //根据itemid获得quality的对象，然后取出里面的照片
            List<Myimportant> myimportants =myimportantservice.findbyitemsid(item.getId());
            if(myimportants !=null)
            {
                for(int i=0;i<myimportants.size();i++)
                {
                    importantpics[i]=myimportants.get(i).getMyimportantpic();
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
        }
        //将图片保存在虚拟路径中
        if (filename.trim() != "") {
            myqualitypic.transferTo(new File("C:\\Users\\Administrator\\Desktop\\new-student-master\\new-student-master\\src\\main\\webapp\\picture\\" + filename));
            //将路径保存在数据库中
            //获得用户id，并保存到图片路径中；
            myquality.setMyqualitypic(filename);
            //如果是有相应的item则根据item取出pics，若没有，则创建一个；
            List<Items> items= itemsService.findbyuserid(userid);
            if(items!=null) {
                //按照userid找出相应的图片项目


                //通过userid获得项目对象以便pricinpal中传到前端
                Items   item = items.get(0);
                myquality.setItemsId(item.getId());
                //将mygroup插入到数据库
                myqualityservice.insert(myquality);
                //要将图片取出来放入到数组中然后组装pricinpal
                //首先根据itemid获得mygroup
                List<Myquality> myqualities = myqualityservice.findbyitemsid(item.getId());
                if(myqualities!=null) {
                    for (int i = 0; i <myqualities.size(); i++) {
                        importantpics[i]=myqualities.get(i).getMyqualitypic();
                    }
                }
            }

        }
        //将传过来的数据装配到activityitems中
        activityitems.setUsername(userById.getUsername());
        activityitems.setPassword(userById.getPassword());
        activityitems.setIdnumber(userById.getIdnumber());
        activityitems.setCollege(userById.getCollege());
        activityitems.setClasses(userById.getClassess());
        activityitems.setUserid(userById.getId());
        activityitems.setMygrouppic(grouppics);
        activityitems.setMysocialpic(socialpics);
        activityitems.setMycreativepic(creativepics);
        activityitems.setMyimportantpic(importantpics);
        activityitems.setMyqualitypic(qualitypics);
        activityitems.setMyvolunteerpic(volunteerpics);
        activityitems.setItems(items);

        model.addAttribute("principal", activityitems);
        //跳转到编辑目录,并带上项目的id

        return "forward:/pages/secondcourse.jsp";
    }
}
