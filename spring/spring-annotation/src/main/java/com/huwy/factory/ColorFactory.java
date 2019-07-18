package com.huwy.factory;

import com.huwy.bean.Color;
import org.springframework.beans.factory.FactoryBean;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/18 11:18
 * <p>作者: huwy
 */
public class ColorFactory implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
