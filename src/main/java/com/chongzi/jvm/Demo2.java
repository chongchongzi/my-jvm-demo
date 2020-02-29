package com.chongzi.jvm;

/**
 * 演示Young GC过后存活对象太多了，Survivor区存不下去，导致频繁进入老年代，频繁触发Full GC
 * -XX:NewSize=104857600 -XX:MaxNewSize=104857600 -XX:InitialHeapSize=209715200 -XX:MaxHeapSize=209715200 -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=3145728 -XX:PretenureSizeThreshold=20971520 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 * 堆内存200MB，年轻代100MB，Eden区80MB,Survivor区10MB,老年代100MB
 * 优化方案：调大年轻代的内存空间，增加Survivor区的内存即可
 * -XX:NewSize=209715200 -XX:MaxNewSize=209715200 -XX:InitialHeapSize=314572800 -XX:MaxHeapSize=314572800 -XX:SurvivorRatio=2 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=20971520 -XX:PretenureSizeThreshold=20971520 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 * 堆内存300MB，年轻代200MB，同时“-XX:SurvivorRatio=2”表明，Eden：Survivor：Survivor的比例为2:1:1，Eden区100MB,Survivor区50MB,老年代100MB
 * 查看命令：jstat -gc PID 1000 1000
 */
public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
        while (true){
            loadData();
        }
    }

    private static void loadData() throws InterruptedException {
        byte[] data = null;
        for (int i = 0; i < 4; i++) {
            data = new byte[10 * 1024 * 1024];
        }
        data = null;
        byte[] data1 = new byte[10 * 1024 * 1024];
        byte[] data2 = new byte[10 * 1024 * 1024];
        byte[] data3 = new byte[10 * 1024 * 1024];
        data3 = new byte[10 * 1024 * 1024];

        Thread.sleep(1000);
    }
}
