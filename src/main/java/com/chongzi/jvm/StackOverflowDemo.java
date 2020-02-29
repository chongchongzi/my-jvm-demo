package com.chongzi.jvm;

/**
 * @Description 栈内存溢出示例
 * -XX:ThreadStackSize=1m
 * 分析jvm参数:-XX:ThreadStackSize=1m -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -Xloggc:gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\projects\
 * @Author chongzi
 * @Date 2020/2/29 14:35
 **/
public class StackOverflowDemo {
    public static long counter = 0;
    public static void main(String[] args) {
        work();
    }
    public static void work(){
        System.out.println("目前是第"+(++counter)+"次调用方法");
        work();
    }
}
