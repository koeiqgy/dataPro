package com.koei.test.object;

/**
 * @Auther: paul
 * @Date: 2018/6/5 13:42
 * @Description:
 */
public class Animal {
    private String kind;
    private int age;
    private String sound;

    public Animal(String kind, int age, String sound) {
        this.kind = kind;
        this.age = age;
        this.sound = sound;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "Animal haha{" +
                "kind='" + kind + '\'' +
                ", age=" + age +
                ", sound='" + sound + '\'' +
                '}';
    }
}
