package com.jarluo.springcloudconfigclient.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @from: https://www.cnblogs.com/java333/
 * @desc: Spring 自定义 事件/监听
 * @author: jar luo
 * @date: 2019/9/26 22:02
 */
public class SpringEventListenerDemo {
    public static void main(String[] args) {
        //Annotation 驱动的事件
        AnnotationConfigApplicationContext  context =
                new AnnotationConfigApplicationContext();
        //1.注册监听器
        context.addApplicationListener((ApplicationListener<MyApplicationEvent>) applicationEvent -> {
            //监听器得到事件
            System.out.println("接收到的事件:" + applicationEvent.getSource() + "@" + applicationEvent.getApplicationContext());
        });
        context.refresh();
        //2.发布事件
        context.publishEvent(new MyApplicationEvent(context,"Hello，World"));
        context.publishEvent(new MyApplicationEvent(context,"愿得一人心"));
        context.publishEvent(new MyApplicationEvent(context,"白首不分离"));

    }

    private static class MyApplicationEvent extends ApplicationEvent{
        
        private final ApplicationContext applicationContext;

        public MyApplicationEvent(ApplicationContext applicationContext,Object source) {
            super(source);
            this.applicationContext = applicationContext;
        }

        public ApplicationContext getApplicationContext() {
            return applicationContext;
        }
    }

}
