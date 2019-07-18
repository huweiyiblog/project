package com.huwy.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * <p>描述: 自定义逻辑返回需要导入的组件
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/18 10:12
 * <p>作者: huwy
 */
public class MyImportSelector implements ImportSelector {

    //返回值，就是要导入到容器中的组件全类名
    //AnnotationMetadata:当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.huwy.bean.Color"};
    }
}
