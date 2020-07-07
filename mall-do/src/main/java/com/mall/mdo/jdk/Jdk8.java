package com.mall.mdo.jdk;

import com.mall.mdo.domain.ListTest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author HC
 * @Date 2020/7/3 15:50
 * @Version 1.0
 */
@SpringBootTest
public class Jdk8 {

    /**
     * @Description:stream特性
     * @return:
     * @param:
    */
    @Test
    public void doStream(){
        List<ListTest> dirList = initList().stream()
                .filter(listTest -> listTest.getAge() == 10)
                .collect(Collectors.toList());
        System.out.println(dirList.toString());
    }

    public static List<ListTest> initList(){
        List<ListTest> listTests = new ArrayList<>();
        ListTest test = new ListTest();
        test.setAge(10);
        test.setId(1);
        test.setName("贺成");
        test.setText("哈哈");
        listTests.add(test);
        ListTest test1 = new ListTest();
        test1.setAge(10);
        test1.setId(2);
        test1.setName("符剑");
        test1.setText("哈哈AAA");
        listTests.add(test1);
        ListTest test2 = new ListTest();
        test2.setAge(6);
        test2.setId(3);
        test2.setName("AAA");
        test2.setText("哈哈CCC");
        listTests.add(test2);
        return listTests;
    }
}
