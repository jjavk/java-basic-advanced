package com.github.advanced.design.builder;

import java.util.Date;

/**
 * 缺点：
 * 1：Setter方法使属性变成可变类型，并发下存在线程安全性
 * 2：创建对象需要大量setter方法，太丑陋
 * Created by jiabin on 2018/5/14.
 */
public class PersonByJavaBeans {
    private String name;        // required
    private String sex;         // required
    private Date date;          // required
    private String email;       // required

    private int height;         // optional
    private String edu;         // optional
    private String nickName;    // optional
    private int weight;         // optional
    private String addr;        // optional

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "PersonByJavaBeans{" +
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
