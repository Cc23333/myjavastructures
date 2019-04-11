package com.structures.recursion;

/**
 * @program: myjavastructures
 * @description: 汉诺塔的递归算法实现
 * @author: Cc.
 * @create: 2019-04-11 20:01
 **/
public class HanoiRecursion {
    /**
     * @Description:  
     * @Param: [n, x, y, z] n 汉诺塔的层数 x x柱 起点柱(A) y y柱 目标柱(B) z z柱 中转柱(C) 其中 A B C 只是作为辅助思考
     * @return: void 
     * @Author: Cc.
     * @Date: 2019/4/11 
     */
    public void hanoi(int n, char x, char y, char z){
        //H(0)=0
        if(n == 0){
            //什么也不做
        }else{
            //H(n) = H(n-1) + 1 + H(n-1)
            //将n-1个圆盘从x移动到z,y为中转柱
            hanoi(n-1, x, y, z); //解出n-1层汉诺塔：H(n-1)
            //移动最大圆盘到目的柱
            System.out.println(x+"->"+y);
            //将n-1个圆盘从z移动到y,x为中转柱
            hanoi(n-1, z, y, x); //解出n-1层汉诺塔：H(n-1)
        }
    }

    /**
     * @Description: 汉诺塔层数问题  x x柱 起点柱(A) y y柱 目标柱(B) z z柱 中转柱(C) 其中 A B C 只是作为辅助思考
     * @Param: [n, x, y, z]
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/11
     */
    public int hanoiCount(int n, char x, char y, char z){
        int moveCount = 0;
        if(n == 0){
            return 0;
        }else{
            moveCount += hanoiCount(n-1, x, y, z);
            moveCount += 1;
            moveCount += hanoiCount(n-1, z, y, x);
        }
        return moveCount;
    }

    //测试
    public static void main(String[] args){
        HanoiRecursion hanoi=new HanoiRecursion();
        System.out.println("moveCount="+hanoi.hanoiCount(6,'A','B','C'));

        hanoi.hanoi(3,'A','B','C');
    }
}
