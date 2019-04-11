package com.structures.LinkedList.SeqList;

import com.structures.LinkedList.ISeqList;


/**
 * @program: javastructures
 * @description: 顺序表
 * @author: Cc.
 * @create: 2019-04-05 19:26
 **/
public class SeqList<T> implements ISeqList<T> {

    /**
     * @Description: 数组声明，用于存储元素
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    private Object[] table;

    /**
     * @Description: 顺序表的大小
     * @Param:
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    private int length;

    public SeqList(int capacity) {
        // 申请数组存储空间，元素初始化为 null
        this.table = new Object[Math.abs(capacity)];
        this.length = 0;
    }

    /**
     * @Description: 默认大小64
     * @Param: []
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    public SeqList() {
        this(64);
    }

    /**
     * @Description: 传入一个数组初始化顺序表
     * @Param: [array]
     * @return:
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    public SeqList(T[] array) {
        if (array == null) {
            throw new NullPointerException("array can\'t be empty!");
        }

        // 创建对应容量的数组
        this.table = new Object[array.length];

        // 复制元素
        for (int i = 0; i < array.length; i++) {
            this.table[i] = array[i];
        }

        this.length = array.length;
    }

    /**
     * @Description: 判断顺序表是否为空
     * @Param: []
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    /**
     * @Description: 计算顺序表的大小
     * @Param: []
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    @Override
    public int length() {
        return this.length;
    }

    /**
     * @Description: 根据 index 获取元素
     * @Param: [index]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    @Override
    public T get(int index) {
        if (index >= 0 && index < this.length) {
            return (T)this.table[index];
        }
        return null;
    }

    /**
     * @Description: 根据传递的索引值 index 替换元素
     * @Param: [index, data]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    @Override
    public T set(int index, T data) {
        if (index >= 0 && index < this.length && data != null) {
            T old = (T)this.table[index];
            this.table[index] = data;
            return old;
        }
        return null;
    }

    /**
     * @Description: 根据 index 插入元素
     * @Param: [index, data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    @Override
    public boolean add(int index, T data) {
        if (data == null) {
            return false;
        }

        // 插入下标的容错判断，插入在最前面
        if (index < 0) {
            index = 0;
        }

        // 插入下标的容错判断，插入在最后面
        if (index > this.length) {
            index = this.length;
        }

        if (this.length == table.length) {
            // 把原数组赋值给临时数组
            Object[] temp = this.table;

            // 对原来的数组进行成倍扩容，并把原数组的元素复制到新数组
            this.table = new Object[temp.length * 2];

            // 先把原数组下标从 O 到 index-1 (即插入位置的前一个位置)复制到新数组
            for (int i = 0; i < index; i++) {
                this.table[i] = temp[i];
            }
        }
        // 从原数组的最后一个元素直到 index 位置，都往后一个位置
        // 腾出来的位置就是最新插入元素的位置了
        for (int j = this.length - 1; j >= index; j--) {
            this.table[j + 1] = this.table[j];
        }

        // 插入新值
        this.table[index] = data;
        // 长度加一
        this.length++;
        // 插入成功
        return true;
    }

    /**
     * @Description: 在尾部插入元素
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    @Override
    public boolean add(T data) {
        return add(this.length, data);
    }

    /**
     * @Description: 根据 index 删除元素
     * @Param: [index]
     * @return: T
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    @Override
    public T remove(int index) {
        if(this.length != 0 && index >=0 && index < this.length){
            //记录删除元素的值并返回
            T old = (T) this.table[index];

            //从被删除的元素位置开始，其后的元素都依次往前移动
            for(int j=index; j<this.length-1; j++){
                this.table[j] = this.table[j+1];
            }

            //设置数组元素对象为空
            this.table[this.length-1] = null;
            //顺序表长度减一
            this.length--;
            return old;
        }
        return null;
    }

    /**
     * @Description: 根据data删除某个数据
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    @Override
    public boolean remove(T data) {
        if (this.length != 0 && data != null) {
            return remove(this.indexOf(data)) != null;
        }
        return false;
    }

    /**
     * @Description: 根据 data 删除元素
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    @Override
    public boolean removeAll(T data) {
        boolean done = false;
        if (this.length != 0 && data != null) {
            int i = 0;
            while (i < this.length) {
                if (data.equals(this.table[i])) {
                    // 根据下标删除
                    this.remove(i);
                    done = true;
                } else {
                    // 继续查找
                    i++;
                }
            }
        }
        return done;
    }

    /**
     * @Description: 清空顺序表
     * @Param: []
     * @return: void
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    @Override
    public void clear() {
        this.length = 0;
    }

    /**
     * @Description: 判断两个顺序表是否相等
     * @Param: [obj]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    @Override
    public boolean equals(Object obj) {
        // 如果内存地址相当，那么两个顺序肯定相等
        if (this == obj) {
            return true;
        }

        // 判断是否属于同种类型对象
        if (obj instanceof SeqList) {
            // 强制转换成顺序表
            SeqList<T> list = (SeqList<T>)obj;
            for (int i = 0; i < this.length(); i++) {
                if (!(this.get(i).equals(list.get(i)))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * @Description: 查询是否包含某个数据
     * @Param: [data]
     * @return: boolean
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    @Override
    public boolean contains(T data) {
        return this.indexOf(data) >= 0;
    }

    /**
     * @Description: 根据数据查询下标
     * @Param: [data]
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    @Override
    public int indexOf(T data) {
        if (data != null) {
            for (int i = 0; i < this.length; i++) {
                if (this.table[i].equals(data)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * @Description: 根据 data 查询最后一个出现在顺序表中的下标
     * @Param: [data]
     * @return: int
     * @Author: Cc.
     * @Date: 2019/4/5
     */
    @Override
    public int lastIndexOf(T data) {
        if (data != null) {
            for (int i = this.length - 1; i >= 0; i--) {
                if (data.equals(this.table[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String str = "(";
        if (this.length != 0) {
            for (int i = 0; i < this.length - 1; i++) {
                str += this.table[i].toString() + ",";
            }
            str += this.table[this.length - 1].toString();
        }
        return str + ")";
    }
}
