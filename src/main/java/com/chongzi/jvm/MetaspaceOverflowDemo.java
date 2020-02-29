package com.chongzi.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description 元信息内存溢出
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * 分析jvm参数:-XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -Xloggc:gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\projects\
 * @Author chongzi
 * @Date 2020/2/29 13:11
 **/
public class MetaspaceOverflowDemo {
    public static void main(String[] args) {
        long counter = 0;
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    if(method.getName().equals("run")){
                        System.out.println("启动汽车之间，先进行自动的安全检查......");
                        return methodProxy.invokeSuper(o,objects);
                    }else{
                        return methodProxy.invokeSuper(o,objects);
                    }
                }
            });
            System.out.println("目前创建了"+(++counter)+"个Car类的子类");
            Car car = (Car)enhancer.create();
            car.run();
        }
    }

    static class Car{
        public void run(){
            System.out.println("汽车启动，开始行驶......");
        }
    }
}
