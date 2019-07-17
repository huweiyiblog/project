package com.huwy.singleton;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/12 14:59
 * <p>作者: huwy
 */
public class SingletonTest01 {

    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();
    }


}

class Singleton {

    //使用volatile关键字防止重排序，因为 new Instance()是一个非原子操作，可能创建一个不完整的实例
    private static  volatile Singleton instance;

    private Singleton() {
    };

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
