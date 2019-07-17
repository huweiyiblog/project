package com.huwy.huwy.common.cglib.beanCopier;
import com.huwy.huwy.common.bean.PersonDto;
import net.sf.cglib.beans.BeanCopier;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/6/12 9:34
 * <p>作者: huwy
 */
public class SimpleTest {

    public static void main(String[] args) {
        BeanCopier copier = BeanCopier.create(PersonDto.class, PersonDto.class, false);

        PersonDto source = new PersonDto();
        source.setName("huwy");

        PersonDto target = new PersonDto();
        copier.copy(source, target, null);

        System.out.println(target);


    }

}
