package com.structures.tree;

import com.structures.queue.LinkedQueue;
import com.structures.stack.LinkedStack;

/**
 * @program: javastructures
 * @description: 二叉搜索树
 * @author: Cc.
 * @create: 2019-04-05 13:16
 **/
public class BinarySearchTree<T extends Comparable> implements Tree<T> {

    /**
     * @Description: 根节点
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    protected BinaryNode<T> root;

    public BinarySearchTree(){
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * @Description: 计算树的大小（节点总数） 
     * @Param: [] 
     * @return: int 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    @Override
    public int size() {
        return size(root);
    }

    /**
     * @Description:  递归实现：定义根节点root后，再用subtree实现递归
     * @Param: [subtree] 
     * @return: int 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    private int size(BinaryNode<T> subtree){
        if(subtree == null){
            return 0;
        }else{
            //对比汉诺塔：H(n) = H(n-1) + 1 + H(n-1);
            return size(subtree.left) + 1 + size(subtree.right);
        }
    }
    
    /**
     * @Description: 计算树的深度 
     * @Param: [] 
     * @return: int 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    @Override
    public int height() {
        return height(root);
    }
    
    /**
     * @Description: 递归计算树的深度 
     * @Param: [subtree] 
     * @return: int 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    private int height(BinaryNode<T> subtree){
        if(subtree == null){
            return 0;
        }else{
            int l = height(subtree.left);
            int r = height(subtree.right);
            //返回并加上当前层
            return (l>r) ? (l+1):(r+1);
        }
    }

    @Override
    public String preOrder() {
        String sb = preOrder(root);
        if(sb.length() > 0){
            //去掉尾部“，”号
            sb = sb.substring(0, sb.length()-1);
        }
        return sb;
    }

    /**
     * @Description: 先根遍历 
     * @Param: [subtree] 
     * @return: java.lang.String 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    private String preOrder(BinaryNode<T> subtree){
        StringBuffer sb = new StringBuffer();
        if(subtree != null){    //递归结束条件
            //先访问根节点
            sb.append(subtree.data + ",");
            //遍历左子树
            sb.append(preOrder(subtree.left));
            //遍历右子树
            sb.append(preOrder(subtree.right));
        }
        
        return sb.toString();
    }

    /**
     * @Description: 非递归的先根遍历
     * @Param: []
     * @return: java.lang.String
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    public String preOrderTraverse(){
        StringBuffer sb = new StringBuffer();
        //构建用于存放节点的栈
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();

        BinaryNode<T> p = this.root;

        while(p !=null || !stack.isEmpty()){
            if(p != null){
                //访问该节点
                sb.append(p.data + ",");

                //将已经访问过的节点入栈
                stack.push(p);

                //继续访问其左孩子，直到 p 为 null
                p = p.left;
            }else{  //若 p==null 栈不为空，则说明已沿左子树访问完一条路径，从栈中弹出栈顶结构，并访问其右孩子
                //获取已访问过的节点记录
                p = stack.pop();
                p = p.right;
            }
        }

        //去掉最后一个逗号“,”
        if(sb.length() > 0){
            return sb.toString().substring(0, sb.length()-1);
        }else{
            return sb.toString();
        }
    }
    
    @Override
    public String inOrder() {
        String sb = inOrder(root);
        if(sb.length() >0){
            sb = sb.substring(0, sb.length()-1);
        }
        return sb;
    }
    
    /**
     * @Description: 中根遍历 
     * @Param: [subtree] 
     * @return: java.lang.String 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    private String inOrder(BinaryNode<T> subtree){
        StringBuffer sb = new StringBuffer();
        if(subtree != null){    //递归结束条件
            //先遍历左子树
            sb.append(inOrder(subtree.left));
            //再遍历根节点
            sb.append(subtree.data + ",");
            //最后遍历右子树
            sb.append(inOrder(subtree.right));
        }
        return sb.toString();
    }
    
    /**
     * @Description: 非递归的中根遍历 
     * @Param: [] 
     * @return: java.lang.String 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    public String inOrderTraverse(){
        StringBuffer sb = new StringBuffer();
        
        //构建用于存放节点的栈
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
        
        BinaryNode<T> p = this.root;
        
        while(p != null || !stack.isEmpty()){
            while(p != null){   //把左孩子都入栈，直到左孩子为 null
                stack.push(p);
                p = p.left;
            }
            
            //如果栈不为空，因为前面的左孩子已经全部入栈
            if(!stack.isEmpty()){
                p = stack.pop();
                //访问 p 节点
                sb.append(p.data + ",");
                //访问 p 节点的右孩子
                p = p.right;
            }
        }
        
        if(sb.length() > 0){
            return sb.toString().substring(0, sb.length()-1);
        }else{
            return sb.toString();
        }
    }

    @Override
    public String postOrder() {
        String sb = postOrder(root);
        if(sb.length() >0){
            //去掉尾部“,”号
            sb = sb.substring(0, sb.length()-1);
        }

        return sb;
    }

    /**
     * @Description: 后根遍历
     * @Param: [subtree]
     * @return: java.lang.String
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    private String postOrder(BinaryNode<T> subtree){
        StringBuffer sb = new StringBuffer();
        if(subtree != null){    //递归结束条件
            //先遍历左子树
            sb.append(postOrder(subtree.left));
            //再遍历右子树
            sb.append(postOrder(subtree.right));
            //最后遍历根节点
            sb.append(subtree.data + ",");
        }

        return sb.toString();
    }

    /**
     * @Description: 非递归后根遍历
     * @Param: [] 
     * @return: java.lang.String 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    public String postOrderTraverse(){
        StringBuffer sb = new StringBuffer();
        
        //构建用于存放节点的栈
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
        
        BinaryNode<T> currentNode = this.root;
        BinaryNode<T> prev = this.root;
        
        while(currentNode != null || !stack.isEmpty()){
            //把左子树加入栈中，直到叶子节点为止
            while(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            
            //开始访问当前节点父节点的右孩子
            if(!stack.isEmpty()){
                //获取右孩子，先不弹出
                BinaryNode<T> temp = stack.peek().right;
                //先判断是否有右孩子或者右孩子是否被访问过
                if(temp == null || temp == prev){   //没有右孩子 || 右孩子已被访问过
                    //如果没有右孩子或者右孩子已被访问过，则弹出父节点并访问
                    currentNode = stack.pop();
                    //访问
                    sb.append(currentNode.data + ",");
                    //记录以访问过的节点
                    prev = currentNode;
                    currentNode = null;
                }else{
                    //有右孩子，则开始遍历右子树
                    currentNode = temp;
                }
            }
        }
        
        if(sb.length() > 0){
            return sb.toString().substring(0, sb.length()-1);
        }else{
            return sb.toString();
        }
    }

    /**
     * @Description: 层次遍历 
     * @Param: [] 
     * @return: java.lang.String 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    @Override
    public String levelOrder() {
        LinkedQueue<BinaryNode<T>> queue = new LinkedQueue<BinaryNode<T>>();
        StringBuffer sb = new StringBuffer();
        BinaryNode<T> p = this.root;

        while(p != null){
            //记录经过的节点
            sb.append(p.data);

            //先按层次遍历节点，左节点一定在右节点之前访问
            if(p.left != null){
                //孩子节点入队
                queue.add(p.left);
            }
            if(p.right != null){
                queue.add(p.right);
            }

            //访问下一个节点
            p = queue.poll();
        }
        return sb.toString();
    }

    @Override
    public void insert(T data) {
        if(data == null){
            throw new RuntimeException("data can\'Comparable be null!");
        }
        //插入操作
        root = insert(data, root);
    }

    /**
     * @Description: 插入操作，递归实现
     * @Param: [data, p]
     * @return: com.structures.tree.BinaryNode<T>
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    private BinaryNode<T> insert(T data, BinaryNode<T> p){
        if(p == null){
            p = new BinaryNode<>(data, null, null);
        }

        //比较插入节点的值，决定向左子树还是右子树搜索
        int compareResult = data.compareTo(p.data);

        if(compareResult <0){
            //左
            p.left = insert(data, p.left);
        }else if(compareResult >0){
            //右
            p.right = insert(data, p.right);
        }else {
            //已有元素就没必要插入了
        }
        return p;
    }

    @Override
    public void remove(T data) {
        if(data == null){
            throw new RuntimeException("data can\'Comparable be null!");
        }

        //删除节点
        root = remove(data, root);
    }

    /**
     * @Description: 分三种情况：
     *               1.删除叶子节点（也就是没有孩子的节点）
     *               2.删除用于一个孩子节点的节点（可能是左孩子也可能是右孩子）
     *               3.删除拥有两个孩子的节点的节点
     * @Param: [data, p]
     * @return: com.structures.tree.BinaryNode<T>
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    private BinaryNode<T> remove(T data, BinaryNode<T> p){
        //没有找到要删除的元素，递归结束
        if(p == null){
            return p;
        }

        int compareResult = data.compareTo(p.data);

        if(compareResult <0){
            //左边查找删除节点
            p.left = remove(data, p.left);
        }else if(compareResult >0){
            p.right = remove(data, p.right);
        }else if(p.left !=null && p.right != null){
            //已找到节点并判断是否有两个孩子节点
            //中继替换，找到右子树中最小的元素并替换需要删除的元素值
            p.data = findMin(p.right).data;
            //移除用于替换的节点
            p.right = remove(p.data, p.right);
        }else{
            //拥有一个孩子节点的节点和叶子节点的情况
            p=(p.left != null) ? p.left : p.right;
        }

        //返回该节点
        return p;
    }

    /**
     * @Description: 非递归删除 
     * @Param: [data] 
     * @return: T 
     * @Author: Cc.
     * @Date: 2019/4/5 
     */
    public T removeUnrecure(T data){
        if(data == null){
            throw new RuntimeException("data Can\'Comparable be null!");
        }

        //从根节点开始查找
        BinaryNode<T> current = this.root;
        //记录父节点
        BinaryNode<T> parent = this.root;
        //判断左右孩子的flag
        boolean isLeft = true;

        //找到要删除的节点
        while (data.compareTo(current.data) != 0){
            //更新父节点记录
            parent = current;
            int result = data.compareTo(current.data);

            if(result <0){
                //从左子树查找
                isLeft = true;
                current = current.left;
            }else if(result >0){
                //从右子树查找
                isLeft = false;
                current = current.right;
            }

            //如果没有找到，返回null
            if(current == null){
                return null;
            }
        }

        //到这里说明已经找到要删除的节点

        //删除的是叶子节点
        if(current.left == null && current.right ==null){
            if(current == this.root){
                this.root = null;
            }else if(isLeft){
                parent.left = null;
            }else {
                parent.right = null;
            }
        }

        //删除带有一个孩子节点的节点，当 current 的 right 不为 null
        else if(current.left == null){
            if(current == this.root){
                this.root = current.right;
            }else if(isLeft){
                //current 为 parent 的左孩子
                parent.left = current.right;
            }else {
                parent.right = current.right;
            }
        }

        //删除带有一个孩子节点的节点，当 current 的 left 不为 null
        else if(current.right == null){
            if(current == this.root){
                this.root = current.left;
            }else if(isLeft){
                //current 为 parent 的左孩子
                parent.left = current.left;
            }else {
                //current 为 parent 的右孩子
                parent.right = current.left;
            }
        }

        //删除带有两个孩子节点的节点
        else{
            //找到当前要删除节点 current 的右子树中最小值元素
            BinaryNode<T> successor = findSuccessor(current);

            if(current == root){
                this.root = successor;
            }else if(isLeft){
                parent.left = successor;
            }else{
                parent.right = successor;
            }

            //把当前要删除的节点的左孩子赋值给 successor
            successor.left = current.left;
        }
        return current.data;
    }

