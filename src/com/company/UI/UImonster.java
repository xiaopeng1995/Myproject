package com.company.UI;

import com.company.mogon.MongoStorage;
import com.company.work.Userwork;
import org.bson.Document;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by xiaopeng on 2016/7/1.
 */
public class UImonster {
    public  void show(MongoStorage mogo,Document ds) {
        System.out.println("刷怪中..");
        System.out.println("所需进度：20%..40%..60%..80%..100%");
        System.out.print("当前进度：");
        Timer timer = new Timer();
        Userwork userwork=new Userwork();
        UIGameFunction uiGameFunction=new UIGameFunction();
        timer.schedule(new TimerTask() {
            int a=0;
            public void run(){
               int luck= (int) (Math.random() * 100);
                a++;
                if (a<25) {
                    System.out.print("*");
                }
                if(a==25){
                    System.out.println("\n`系统消息``````````````````````````````````````````````````````````````````````````````````````系统消息`\n当前共打了"+luck+"只小怪兽\n共获得"+luck*10+"点经验\n获得"+luck*3+"文钱\n系统消息````````````````````````````````````````````````````````````````````````````````````````系统消息");
                    timer.cancel();
                    int [] info=userwork.UserworkGrade(ds.getInteger("exp")+(luck*10),ds.getInteger("grade"));
                    ds.put("grade",info[0]);
                    ds.put("exp",info[1]);
                    ds.put("gamemoney",ds.getInteger("gamemoney")+luck*3);
                    mogo.UpdateUser(ds);
                    uiGameFunction.UIGameFunctionmain(mogo,ds);
                }
            }
        }, 0,100);// 设定指定的时间time,此处为2000毫秒
    }
}
