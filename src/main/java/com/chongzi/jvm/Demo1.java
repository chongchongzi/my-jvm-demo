package com.chongzi.jvm;

/**
 * 演示新生代对象增长的速率，Young GC的触发频率和耗时，每次Young GC过后有多少对象是存活在Survivor区
 * -XX:NewSize=104857600 -XX:MaxNewSize=104857600 -XX:InitialHeapSize=209715200 -XX:MaxHeapSize=209715200 -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 * 堆内存200MB，年轻代100MB，Eden区80MB,Survivor区10MB,老年代100MB
 * 查看命令：jstat -gc PID 1000 1000
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(3000);
        while (true){
            loadData();
        }
    }

    private static void loadData() throws InterruptedException {
        byte[] data = null;
        for (int i = 0; i < 50; i++) {
            data = new byte[100 * 1024];
        }
        data = null;
        Thread.sleep(1000);
    }
}