    /**
     * @Description: 查找中继节点--右子树最小值节点
     * @Param: [delNode]
     * @return: com.structures.tree.BinaryNode<T>
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    public BinaryNode<T> findSuccessor(BinaryNode<T> delNode){
        BinaryNode<T> successor = delNode;
        BinaryNode<T> successorParent = delNode;
        BinaryNode<T> current = delNode.right;

        //不断查找左节点，直到为空为止，则 successor 为最小值节点
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        //如果要删除节点的右孩子与 successor 不相等，则执行如下操作（如果相当，则说明删除节点）
        if(successor != delNode.right){
            successorParent.left = successor.right;
            //把中继节点的右孩子指向当前要删除节点的右孩子
            successor.right = delNode.right;
        }

        return successor;
    }

    @Override
    public T findMax() {
        if(isEmpty()){
            throw new RuntimeException("BinarySearchTree is empty!");
        }

        return findMax(root).data;
    }

    @Override
    public T findMin() {
        if(isEmpty()){
            throw new RuntimeException("BinarySearchTree is empty!");
        }

        return findMin(root).data;
    }

    /**
     * @Description: 查找最大值节点
     * @Param: [p]
     * @return: com.structures.tree.BinaryNode<T>
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    private BinaryNode<T> findMax(BinaryNode<T> p){
        if(p == null){
            //结束条件
            return null;
        }else if(p.right == null){
            return p;
        }
        return findMax(p.right);
    }

    private BinaryNode<T> findMin(BinaryNode<T> p){
        if(p == null){
            //结束条件
            return null;
        }else if(p.left == null){
            return p;
        }
        return findMin(p.right);
    }

    @Override
    public BinaryNode findNode(T data) {
        return null;
    }

    @Override
    public boolean contains(T data) throws Exception {
        return false;
    }

    @Override
    public void clear() {

    }
}