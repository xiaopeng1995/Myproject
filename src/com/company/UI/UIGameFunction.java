package com.company.UI;

import com.company.mogon.MongoStorage;
import com.company.mongoDao.Fishing;
import org.bson.Document;

import java.util.Scanner;

/**
 * Created by xiaopeng on 2016/7/1.
 */
public class UIGameFunction {
    UIgamelis uIgamelis=new UIgamelis();
    public void UIGameFunctionmain(MongoStorage mogo,Document ds)
    {
        ds=mogo.Userinfo(ds);
        System.out.println("欢迎您"+ds.getString("name")+"来到魔幻巨作~~幻想世界~~");
                /*User Iofor*/
        System.out.println("您的信息如下：");
        System.out.println("↓↓↓↓↓↓↓↓↓```````````````````````````````````````````人物信息`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓\n"
                + "\t\t\t\t您当前等级：" +ds.getInteger("grade")+"级\t"
                + "您当前的经验为"+ds.getInteger("exp")+"点，升级需要"+ds.getInteger("grade")*76*ds.getInteger("grade")+"点\t"
                + "您当前游戏币："+ds.getInteger("gamemoney")+ "文\t"
                + "您的金币"+ds.getInteger("gold") +"个\n"
                + "\t\t\t\t您的剩余活力"+ds.getInteger("vigour") +"点(今日可钓鱼"+ds.getInteger("Fishing")+"次）\n"
                + "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑");
                /*Geme Function Choose*/
        System.out.println("已经准备好的游戏功能有：");
        System.out.println("热门功能：1：野外幸运刷怪(20活力一次)\t\t2：副本~妖魔塔~（开发中！）\t3:金币抽奖（有机会赢取100元移动手机充值卡,100金币抽一次)\t4：更多功能...（充值等）");
        System.out.println("请输入功能序号开始");
        Scanner s = new Scanner(System.in);
        String GemeFunctionChoose = s.next();
        if(GemeFunctionChoose.equals("1"))//1：野外刷怪
        {
            UImonster uImonster=new UImonster();
            uImonster.show(mogo,ds);
        }
        else if (GemeFunctionChoose.equals("2"))//2：副本~妖魔塔~
        {
            System.out.println("功能正在开发中！请重新选择哦");
            UIGameFunctionmain(mogo,ds);
        }
        else if (GemeFunctionChoose.equals("3"))//3:每日一抽
        {
            UIchou uIchou=new UIchou();
            uIchou.c(ds,mogo);
        }
        else if (GemeFunctionChoose.equals("4"))//3:更多功能
        {
            System.out.println("其他功能：1：购买活力\t\t2：充值金币\t\t3：钓鱼活动免费得活力");
            System.out.println("请输入功能序号开始");
            Scanner s2 = new Scanner(System.in);
            String qGemeFunctionChoose = s2.next();
            if(qGemeFunctionChoose.equals("1"))//1：购买活力
            {
                System.out.println("\n" +
                        "\n" +
                        "↓↓↓↓↓↓↓↓↓```````````````````````````````````````````活力促销中`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓\n\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t1.购买100活力/50金币\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t2.购买500活力/246金币\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t3.购买1000活力/450金币\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t4.购买10000活力/4100金币\n" +
                        "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑\n");
                System.out.println("请输入套餐序号开始");
                Scanner s1 = new Scanner(System.in);
                String num=s1.next();
                if (num.equals("1"))
                {
                    ds.put("vigour",ds.getInteger("vigour")+100);
                    ds.put("gold",ds.getInteger("gold")-50);
                }
                else if(num.equals("2"))
                {
                    ds.put("vigour",ds.getInteger("vigour")+500);
                    ds.put("gold",ds.getInteger("gold")-246);
                }
                else if(num.equals("3"))
                {
                    ds.put("vigour",ds.getInteger("vigour")+1000);
                    ds.put("gold",ds.getInteger("gold")-450);
                }
                else if(num.equals("4"))
                {
                    ds.put("vigour",ds.getInteger("vigour")+10000);
                    ds.put("gold",ds.getInteger("gold")-4100);
                }
                else {
                    System.out.println("输入错误请重新选择");
                    UIGameFunctionmain(mogo,ds);
                }
                if(ds.getInteger("gold")<0)
                {
                    System.out.println("\n" +
                            "\n" +
                            "↓↓↓↓↓↓↓↓↓```````````````````````````````````````````系统消息`````````````````````````````````````````````↓↓↓↓↓↓↓↓↓\n\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t金币不够去耍怪吧！能获得金币哦！或者充值！\n" +
                            "" +
                            "↑↑↑↑↑↑↑↑↑```````````````````````````````````````````↑↑↑↑`````````````````````````````````````````````↑↑↑↑↑↑↑↑↑\n");
                    UIGameFunctionmain(mogo,ds);
                }
                else {
                    System.out.println("\n" +
                            "\n" +
                            "******```````````````````````````````````````````购买成功`````````````````````````````````````````````******`\n\n" );
                    mogo.UpdateUser(ds);

                }
                UIGameFunctionmain(mogo,ds);
            }
            else if(qGemeFunctionChoose.equals("2"))
            {
                System.out.println("功能正在开发中！请重新选择哦");
                UIGameFunctionmain(mogo,ds);
            }
            else if(qGemeFunctionChoose.equals("3"))
            {
                Fishing timeUpudate=new Fishing();
                timeUpudate.Time(mogo,ds);
            }
            else
            {
                System.out.println("输入错误请重新选择");
                UIGameFunctionmain(mogo,ds);
            }
        }
        else {
            System.out.println("输入错误请重新选择");
            UIGameFunctionmain(mogo,ds);
        }
    }
}
