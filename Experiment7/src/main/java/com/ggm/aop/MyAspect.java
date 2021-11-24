package com.ggm.aop;

/**
 * @author yz
 * @create 2021-11-23-20:02
 */
public class MyAspect {
    public void before(){
        System.out.println("正在调用方法。。。");
    }
    public void after(){
        System.out.println("调用方法结束。。。");
    }
}
