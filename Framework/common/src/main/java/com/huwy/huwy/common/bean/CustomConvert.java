package com.huwy.huwy.common.bean;

import com.huwy.huwy.common.convert.ObjectConverter;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/6/13 16:46
 * <p>作者: huwy
 */
public class CustomConvert implements ObjectConverter<ConvertDto, ConvertCmp> {
    @Override
    public void convertDto(ConvertDto soruce, ConvertCmp target) {
        target.setAddress("江津区");
    }
}
