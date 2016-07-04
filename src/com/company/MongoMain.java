package com.company;


import com.company.UI.UImain;
import com.company.mogon.MongoStorage;
import org.apache.commons.configuration.PropertiesConfiguration;


public class MongoMain {

    public static void main(String[] args) throws Exception {
        MongoStorage mogo = new MongoStorage();
        PropertiesConfiguration mongoConfig;
        mongoConfig = new PropertiesConfiguration("src/com/company/Config/mongo.properties");
        mogo.init(mongoConfig);
        UImain uImain=new UImain();
        uImain.timer1(mogo);


    }
}
