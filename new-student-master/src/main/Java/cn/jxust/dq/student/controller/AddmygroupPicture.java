package cn.jxust.dq.student.controller;

import cn.jxust.dq.student.entity.*;
import cn.jxust.dq.student.service.*;
import org.apache.logging.log4j.core.helpers.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/5/28.
 */
@Controller
public class AddmygroupPicture {
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private IUserService userService;
    @Autowired
    private activityitems activityitems;
    @Autowired
    private Mygroup mygroup;
    @Autowired
    private mygroupservice mygroupservice;

    @Autowired
    private Items item;
    @Autowired
    private mysocialservice mysocialservice;
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
    @RequestMapping(value = "/addpicture")
    public String addpicture(MultipartFile items_pic, Model model, HttpServletRequest request) throws IOException {
        String filestr=items_pic.getOriginalFilename();
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
        List<Items> findgroup= itemsService.findbyuserid(userid);

        if(findgroup!=null) {
            item = findgroup.get(0);

            List<Mysocial> mysocials = mysocialservice.findbyitemsid(item.getId());
            if (mysocials != null) {
                for (int i = 0; i < mysocials.size(); i++) {
                    socialpics[i] = mysocials.get(i).getMysocialpic();
                }
            }
            //根据itemid获得creative的对象，然后取出里面的照片
            List<Myimportant> mycreatives = myimportantservice.findbyitemsid(item.getId());
            if (mycreatives != null) {
                for (int i = 0; i < mycreatives.size(); i++) {
                    importantpics[i] = mycreatives.get(i).getMyimportantpic();
                }
            }

            //根据itemid获得quality的对象，然后取出里面的照片
            List<Myquality> myqualities = myqualityservice.findbyitemsid(item.getId());
            if (myqualities != null) {
                for (int i = 0; i < myqualities.size(); i++) {
                    qualitypics[i] = myqualities.get(i).getMyqualitypic();
                }
            }
            //根据itemid获得的对象，然后取出里面的照片
            List<Myvolunteer> myvolunteers = myvolunteerservice.findbyitemsid(item.getId());
            if (myvolunteers != null) {
                for (int i = 0; i < myvolunteers.size(); i++) {
                    volunteerpics[i] = myvolunteers.get(i).getMyvolunteerpic();
                }
            }
            List<Mycreative> mycreativeList = mycreativeservice.findbyitemsid(item.getId());
            if(mycreativeList!=null) {
                for (int i = 0; i < mycreativeList.size(); i++) {
                    creativepics[i] = mycreativeList.get(i).getMycreativepic();
                }
            }
        }
            //将图片保存在虚拟路径中
            if (filename.trim() != "") {
                items_pic.transferTo(new File("C:\\Users\\Administrator\\Desktop\\new-student-master\\new-student-master\\src\\main\\webapp\\picture\\" + filename));
                //将路径保存在数据库中
                //获得用户id，并保存到图片路径中；
                mygroup.setMygrouppic(filename);
              //如果是有相应的item则根据item取出pics，若没有，则创建一个；
                List<cn.jxust.dq.student.entity.Items> list1 = itemsService.findbyuserid(userid);
                if(list1!=null) {
                    //按照userid找出相应的图片项目

                    //通过userid获得项目对象以便pricinpal中传到前端
                    item = list1.get(0);
                    mygroup.setItemsId(item.getId());
                    //将mygroup插入到数据库
                    mygroupservice.insert(mygroup);
                    //要将图片取出来放入到数组中然后组装pricinpal
                    //首先根据itemid获得mygroup
                    List<Mygroup> mygroups = mygroupservice.findbyitemsid(item.getId());
                    if(mygroups.size()>0) {
                        for (int i = 0; i <mygroups.size(); i++) {
                            grouppics[i]=mygroups.get(i).getMygrouppic();
                        }
                    }
                }

                //查看数据库是否有mygroup
                List<Mygroup> findbyitemsid = mygroupservice.findbyitemsid(item.getId());
                System.out.println("findbyitemsid = " + findbyitemsid);
                System.out.println(userid);

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
        activityitems.setItems(item);
            model.addAttribute("principal", activityitems);
            //跳转到编辑目录,并带上项目的id

        return "forward:/pages/secondcourse.jsp";
    }

}
