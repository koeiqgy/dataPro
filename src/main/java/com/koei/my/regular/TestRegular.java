package com.koei.my.regular;

import java.util.regex.Pattern;

/**
 * @Auther: paul
 * @Date: 2018/7/30 10:42
 * @Description:
 */
public class TestRegular {
    public static void main(String[] args) {
        //String content = "I am noob " +  "from runoob.com.";
        String content ="runoob";
        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }
}
