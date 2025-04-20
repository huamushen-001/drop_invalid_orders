package com.sdlg.job;

import com.sdlg.mapper.TSetmealMapper;
import com.sdlg.pojo.TSetmeal;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//定时清理垃圾图片的定时任务
@Component
public class CleanPicJob {
    @Resource
    private TSetmealMapper tSetmealMapper;
    //cron表达式，参数意义自行搜索
    @Scheduled(cron = "0/10 * * * * ?")
    public void cleanPic(){
//        Date date = new Date();
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sf.format(date));
        //思路：获取磁盘目录下图片文件名，获取数据库中图片文件名，比较，删除
        try{
            String path = "D:\\19553\\Picture\\数据库+Spring实训图片\\";
            List<String> list = new ArrayList<>();
            //路径转为文档对象
            File file = new File(path);
            //获取路径下的文件
            File[] files = file.listFiles();
            //便利文件获得文件名
            for (File file1 : files) {
                String name = file1.getName();
                if(name.endsWith(".jpg")){
                    list.add(name);
                }
            }
            //获取数据库中图片文件名
            List<String> dbimg = new ArrayList<>();
            List<TSetmeal> tSetmeals = tSetmealMapper.selectList(null);
            for (TSetmeal tSetmeal : tSetmeals) {
                String img = tSetmeal.getImg();
                dbimg.add(img);
            }
            //遍历磁盘文件名，比较删除
            for (String s : list){
                boolean flag = dbimg.contains(s);
                if(flag){
                    continue;
                }else {
                    //删除文件
                    File newFile = new File(path+s);
                    newFile.delete();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
