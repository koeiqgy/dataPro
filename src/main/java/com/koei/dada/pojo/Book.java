package com.koei.dada.pojo;

/**
 * @Auther: paul
 * @Date: 2018/6/1 10:02
 * @Description:
 */
public class Book {
    private String name;
    private String auth;
    private String ISBN;

    public Book(String name, String auth, String ISBN) {
        this.name = name;
        this.auth = auth;
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
