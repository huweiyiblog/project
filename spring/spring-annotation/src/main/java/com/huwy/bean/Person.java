package com.huwy.bean;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/16 15:49
 * <p>作者: huwy
 */
@Data
public class Person {

    @Value("张三")
    private String name;

    @Value("#{20-2}")
    private int age;

    @Value("${person.nikeName}")
    private String nikeName;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}
