package com.huwy.huwy.common.convert;

import com.google.common.base.Preconditions;
import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/6/12 15:49
 * <p>作者: huwy
 */
public class CastUtil {

    private static Map<String, ObjectConverter> CACHED_CUSTOM_CONVERTER_MAP = new ConcurrentHashMap<String, ObjectConverter>();

    public static<T, F> F convert(T source, F target, Class<? extends ObjectConverter> customConverter) {

        if (source == null || target == null) {
            return null;
        }

        BeanCopier beanCopier = getBeanCopierInstance(source, target, null);

        beanCopier.copy(source, target, null);

        ObjectConverter objectConverter = getCustomConverterInstance(customConverter);

        if (objectConverter != null) {
            objectConverter.convertDto(source, target);
        }

        return target;
    }


    /**
     * <p>描述: 首先从缓存中获取自定义转换器，如果获取不到就初始化，并且放入缓存中
     * <p>日期: 2019/6/14 10:12
     * <p>作者: huwy
     * @param [customConverter]
     * @return cn.com.huwy.common.convert.ObjectConverter
     */
    private static ObjectConverter getCustomConverterInstance(Class<? extends ObjectConverter> customConverter) {
        if (customConverter == null) {
            return null;
        }

        String key = customConverter.getName();

        ObjectConverter objectConverter = CACHED_CUSTOM_CONVERTER_MAP.get(key);

        if (objectConverter == null) {
                synchronized (CACHED_CUSTOM_CONVERTER_MAP) {
                    try {
                        objectConverter = customConverter.newInstance();
                        CACHED_CUSTOM_CONVERTER_MAP.put(key, objectConverter);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
        }
        return objectConverter;

    }

    /**
     * <p>描述: 将集合类转换成目标的集合类
     * <p>日期: 2019/6/14 10:13
     * <p>作者: huwy
     * @param [soruceList, target, customConverter]
     * @return java.util.List<T>
     */
    public static<F, T> List<T> convert(List<F> soruceList, Class<T> target, Class<? extends  ObjectConverter> customConverter) {
        if (CollectionUtils.isNotEmpty(soruceList)) {

            List<T> targetList = new ArrayList<T>();

            for (F soruce : soruceList) {
                try {
                    T t = target.newInstance();
                    targetList.add(convert(soruce, t, customConverter));
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return targetList;
        } else {
            return null;
        }
    }


    /**
     * <p>描述: 设置必传参数，并返回构造类
     * <p>日期: 2019/6/14 10:14
     * <p>作者: huwy
     * @param [source, target]
     * @return cn.com.huwy.common.convert.CastUtil.SingleConvertBuilder<F,T>
     */
    public static<F, T> SingleConvertBuilder<F, T> on(F source, T target) {
        SingleConvertBuilder<F, T> convertBuilder = new SingleConvertBuilder<F, T>();
        convertBuilder.soruce = source;
        convertBuilder.target = Preconditions.checkNotNull(target);
        return convertBuilder;
    }

    /**
     * <p>描述: 设置必传参数，并返回构造类
     * <p>日期: 2019/6/14 10:17
     * <p>作者: huwy
     * @param [source, target]
     * @return cn.com.huwy.common.convert.CastUtil.SingleConvertBuilder<F,T>
     */
    public static <F, T> SingleConvertBuilder<F, T> on(F source, Class<T> target) {
        SingleConvertBuilder<F, T> convertBuilder = new SingleConvertBuilder<F, T>();
        convertBuilder.soruce = source;
        convertBuilder.targetClass = Preconditions.checkNotNull(target);
        return convertBuilder;
    }

    /**
     * <p>描述: 初始化cglib的beanCopier实例
     * <p>日期: 2019/6/14 10:17
     * <p>作者: huwy
     * @param [source, target, converter]
     * @return net.sf.cglib.beans.BeanCopier
     */
    public static<T, F> BeanCopier getBeanCopierInstance(T source, F target, Converter converter) {
        return BeanCopier.create(source.getClass(), target.getClass(), converter != null);
    }

    /**
     * <p>描述: 单个对象属性转换
     * <p>日期: 2019/6/13 17:07
     * <p>作者: huwy
     * @param
     * @return
     */
    public static class SingleConvertBuilder<F, T> {
        private F soruce;

        private T target;

        private Class<T> targetClass;

        private Class<? extends ObjectConverter> customConverter;

        public SingleConvertBuilder() {
        }

        //自定义转换器
        public SingleConvertBuilder<F, T> with(Class<? extends  ObjectConverter> customConverter) {
            this.customConverter = Preconditions.checkNotNull(customConverter);
            return this;
        }


        public T get() {
            if (soruce == null) {
                return null;
            }

            if (target == null) {
                try {
                    target = targetClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            convert(soruce, target, customConverter);

            return target;
        }
    }


    /**
     * <p>描述: 集合属性的转换
     * <p>日期: 2019/6/14 10:18
     * <p>作者: huwy
     * @param
     * @return
     */
   public static class ConvertBuilder<F, T> {

       private List<F> soruceList;

       private Class<T> target;

       private Class<? extends ObjectConverter> customConverter;


       public List<T> get() {
           if (CollectionUtils.isEmpty(soruceList)) {
                return Collections.emptyList();
           }

           List<T> toList = convert(soruceList, target, customConverter);

           if (toList == null) {
                return Collections.emptyList();
           }

            return toList;
       }
   }

}
