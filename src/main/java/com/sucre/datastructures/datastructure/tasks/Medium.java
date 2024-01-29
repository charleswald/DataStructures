package com.sucre.datastructures.datastructure.tasks;

public class Medium {

    public static int removeDuplicates(int[] nums) {

        int i=1;
        int tc=1;

        for(int j=1;j<nums.length;j++){
            if(nums[j]==nums[j-1]){

                if(tc<2){

                    nums[i]=nums[j];
                    i++;
                    tc=tc+1;
                }

            }else{
                nums[i]=nums[j];
                tc=1;
                i++;
            }
        }
        return i;

    }

    public static boolean canJump(int[] nums) {
        int reachable = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] results= new int[nums.length];

        for(int i=0;i<nums.length;i++){
            int total=1;
            //loop other values foward
            for(int j=i+1; j<nums.length;j++){
                total=total*nums[j];
            }

            //loop other values back
            for(int k=i-1;k>=0;k--){
                total=total*nums[k];
            }

            results[i]=total;

        }

        return results;

    }

    public static int[] productExceptSelfv2(int[] nums) {

        int n = nums.length;
        int result[] = new int[n];

        result[0] = 1;

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;

    }
}
