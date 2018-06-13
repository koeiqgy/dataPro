package com.koei.test;

import java.util.HashSet;
import java.util.Set;

/*
 * 项目组长类
 */
public class PD {

    public String id;
    public String name;
    //集合后面的<>代表泛型的意思
    //泛型是规定了集合元素的类型
    //我们以后会详细讲到
    public Set<Student> students;
    public PD(String id, String name){
        this.id = id;
        this.name = name;
        this.students = new HashSet<Student>();
    }
}
