package com.zzd.merge;

public class MergeSort {

    private int[] arr;
    private int[] temp;

    public MergeSort(int[] arr){
        this.arr=arr;
        this.temp=new int[arr.length];
        sort(arr);
    }

    public int[] getArr(){
        return arr;
    }

    private void sort(int[] arr){
        sort(0,arr.length-1,arr);
    }

    private void sort(int left,int right,int[] arr){
        if(left < right){
            int mid=(left+right)/2;
            sort(left,mid,arr);
            sort(mid+1,right,arr);
            merge(left,mid,right,arr);
        }
    }

    //left最左下标
    //right最右下标
    //mid前后俩有序数组的分界 left~mid为有序 mid+1~right为有序 先当做是从小到大
    private void merge(int left,int mid,int right,int[] arr){
        int i=left;
        int j=mid+1;
        int t=0;
        while (i<=mid && j<=right){
            if (arr[i]<=arr[j]){
                temp[t++]=arr[i++];
            } else {
                temp[t++]=arr[j++];
            }
        }
        while (i<=mid){
            temp[t++]=arr[i++];
        }
        while (j<=right){
            temp[t++]=arr[j++];
        }
        t=0;
        while(left<=right){
            arr[left++]=temp[t++];
        }
    }
}
