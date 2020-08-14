package com.zzd.bishi;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TestBishi {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }

    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public int jump(int n){
        return 1<<(n-1);
    }

    public boolean Find(int target, int [][] array) {
        int maxy=array.length-1;
        int x=array[0].length-1;
        int y=0;
        while(y<=maxy && x>=0){
            if (array[y][x]==target){
                return true;
            } else if(target>array[y][x]){
                y++;
                continue;
            } else if (array[y][x]>target){
                x--;
                continue;
            }
        }
        return false;
    }

    public String replaceSpace(StringBuffer str) {
        char[] chars = str.toString().toCharArray();
        StringBuffer sb=new StringBuffer();
        for (char c : chars) {
            if (c==' '){
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack=new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> list=new ArrayList<>();
        while (stack.size()!=0){
            list.add(stack.pop());
        }
        return list;
    }

    @Test
    public void testFind1(){
        int [][] array=new int[5][4];
        System.out.println(array.length);
        System.out.println(array[0].length);
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    @Test
    public void testFind(){
        int array[][]={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(7, array));
        System.out.println(Find(5, array));
    }

    @Test
    public void testReplaceSpace(){
        StringBuffer sb=new StringBuffer("We Are Happy.");
        System.out.println(replaceSpace(sb));

    }

}
