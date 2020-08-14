package com.zzd.heap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestHeap {
    @Test
    public void testHeap(){
        int[] arr={1,4,5,8,7,10,6,12,14};
        Heap heap=new Heap(arr,arr.length);
        System.out.println(Arrays.toString(heap.getArr()));
        heap.heapSort();
        System.out.println(Arrays.toString(heap.getArr()));
    }

    @Test
    public void testHeap2(){
        long t1=System.currentTimeMillis();
        int[] arr={4,5,1,6,2,7,3,8};
        Heap heap=new Heap(arr,arr.length);
        heap.heapSort();
        System.out.println(Arrays.toString(heap.getArr()));
        long t2=System.currentTimeMillis();
        System.out.println(t2+" "+t1);
    }

    @Test
    public void testKHeap(){
        int[] arr={4,5,1,6,2,7,3,8};
        KHeap k=new KHeap();
        int[] heap = k.getHeap(arr);
        System.out.println(Arrays.toString(heap));
    }

    @Test
    public void testKHeap2(){
        int[] arr={4,5,1,6,2,7,3,8,10,9,11,13,12};
        int k=8;
        ArrayList<Integer> integers = new KHeap().GetLeastNumbers_Solution(arr, k);
        System.out.println(integers);
    }
}
