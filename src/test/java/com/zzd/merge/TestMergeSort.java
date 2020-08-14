package com.zzd.merge;

import org.junit.Test;

import java.util.Arrays;

public class TestMergeSort {
    @Test
    public void testMergeSort(){
        int[] arr={8,7,6,5,5,1,2,3,4,10,8,15,48,65,541};
        System.out.println(arr.length);
        MergeSort m=new MergeSort(arr);
        int[] arr2=m.getArr();
        System.out.println(arr2.length);
        System.out.println(Arrays.toString(arr2));

    }
}
