package com.chongzi.jvm;

/**
 * 演示对象是如何在Young GC过后因为放不下Survivor区域，就直接进入老年代
 * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 * 查看命令：jstat -gc PID 1000 1000
 */
public class FullGCDemo {

    public static void main(String[] args) throws InterruptedException {
        byte[] data = new byte[4 * 1024 * 1024];
        data = null;
        byte[] data2 = new byte[2 * 1024 * 1024];
        byte[] data3 = new byte[2 * 1024 * 1024];
        byte[] data4 = new byte[2 * 1024 * 1024];
        byte[] data5 = new byte[128 * 1024];
        byte[] data6 = new byte[2 * 1024 * 1024];
    }

}
