package com.huwy.huwy.common.bean;

import lombok.Data;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/16 17:46
 * <p>作者: huwy
 */
@Data
public class PersonDto {

    private String name;

    private int age;

    private String address;

    public PersonDto(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public PersonDto() {
    }
}
