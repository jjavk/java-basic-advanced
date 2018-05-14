package com.github.advanced.design.builder;

import java.util.Date;

/**
 * 缺点：
 * 1：属性只能通过构造函数设置，灵活性差
 * 2：属性很多的时候，代码难以编写与阅读
 * Created by jiabin on 2018/5/14.
 */
public class PersonByConstruct {
    private String name;        // required
    private String sex;         // required
    private Date date;          // required
    private String email;       // required

    private int height;         // optional
    private String edu;         // optional
    private String nickName;    // optional
    private int weight;         // optional
    private String addr;        // optional

    public PersonByConstruct(String name, String sex, Date date, String email) {
        this(name, sex, date, email, 0);
    }

    public PersonByConstruct(String name, String sex, Date date, String email, int height) {
        this(name, sex, date, email, height, null);
    }

    public PersonByConstruct(String name, String sex, Date date, String email, int height, String edu) {
        this(name, sex, date, email, height, edu, null);
    }

    public PersonByConstruct(String name, String sex, Date date, String email, int height, String edu, String nickName) {
        this(name, sex, date, email, height, edu, nickName, 0);
    }

    public PersonByConstruct(String name, String sex, Date date, String email, int height, String edu, String nickName, int
            weight) {
        this(name, sex, date, email, height, edu, nickName, weight, null);
    }

    public PersonByConstruct(String name, String sex, Date date, String email, int height, String edu, String nickName, int
            weight, String addr) {
        this.name = name;
        this.sex = sex;
        this.date = date;
        this.email = email;
        this.height = height;
        this.edu = edu;
        this.nickName = nickName;
        this.weight = weight;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "PersonByConstruct{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", date=" + date +
                ", email='" + email + '\'' +
                ", height=" + height +
                ", edu='" + edu + '\'' +
                ", nickName='" + nickName + '\'' +
                ", weight=" + weight +
                ", addr='" + addr + '\'' +
                '}';
    }
}
