package com.structures.tree.binarytree;

import com.structures.queue.LinkedQueue;

/**
 * @program: myjavastructures
 * @description: 利用层次遍历原理构造完全二叉树
 * @author: Cc.
 * @create: 2019-04-11 21:33
 **/
public class CompleteBinaryTree<T extends Comparable> extends BinarySearchTree<T> {

    /**
     * @Description: 构建空的完全二叉树
     * @Param: []
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/11
     */
    public CompleteBinaryTree(){
        super();
    }

    /**
     * @Description: 以层次遍历构造完全二叉树
     * @Param: [levelOrderArray]
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/11
     */
    public CompleteBinaryTree(T[] levelOrderArray){
        this.root = create(levelOrderArray, 0);
    }

    /**
     * @Description: 层次遍历构造完全二叉树
     * @Param: [levelOrderArray, i]
     * @return: com.structures.tree.binarytree.BinaryNode<T>
     * @Author: Cc.
     * @Date: 2019/4/11
     */
    public BinaryNode<T> create(T[] levelOrderArray, int i){
        if(levelOrderArray == null){
            throw new RuntimeException();
        }
        BinaryNode<T> p = null;
        if(i < levelOrderArray.length){
            //递归结束的条件
            p = new BinaryNode<T>(levelOrderArray[i], null, null);
            p.left = create(levelOrderArray, 2*i+1);//根据完全二叉树的性质2*i+1为左孩子节点
            p.right = create(levelOrderArray, 2*i+2);//2*i+2为右孩子节点
        }
        return p;
    }

    @Override
    public boolean contains(T data){
        //存放需要遍历的节点，左节点一定优先于右节点遍历
        LinkedQueue<BinaryNode<T>> queue = new LinkedQueue<>();
        StringBuffer sb = new StringBuffer();
        BinaryNode<T> p = this.root;
        while(p != null){
            //判断是否存在data
            if(data.compareTo(p.data) == 0){
                return true;
            }
            //先按层次遍历节点，左节点一定在右节点之前访问
            if(p.left != null){
                queue.add(p.left);
            }
            if(p.right != null){
                queue.add(p.right);
            }
            //访问下一个节点
            p = queue.poll();
        }
        return false;
    }
    /**
     * 搜索二叉树的包含操作和移除操作不适合层次遍历构造的完全二叉树
     * @param data
     * @return
     */
    @Override
    public void remove(T data) {
        //do nothing 取消删除操作
    }

    /**
     * 完全二叉树只通过层次遍历来构建,取消insert操作
     * @param data
     */
    @Override
    public void insert(T data) {
        //do nothing //取消insert操作
    }


    /**
     * 测试
     * @param args
     */
    public static void main(String args[])
    {

        String[] levelorderArray = {"A","B","C","D","E","F"};
        CompleteBinaryTree<String> cbtree = new CompleteBinaryTree<>(levelorderArray);
        System.out.println("先根遍历:"+cbtree.preOrder());
        System.out.println("非递归先根遍历:"+cbtree.preOrderTraverse());
        System.out.println("中根遍历:"+cbtree.inOrder());
        System.out.println("非递归中根遍历:"+cbtree.inOrderTraverse());
        System.out.println("后根遍历:"+cbtree.postOrder());
        System.out.println("非递归后根遍历:"+cbtree.postOrderTraverse());
        System.out.println("查找最大结点(根据搜索二叉树):"+cbtree.findMax());
        System.out.println("查找最小结点(根据搜索二叉树):"+cbtree.findMin());
        System.out.println("判断二叉树中是否存在E:"+cbtree.contains("E"));

    }
}
