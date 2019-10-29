package com.lh.t1;

public class Demo2 {
    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5,6};//升序
        revArry(ints);
        System.out.println(12);
        System.out.println(13);
    }
    /*
    *    升序->倒序
     */
    private static void revArry(int[] nums){
        for (int min = 0,max = nums.length-1; min < max; min++ ,max--) {
            int temp;
            temp = nums[min];
            nums[min] = nums[max];
            nums[max] = temp;
        }

        for (int num : nums) {
            System.out.println(num);
        }

    }
}
