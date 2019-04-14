package com.structures.tree.avltree;

/**
 * @program: myjavastructures
 * @description: 平衡二叉搜索树（AVL)节点
 * @author: Cc.
 * @create: 2019-04-14 15:39
 **/
public class AVLNode<T extends Comparable> {
    /**
    * @Description: 左节点
    * @Param:
    * @return:
    * @Author: Cc.
    * @Date: 2019/4/14
    */
    public AVLNode<T> left;

    /**
    * @Description: 右节点
    * @Param:
    * @return:
    * @Author: Cc.
    * @Date: 2019/4/14
    */
    public AVLNode<T> right;

    public T data;

    /**
    * @Description: 当前节点的高度
    * @Param:
    * @return:
    * @Author: Cc.
    * @Date: 2019/4/14
    */
    public int height;

    public AVLNode(T data) {
        this(null,null,data);
    }

    public AVLNode(AVLNode<T> left, AVLNode<T> right, T data) {
        this(left,right,data,0);
    }

    public AVLNode(AVLNode<T> left, AVLNode<T> right, T data, int height) {
        this.left=left;
        this.right=right;
        this.data=data;
        this.height = height;
    }
}
