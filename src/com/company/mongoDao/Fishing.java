package com.company.mongoDao;

import com.company.UI.UIGameFunction;
import com.company.UI.UIgamelis;
import com.company.mogon.MongoStorage;
import org.bson.Document;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by xiaopeng on 2016/7/4.
 */
public class Fishing {
    public void Time(MongoStorage mogo,Document ds){

        UIGameFunction uiGameFunction=new UIGameFunction();
        if (ds.getInteger("Fishing")<=0)
        {
            System.out.println("\n" +
                    "\n" +
                    "↓↓↓↓↓↓↓↓↓```````````````````````````````````````````系统消息`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓\n\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t钓鱼次数不够明天再来吧！\n" +
                    "" +
                    "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑\n");
            uiGameFunction.UIGameFunctionmain(mogo,ds);
        }
        else
            for (int a=0;a<=10;a++)
             {
                int luck= (int) (Math.random() *10);
                if(luck>=7)
                {
                    System.out.println("\n" +
                            "↓↓↓↓↓↓↓↓↓```````````````````````````````````````````系统消息`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t今天第"+(11-ds.getInteger("Fishing"))+"次钓鱼，很遗憾没有掉到鱼！\n" +
                            "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑");
                }
                else
                {
                    System.out.println("\n" +
                            "↓↓↓↓↓↓↓↓↓```````````````````````````````````````````系统消息`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t今天第"+(11-ds.getInteger("Fishing"))+"次钓鱼，成功钓起"+luck+"斤鱼，加活力"+luck+"点\n" +
                            "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑");
                    ds.put("vigour",ds.getInteger("vigour")+luck);
                }
                    System.out.println("输入0停止钓鱼活动.输入其他继续");
                    Scanner s1 = new Scanner(System.in);
                    String num=s1.next();
                    if(num.equals("0")||ds.getInteger("Fishing")<=0)
                    {
                        uiGameFunction. UIGameFunctionmain(mogo,ds);
                    }
                    ds.put("Fishing",ds.getInteger("Fishing")-1);
                    mogo.UpdateUser(ds);
             }
        uiGameFunction.UIGameFunctionmain(mogo,ds);

    }
}

