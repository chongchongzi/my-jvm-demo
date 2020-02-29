package com.chongzi.jvm;

/**
 * 演示动态年龄判定进入老年代
 * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 * 查看命令：jstat -gc PID 1000 1000
 */
public class OldGCDynamicAgeDemo {

    public static void main(String[] args) throws InterruptedException {
        byte[] data = new byte[2 * 1024 * 1024];
        data = new byte[2 * 1024 * 1024];
        data = new byte[2 * 1024 * 1024];
        data = null;
        byte[] data1 = new byte[128 * 1024];
        byte[] data2 = new byte[2 * 1024 * 1024];
        data2 = new byte[2 * 1024 * 1024];
        data2 = new byte[2 * 1024 * 1024];
        data2 = new byte[128 * 1024];
        data2 = null;
        byte[] data3 = new byte[2 * 1024 * 1024];
    }

}
