package com.chongzi.jvm;

/**
 * 演示频繁Young GC
 * -XX:NewSize=5242880 -XX:MaxNewSize=5242880 -XX:InitialHeapSize=10485760 -XX:MaxHeapSize=10485760 -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 * 查看命令：jstat -gc PID 1000 1000
 */
public class YoungGCDemo {

    public static void main(String[] args) throws InterruptedException {
        byte[] data = new byte[1024 * 1024];
        data = new byte[1024 * 1024];
        data = new byte[1024 * 1024];
        data = null;
        byte[] data1 = new byte[2 * 1024 * 1024];
    }

}
