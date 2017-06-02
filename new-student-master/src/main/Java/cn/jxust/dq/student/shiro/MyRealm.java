package cn.jxust.dq.student.shiro;

import cn.jxust.dq.student.dao.MygroupMapper;
import cn.jxust.dq.student.entity.*;
import cn.jxust.dq.student.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;

import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/5/15.
 */
public class MyRealm extends AuthorizingRealm{

    @Autowired
    private  IUserService iUserService;
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private MygroupExample mygroupExample;
    @Autowired
    private MygroupMapper mygroupMapper;
    @Autowired
    private mygroupservice mygroupservice;
    @Autowired
    private Items item;
    @Autowired
    private mysocialservice mysocialservice;
    @Autowired
    private mycreativeservice mycreativeservice;
    @Autowired
    private myimportantservice myimportantservice;
    @Autowired
    private myqualityservice myqualityservice;
  @Autowired
  private myvolunteerservice myvolunteerservice;
    //1.doGetAuthenticationInfo获取认证消息，如果有数据则返回指定的类型
    //2.SimpleAuthentiactor 封装名字和密码；
    //3.Token参数，就是我们要认证的参数

    //1.用于授权

    //2.用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // token是用户输入的用户名和密码
        // 第一步从token中取出用户名
        String userCode = (String) token.getPrincipal();

        // 第二步：根据用户输入的userCode从数据库查询
        User user = null;
        try {
            user = iUserService.getUserByUsername(userCode);
            if(user==null){//
                throw  new UnknownAccountException();

            }
            //获取数据库加密后的密码
            String password = user.getPassword();

            //加点盐,这是给从前端传进来的密码加的盐，还要给数据库得密码加盐
            ByteSource salt=ByteSource.Util.bytes(userCode);
//            String college=user.getCollege();
//            int classes=user.getClassess();
//            String idnumber=user.getIdnumber();
            activityuser activityuser = new activityuser();
            activityuser.setUserid(user.getId());
            activityuser.setUsername(userCode);
           activityuser.setClasses(user.getClassess());
            activityuser.setCollege(user.getCollege());
            activityuser.setIdnumber(user.getIdnumber());
            //根据userid获得items，然后获得文件名放入数组中；
            String[] pics=new String[30];
            String[] socialpics=new String[30];
            String[] creativepics=new String[30];
            String[] importantpics=new String[30];
            String[] qualitypics=new String[30];
            String[] volunteerpics=new String[30];


            List<Items> list=itemsService.findbyuserid(user.getId());
            //根据itemsid获得mygroup的所有图片
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
                    List<Myvolunteer> myvolunteers =myvolunteerservice.findbyitemsid(item.getId());
                    if(myvolunteers !=null)
                    {
                        for(int i=0;i<myvolunteers.size();i++)
                        {
                            volunteerpics[i]=myvolunteers.get(i).getMyvolunteerpic();
                        }
                    }

                }
            }
                //如果没有建立item。则创建一个；
                else {
                    item.setUserid(user.getId());
                    itemsService.insert(item);
                }
            activityuser.setMygrouppic(pics);
            activityuser.setMysocialpic(socialpics);
            activityuser.setMycreativepic(creativepics);
            activityuser.setMyimportantpic(importantpics);
            activityuser.setMyqualitypic(qualitypics);
            activityuser.setMyvolunteerpic(volunteerpics);
            activityuser.setItem(item);

            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                    activityuser, password,salt, this.getName());
            return simpleAuthenticationInfo;
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // 如果查询不到返回null


        // 如果查询到返回认证信息AuthenticationInfo

//        //activeUser就是用户身份信息
//        ActiveUser activeUser = new ActiveUser();
//
//        activeUser.setUserid(sysUser.getId());
//        activeUser.setUsercode(sysUser.getUsercode());
//        activeUser.setUsername(sysUser.getUsername());
//        //..
//
//        //根据用户id取出菜单
//        List<SysPermission> menus  = null;
//        try {
//            //通过service取出菜单
//            menus = sysService.findMenuListByUserId(sysUser.getId());
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        //将用户菜单 设置到activeUser
//        activeUser.setMenus(menus);

        //将activeUser设置simpleAuthenticationInfo

    return  null;

    }

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("\"查看是否有更新的权利\" = " + "查看是否有更新的权利");
        //获取主身份信息
        activityuser activityuser = (cn.jxust.dq.student.entity.activityuser) principals.getPrimaryPrincipal();
        //给用户添加权限
        List<String> permission = new ArrayList<>();
        permission.add("user:update");
        permission.add("user:create");
        activityuser.setPermissions(permission);
        //查看权限数据
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加权限
       info.addStringPermissions(permission);

        return info;
    }
    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
