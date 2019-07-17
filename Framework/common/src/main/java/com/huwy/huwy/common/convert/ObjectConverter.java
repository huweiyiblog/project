package com.huwy.huwy.common.convert;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/6/13 11:15
 * <p>作者: huwy
 */
public interface ObjectConverter<F, T> {

    void convertDto(F soruce, T target);

}
