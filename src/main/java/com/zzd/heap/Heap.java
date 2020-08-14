package com.zzd.heap;

public class Heap {
    private int[] tree;
    private int length;

    public Heap(int[] tree, int length){
        this.tree=tree;
        this.length=length;
        buildHeap(tree,length);
    }

    public int[] getArr(){
        return tree;
    }

    //i是heapify的起点的数组下标
    //n是树的节点总个数 n-1是数组最大下标
    private void heapify(int i,int n){
        //当i超过数组最大下标 return
        if (i>=n){
            return;
        }
        int c1=2*i+1;//左孩子的下标
        int c2=2*i+2;//右孩子的下标
        int max=i;//先假设当前下标对应的值是最大的
        if (c1<n && tree[max]<tree[c1]){
            max=c1;
        }
        if (c2<n && tree[max]<tree[c2]){
            max=c2;
        }
        //上面两段是甄选出俩孩子和父中其中值是最大的那个下标
        //左右孩子的下标要在数组的下标范围内
        if (max!=i){//如果max不是父 才要递归进行
            swap(max,i);//让三角形里最大的值位于i的位置
            heapify(max,n);
        }
    }

    //交换数组中指定俩下标的值
    private void swap(int i , int j){
        int temp=tree[i];
        tree[i]=tree[j];
        tree[j]=temp;
    }

    private void buildHeap(int[] tree,int length){
        int n = (length-2)/2;//最后一个节点的父节点
        for (int i = n ; i>=0 ; i--){
            heapify(i,length);
        }
    }

    public void heapSort(){
        for (int i = length-1; i >= 0 ; i--) {
            swap(i,0);
            heapify(0,i);
        }
    }
}
