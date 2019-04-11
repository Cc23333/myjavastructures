package com.structures.linkedlist.xorlinkedlist;

/**
 * @program: myjavastructures
 * @description: 异或节点
 * @author: Cc.
 * @create: 2019-04-09 14:51
 **/
public class XORNode<T> {
    private T data;
    /**
    * @Description: 异或指针
    * @Param:
    * @return:
    * @Author: Cc.
    * @Date: 2019/4/9
    */
    private XORNode<T> ptrdiff;

    public XORNode(){

    }

    public XORNode(T data, XORNode<T> ptrdiff){
        this.data = data;
        this.ptrdiff = ptrdiff;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public XORNode<T> getPtrdiff() {
        return ptrdiff;
    }

    public void setPtrdiff(XORNode<T> ptrdiff) {
        this.ptrdiff = ptrdiff;
    }
}
