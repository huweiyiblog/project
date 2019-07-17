package com.huwy;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/15 16:30
 * <p>作者: huwy
 */
public class Test extends Wrapper {

    @Override
    public void method1() {
        System.out.println("222");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.method1();

    }
}
