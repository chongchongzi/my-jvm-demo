package com.chongzi.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示MAT如何使用
 * 查看命令：jmap -dump:live,format=b,file=dump.hprof PID
 */
public class Demo3 {

    public static void main(String[] args) throws InterruptedException {
        List<Data> dataList = new ArrayList<Data>();
        for (int i = 0; i < 10000; i++) {
            dataList.add(new Data());
        }
        Thread.sleep(1 * 60 * 60 * 1000);
    }

    static class Data{

    }
}
