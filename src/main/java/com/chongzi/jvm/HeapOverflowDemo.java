package com.chongzi.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 堆内存溢出示例
 * -Xms10m -Xmx10m
 * 分析jvm参数:-Xms10m -Xmx10m -XX:+PrintGCDetails -Xloggc:gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\projects\
 * @Author chongzi
 * @Date 2020/2/29 14:39
 **/
public class HeapOverflowDemo {
    public static void main(String[] args) {
        long counter = 0;
        List<Object> list = new ArrayList<Object>();
        while (true){
            list.add(new Object());
            System.out.println("目前创建了第"+(++counter)+"个对象");
        }
    }
}
