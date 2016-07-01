package com.company.UI;

import com.company.mogon.MongoStorage;
import com.company.work.Userwork;
import org.bson.Document;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by xiaopeng on 2016/6/28.
 */
public class UIchou {
    Userwork userwork=new Userwork();
    UIGameFunction uiGameFunction=new UIGameFunction();
    Cdk cdk=new Cdk();
    public void c(Document ds,MongoStorage mogo){
        System.out.println("\n欢迎来到抽奖系统");
        System.out.println("\n每次抽奖消耗100金币");
        if(ds.getInteger("gold")<80)
        {
            System.out.println("\n" +
                    "\n" +
                    "↓↓↓↓↓↓↓↓↓```````````````````````````````````````````系统消息`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓\n\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t金币不够去耍怪吧！能获得金币哦！\n" +
                    "" +
                    "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑\n");
            uiGameFunction.UIGameFunctionmain(mogo,ds);
        }
        else
        {
            ds.put("gold",ds.getInteger("gold")-80);
            mogo.UpdateUser(ds);
            System.out.println("正在抽奖请稍后..");
            System.out.println("所需进度：20%..40%..60%..80%..100%");
            System.out.print("当前进度：");
            Timer timer = new Timer();
            UIgamelis gamelis=new UIgamelis();
            timer.schedule(new TimerTask() {
                int a=0;
                public void run() {
                    a++;
                    if (a<25) {
                        System.out.print("*");
                    }
                    if(a==25){
                        int lucky=cdk.RandomNum();
                        System.out.println(lucky);
                        if(lucky<9)
                        {
                            if(lucky<3)
                            {
                                System.out.println("\n" +
                                        "↓↓↓↓↓↓↓↓↓``````````````````````````````````````````★★★Very lucky!★★★`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓\n\n" +
                                        "\t\t\t\t\t\t\t\t\t\t\t\t您获得10000点经验！\n" +
                                        "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑");
                                int [] info=userwork.UserworkGrade(ds.getInteger("exp")+(10000),ds.getInteger("grade"));
                                ds.put("grade",info[0]);
                                ds.put("exp",info[1]);
                                mogo.UpdateUser(ds);
                            }
                            if(lucky>=3&&lucky<7)
                            {
                                System.out.println("\n" +
                                        "\n" +
                                        "↓↓↓↓↓↓↓↓↓```````````````````````````````````````````系统消息`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓\n\n" +
                                        "\t\t\t\t\t\t\t\t\t\t\t\t您获得1000文钱！\n" +
                                        "" +
                                        "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑\n");
                                ds.put("gamemoney",ds.getInteger("gamemoney")+1000);
                                mogo.UpdateUser(ds);
                            }
                            if(lucky==7)
                            {
                                System.out.println("\n" +
                                        "↓↓↓↓↓↓↓↓↓★★★★★★★★★★★Very lucky!██████████Very lucky!██████████Very lucky!★★★★★★★★★★★↓↓↓↓↓↓↓↓↓\n" +
                                        "\t\t\t\t\t\t\t\t\t\t\t\t您获得200金币！\n" +
                                        "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑");
                                ds.put("gold",ds.getInteger("gold")+200);
                                mogo.UpdateUser(ds);
                            }
                            if(lucky==8)
                            {
                                System.out.println("\n" +
                                        "↓↓↓↓↓↓↓↓↓```````````````````````````````````````````系统消息`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓\n" +
                                        "\t\t\t\t\t\t\t\t\t\t\t\t您获得50金币！\n" +
                                        "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑");
                                ds.put("gold",ds.getInteger("gold")+50);
                                mogo.UpdateUser(ds);
                            }

                        }
                        else
                        {
                            System.out.println(cdk.RandomNum());
                            System.out.println("\n" +
                                    "↓↓↓↓↓↓↓↓↓★★★★★★★★★★★Very lucky!██████████Very lucky!██████████Very lucky!★★★★★★★★★★★↓↓↓↓↓↓↓↓↓ \nVery lucky!");
                            System.out.println("中");
                            System.out.println("奖");
                            System.out.println("了");
                            System.out.println("！");
                            System.out.println("\n\n" +
                                    "\t\t\t\t\t\t\t\t\t\t\t\t恭喜您获得100元移动充值卡");
                            System.out.println("\n" +
                                    "\t\t\t\t\t\t\t\t\t\t\t\t卡号是："+cdk.getCdk());
                            System.out.println("\n" +
                                    "\t\t\t\t\t\t\t\t\t\t\t\t密码是："+cdk.getCdkpwd());
                            System.out.println("|");
                            System.out.println("|");
                            System.out.println("|");
                            System.out.println("|");
                            System.out.println("|\n" +
                                    "↑↑↑↑↑↑↑↑↑```````````````````````````````````↑↑↑↑`````````````````````````````````````````````````````````````````↑↑↑↑↑↑↑↑↑");
                        }
                        uiGameFunction.UIGameFunctionmain(mogo,ds);
                        timer.cancel();
                    }
                }
            }, 0,100); // 设定指定的时间time,此处为100毫秒
        }


    }
}
