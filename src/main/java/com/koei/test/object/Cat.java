package com.koei.test.object;

/**
 * @Auther: paul
 * @Date: 2018/6/5 13:44
 * @Description:
 */
public class Cat extends  Animal {
    private Animal animal;
    public Cat(String kind, int age, String sound) {
        super(kind, age, sound);
        this.animal=this;
    }


    public static void main(String[] args) {

        Cat cat=new Cat("猫科",5,"喵喵");
        String kinds=cat.getAnimal().getKind();
        System.out.println(kinds);
    }

    public Animal getAnimal() {
        return animal;
    }
}
