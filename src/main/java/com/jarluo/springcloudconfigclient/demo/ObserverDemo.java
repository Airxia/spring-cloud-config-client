package com.jarluo.springcloudconfigclient.demo;

import java.util.*;

/**
 * @from: https://www.cnblogs.com/java333/
 * @desc: TODO
 * @author: jar luo
 * @date: 2019/9/26 21:04
 */
public class ObserverDemo {

    public static void main(String[] args) {
        //Observable observable = new Observable();
        MyObservable observable = new MyObservable();
        //增加订阅者
        observable.addObserver((o, arg) -> System.out.println(arg));

        observable.setChanged();
        //发布者通知，订阅者是被动感知（推模式）
        observable.notifyObservers("Hello,World");
        //拉模式
        echoIterator();
    }

    public static class MyObservable extends Observable{
        protected synchronized void setChanged(){
            super.setChanged();
        }
    }

    //对应拉的模式
    private static void echoIterator(){
        List<Integer> values = Arrays.asList(1,2,3,4,5);
        Iterator<Integer> integerIterator = values.iterator();
        //通过循环，主动去获取
        while (integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }

    }


}
