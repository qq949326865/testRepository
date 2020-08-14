package com.zzd.heap;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

public class KHeap {

    private void swap(int[] input,int i,int j){
        int temp=input[i];
        input[i]=input[j];
        input[j]=temp;
    }

    private void heapify(int tree[],int i,int len){
        if (i>=len){
            return;
        }
        int c1=i*2+1;
        int c2=i*2+2;
        int min=i;
        if (c1<len && tree[c1]<tree[min]){
            min=c1;
        }
        if (c2<len && tree[c2]<tree[min]){
            min=c2;
        }
        if (min!=i){
            swap(tree,min,i);
            heapify(tree,min,len);
        }
    }

    private void buildHeap(int[] tree){
        int len=tree.length;
        int n=(len-2)/2;
        for (int i=n;i>=0;i--){
            heapify(tree,i,len);
        }
    }

    public int[] getHeap(int[] arr){
        buildHeap(arr);
        return arr;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
        ArrayList<Integer> res=new ArrayList<>();
        if (k>input.length || k==0){
            return res;
        }

        int[] heap = getHeap(input);
        int len=input.length;
        for (int i=0;i<k;i++){//k=4 i=0 1 2 3
            swap(heap,0,len-i-1);
            heapify(heap,0,len-i-1);
            res.add(heap[len-i-1]);
        }

        return res;
    }
}
