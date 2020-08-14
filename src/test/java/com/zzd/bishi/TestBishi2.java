package com.zzd.bishi;

import org.junit.Test;

public class TestBishi2 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    // 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    // 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return realReconstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    private TreeNode realReconstructBinaryTree(int[] pre,int prefrom,int preto,int[] in,int infrom,int into){
        if (prefrom>preto || infrom>into){
            return null;
        }
        TreeNode root=new TreeNode(pre[prefrom]);
        for (int i = infrom; i <= into; i++) {
            if (in[i]==root.val){
                root.left=realReconstructBinaryTree(pre,prefrom+1,prefrom+i-infrom,in,infrom,i-1);
                root.right=realReconstructBinaryTree(pre,prefrom+i-infrom+1,preto,in,i+1,into);
            }
        }
        return root;
    }

    @Test
    public void testCBinaryTree(){
        int[] pre={1,2,3,4,5,6,7};
        int[] in={3,2,4,1,6,5,7};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        System.out.println(treeNode.left);
    }

    @Test
    public void testCBinaryTree2(){
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        System.out.println(treeNode.left);
    }

    public int JumpFloor(int target) {
        if(target==1||target==2)
            return target;
        else
            return JumpFloor(target-1)+JumpFloor(target-2);
    }

    @Test
    public void testJumpFloor() {
        System.out.println(JumpFloor(3));
        System.out.println(JumpFloor(5));
        System.out.println(JumpFloor(10));
    }

    //递归  运行时间：817ms  占用内存：9416k
    //数组  运行时间：9ms  占用内存：9344k
    public int Fibonacci(int n) {
        if(n==0||n==1)
            return n;
        int[] arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for (int i = 2; i < n+1; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    @Test
    public void testFibonacci(){
        System.out.println(Fibonacci(4));
        System.out.println(Fibonacci(6));
        System.out.println(Fibonacci(11));
    }

    //把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    //输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    //例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    //NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
    public int minNumberInRotateArray(int [] array) {
        if (array.length==0)
            return 0;
        int left=0;
        int right=array.length-1;
        while (left<right){
            int mid=(left+right)/2;
            if (array[mid]>array[right]){
                left=mid+1;
            } else if (array[mid]<array[right]){
                right=mid;//不能=mid-1 因为mid本身有可能是答案
            } else {//array[mid]==array[right] mid有可能在后半段的最后{3,4,5,1,2,2,2,2,2} 有可能在前半段的最前{2,2,2,2,2,3,4,5,1,2}
                right=right-1;
            }
        }
        return array[left];

    }

    @Test
    public void testMinNumberInRotateArray(){
        /*System.out.println(minNumberInRotateArray(new int[]{3, 4, 5,6,7,8,9,10, 1, 2}));
        System.out.println(minNumberInRotateArray(new int[]{8,9,10,11,12,13,14, 1, 2,3, 4, 5,6,7}));
        System.out.println(minNumberInRotateArray(new int[]{3,4,5,1,2,2,2,2,2}));
        System.out.println(minNumberInRotateArray(new int[]{2,2,2,2,2,3,4,5,1,2}));
        System.out.println(minNumberInRotateArray(new int[]{2,2,2,2,2,2}));*/
        System.out.println(minNumberInRotateArray(new int[]{2,2,2,2,2,3,4,4,4,4,5,5,5,0,0,0,1,1,2,2,2,2,2}));//测试不通过
    }

    public int RectCover(int target) {
        if (target==0||target==1||target==2){
            return target;
        }
        int[] arr=new int[target+1];
        arr[0]=0;
        arr[1]=1;
        arr[2]=2;
        for (int i = 3; i <= target; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[target];
    }

    @Test
    public void testRectCover(){
        System.out.println(RectCover(1));
        System.out.println(RectCover(3));
        System.out.println(RectCover(4));
        System.out.println(RectCover(5));
        System.out.println(RectCover(8));
    }

    public int NumberOf1(int n) {
        char[] chars = Integer.toBinaryString(n).toCharArray();
        int count=0;
        for (char c : chars) {
            if (c=='1')
                count++;
        }
        return count;
    }

    @Test
    public void testToBinaryString(){
        //System.out.println(Integer.toBinaryString(-12).length());
        System.out.println(NumberOf1(127));
        System.out.println(NumberOf1(-2568));
    }


}
