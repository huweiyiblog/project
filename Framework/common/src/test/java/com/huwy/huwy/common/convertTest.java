package com.huwy.huwy.common;

import com.huwy.huwy.common.bean.ConvertCmp;
import com.huwy.huwy.common.bean.ConvertDto;
import com.huwy.huwy.common.convert.CastUtil;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/6/13 14:27
 * <p>作者: huwy
 */
public class convertTest {

    public static void main(String[] args) {

        ConvertCmp convertCmp = new ConvertCmp();
        ConvertDto convertDto = new ConvertDto();

        convertDto.setAddress("重庆市");
        convertDto.setName("mr.hu");
        convertDto.setAge(15);


        /*CastUtil.on(convertDto, convertCmp).get();
        System.out.println(convertCmp);*/

        ConvertCmp cmp = CastUtil.on(convertDto, ConvertCmp.class).get();
        System.out.println(cmp);



       /* ConvertCmp cmp = CastUtil.on(convertDto, convertCmp).with(CustomConvert.class).get();
        System.out.println(cmp);*/


    }


}
