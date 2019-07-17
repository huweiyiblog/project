package com.huwy.huwy.common.kit;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/6/11 14:45
 * <p>作者: huwy
 */
public class StrKit {


    public static String join(String ...str) {
        for (int i = 0; i < str.length; i++) {
            str[i] = StringUtils.defaultString(str[i]);
        }
        return StringUtils.join(str, "#");
    }

}
