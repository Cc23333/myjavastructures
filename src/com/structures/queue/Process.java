package com.structures.queue;

/**
 * @program: myjavastructures
 * @description: 模拟进程
 * @author: Cc.
 * @create: 2019-04-11 19:14
 **/
public class Process implements Comparable<Process> {

    /**
     * @Description: 进程名称
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/11
     */
    private String name;

    /**
     * @Description: 进程优先级默认为5，范围1-10
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/11
     */
    private int priority;

    public Process(String name, int priority){
        this.name = name;
        if(priority >=1 && priority <=10){
            this.priority = priority;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public Process(String name){
        this(name, 5);
    }

    /**
     * @Description: 优先级比较
     * @Param: [o]
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/11
     */
    @Override
    public int compareTo(Process o) {
        return this.priority-o.priority;
    }

    @Override
    public String toString() {
        return "Process{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}
