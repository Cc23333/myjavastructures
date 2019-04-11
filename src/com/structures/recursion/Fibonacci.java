package com.structures.recursion;

import java.math.BigInteger;

/**
 * @program: myjavastructures
 * @description: 斐波那契数列的实现
 * @author: Cc.
 * @create: 2019-04-11 21:06
 **/
public class Fibonacci {
    /**
     * @Description: 斐波那契数列的实现 0，1，1，2，3，5，8，13，21...
     * @Param: [day]
     * @return: long
     * @Author: Cc.
     * @Date: 2019/4/11
     */
    public long fibonacci(int day){
        if(day == 0){
            return 0;
        }else if(day == 1 || day == 2){
            //F(1) = 1
            return 1;
        }else{
            return fibonacci(day -1) + fibonacci(day - 2);//F(n) = F(n-1) + F(n-2)
        }
    }

    /**
     * @Description: 更为简洁的写法
     * @Param: [day]
     * @return: long
     * @Author: Cc.
     * @Date: 2019/4/11
     */
    public long fib(int day){
        return day == 0 ? 0 : (day == 1 || day == 2 ? 1: fib(day - 1) + fib(day - 2));
    }

    //BigInteger可以防止数据异常
    //BigInteger 任意大的整数，原则上是，只要你的计算机的内存足够大，可以有无限位的
    // 递推实现方式（迭代的方式效率高，时间复杂度O(n)）
    public BigInteger fibonacciN(int n){
        if(n == 1){
            return new BigInteger("0");
        }
        BigInteger n1 = new BigInteger("0");
        BigInteger n2 = new BigInteger("1");
        //记录最终值f(n)
        BigInteger sn = new BigInteger("0");
        for(int i=0; i<n-1; i++){
            sn = n1.add(n2);
            n1 = n2;
            n2 = sn;
        }
        return sn;
    }

    // 与上述相同的递推实现方式 ，使用long返回值，当n过大会造成数据溢出，计算结果可能是一个未知的负数，因此建议使用BigInteger
    public  long fibonacciNormal(int n){
        if(n <= 2){
            return 1;
        }
        long n1 = 1, n2 = 1, sn = 0;
        for(int i = 0; i < n - 2; i ++){
            sn = n1 + n2;
            n1 = n2;
            n2 = sn;
        }
        return sn;
    }

    //测试
    public static void main(String[] args){
        Fibonacci fibonacci=new Fibonacci();
        long now =System.currentTimeMillis();
//        System.out.println("第11天动物数量为:"+ fibonacci.fib_i(1,1,50));
//        System.out.println("第11天动物数量为:"+ fibonacci.fib(50));//12586269025
        System.out.println("第11天动物数量为:"+ fibonacci.fibonacciNormal(100));//12586269025
//        System.out.println("第11天动物数量为:"+ fibonacci.fibonacci(10));
        System.out.println("执行第500天的时间为:"+(System.currentTimeMillis()-now));
    }
}


