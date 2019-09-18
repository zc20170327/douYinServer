package com.zhdtedu.system.service.impl;

import com.zhdtedu.system.service.PictureService;
import com.zhdtedu.system.service.UserService;
import com.zhdtedu.util.RcsResult;
import imageHelpe.CommentTask;
import imageHelpe.FollowTask;
import imageHelpe.HightLevelTask;
import imageHelpe.LikeTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    UserService userService;
    @Override
    public RcsResult recognition(MultipartFile file, String type, int userId, int integral) {

            BufferedImage avatorImg = null;
            BufferedImage img=null;
            assert img!=null;
            assert avatorImg!=null;
            boolean is=false;
            try {
                FileInputStream in = (FileInputStream) file.getInputStream();
                img = javax.imageio.ImageIO.read(in);
                if("评论".equals(type)){
                    CommentTask commentTask=new CommentTask();
                    is=commentTask.isComment(avatorImg,img,3.0f,0.6);
                    if(is==true){
                        userService.imageRecharge(userId,integral);
                        return RcsResult.build(201,"任务完成，获取积分:"+integral);
                    }
                    else{
                        return  RcsResult.build(500,"图片识别错误");
                    }
                }
                if("点赞".equals(type)){
                    LikeTask likeTask=new LikeTask();
                    is=likeTask.isRedLike(img);
                    if(is==true){
                        userService.imageRecharge(userId,integral);
                        return RcsResult.build(201,"任务完成，获取积分:"+integral);
                    }
                    else{
                        return  RcsResult.build(500,"图片识别错误");
                    }
                }
                if("关注".equals(type)){
                    FollowTask followTask=new FollowTask(3);
                    is=followTask.isFollow(img);
                    if(is==true){
                        userService.imageRecharge(userId,integral);
                        return RcsResult.build(201,"任务完成，获取积分:"+integral);
                    }
                    else{
                        return  RcsResult.build(500,"图片识别错误");
                    }
                }
                if("好友任务".equals(type)){
                    HightLevelTask hightLevelTask=new HightLevelTask();
                    is=hightLevelTask.isHightLevelTask(img);
                    if(is==true){
                        userService.imageRecharge(userId,integral);
                        return RcsResult.build(201,"任务完成，获取积分:"+integral);
                    }
                    else{
                        return  RcsResult.build(500,"图片识别错误");
                    }
                }
            } catch (IOException e) {
                return  RcsResult.build(500,e.getMessage());
            }
        return  RcsResult.build(500,"任务类型不匹配");
    }
}
