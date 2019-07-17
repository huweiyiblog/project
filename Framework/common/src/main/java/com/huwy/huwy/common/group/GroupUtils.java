package com.huwy.huwy.common.group;


import com.huwy.huwy.common.bean.PersonDto;
import com.huwy.huwy.common.kit.StrKit;
import com.google.common.collect.Lists;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/6/10 16:54
 * <p>作者: huwy
 */

public class GroupUtils {


    public static <K,V>  Map<K, List<V>> group(Collection<V> list, GroupBy<K, V> groupBy){
        MultiValueMap<K, V> mvm = new LinkedMultiValueMap<K, V>();
        for (V v : list) {
            mvm.add(groupBy.getKey(v), v);
        }
        return mvm;
    }

    public static  interface GroupBy<K, V> {
        K getKey(V v);
    }



    public static void main(String[] args) {
        List<PersonDto> list = Lists.newLinkedList();
        PersonDto personDto = new PersonDto("陈光红", 12, "重庆市");
        list.add(personDto);
        PersonDto personDto2 = new PersonDto("胡巍译", 12, "垫江县");
        list.add(personDto2);
        PersonDto personDto1 = new PersonDto("王树林", 12, "重庆市");
        list.add(personDto1);

        Map<String, List<PersonDto>> map = GroupUtils.group(list, new GroupUtils.GroupBy<String, PersonDto>(){
            @Override
            public String getKey(PersonDto input) {
                return StrKit.join(input.getName(), input.getAge()+"");
            }
        });

        System.out.println(map);

    }
}
