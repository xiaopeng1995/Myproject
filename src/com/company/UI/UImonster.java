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
        Userwork userwork=new Userwork();
        UIGameFunction uiGameFunction=new UIGameFunction();
        if(ds.getInteger("vigour")<20)
        {
            System.out.println("\n" +
                    "\n" +
                    "↓↓↓↓↓↓↓↓↓```````````````````````````````````````````系统消息`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓\n\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t活力不够去购买吧！\n" +
                    "" +
                    "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑\n");
            uiGameFunction.UIGameFunctionmain(mogo,ds);
        }
        else
        {
            ds.put("vigour",ds.getInteger("vigour")-20);
            mogo.UpdateUser(ds);
            System.out.println("刷怪中..");
            System.out.print("杀死小怪数量：");
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                int a=0;
                int Tup=1;
                int luck= (int) (Math.random() * 50)+1;
                public void run(){
                    a++;
                    if (a<luck) {
                        System.out.print("X"+a+"  ");
                    }
                    if(a==luck){
                        if(luck>25&&luck<30)
                        {
                            System.out.println("\n↓↓↓↓↓↓↓↓↓★★★★★Very lucky!★★★★★Very lucky!★★★★★Very lucky!★★★★★↓↓↓↓↓↓↓↓↓ \n" +
                                    "\t\t\t\t\t\t\t\t\t\t\t\t杀死小怪超过★★25只★★！！！★★奖励5倍经验和15金币");
                            ds.put("gold",ds.getInteger("gold")+15);
                            mogo.UpdateUser(ds);
                            Tup=5;
                        }

                        else if(luck>=30&&luck<45)
                        {
                            System.out.println("\n↓↓↓↓↓↓↓↓↓★★★★★★★★★★★Very lucky!██████████Very lucky!██████████Very lucky!★★★★★★★★★★★↓↓↓↓↓↓↓↓↓\n" +
                                    "\t\t\t\t\t\t\t\t\t\t\t\t杀死小怪超过★★★30只★★★！！！★★★奖励10倍经验和25金币");
                            ds.put("gold",ds.getInteger("gold")+25);
                            mogo.UpdateUser(ds);
                            Tup=10;
                        }
                        else if(luck>=45)
                        {
                            System.out.println("\n★★★★★★★★★★★★★★★★★Very lucky!██████████超大奖励！██████████Very lucky!★★★★★★★★★★★★★★★★★\n" +
                                    "\t\t\t\t\t\t\t\t\t\t\t\t您杀死小怪超过★★★45只★★★！！！★★★奖励100倍经验和100金币");
                            ds.put("gold",ds.getInteger("gold")+100);
                            mogo.UpdateUser(ds);
                            Tup=100;
                        }
                        System.out.println("\n`↓↓↓↓↓↓↓↓↓```````````````````````````````````````````系统消息`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓`\n\t\t\t\t\t\t\t\t\t\t\t\t当前共打了"+(luck-1)+"只小怪兽\n\n" +
                                "\t\t\t\t\t\t\t\t\t\t\t\t共获得"+luck*Tup*ds.getInteger("grade")+"点经验\n获得"+luck*3+"文钱\n↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑");
                        timer.cancel();

                        int [] info=userwork.UserworkGrade(ds.getInteger("exp")+(luck*10*Tup),ds.getInteger("grade"));
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
}
