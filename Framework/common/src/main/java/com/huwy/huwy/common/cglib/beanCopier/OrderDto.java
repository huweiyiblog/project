package com.huwy.huwy.common.cglib.beanCopier;

import lombok.Data;

import java.util.Date;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/6/11 15:35
 * <p>作者: huwy
 */

@Data
public class OrderDto {

    private String orderId;

    private String orderName;

    private Date date;

    private String address;

}
