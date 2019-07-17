package com.huwy.huwy.guava.optional;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.primitives.Ints;
import org.junit.Test;
import sun.applet.Main;

import java.util.Collections;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/6/10 15:41
 * <p>作者: huwy
 */
public class OptionalMain {

    @Test
    public void testOf() {
        /*******************Optional.of(T)创建指定引用的Optional实例，若引用为null则快速失败*******************/
        Optional<Integer> possible = Optional.of(5);
        possible.isPresent();
        possible.get();



        Optional.fromNullable(null);
    }

    @Test
    public void testFromNullable() {
        /*******Optional.fromNullable(T)创建指定引用的Optional实例，若引用为null则表示缺失*******/
       Optional<Integer> optional = Optional.fromNullable(null);
    }

    public static void main(String[] args) {
        ArrayListMultimap.create();
    }


}
