package com.sucre.datastructures.datastructure.tasks;

import java.util.*;

public class Simple {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;
        int pMerge = m + n - 1;

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[pMerge--] = nums1[p1--];
            } else {
                nums1[pMerge--] = nums2[p2--];
            }
        }
    }

    public static int removeElement(int[] nums, int val) {

        //loop throught all the elements
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i;

    }

    public static int removeDuplicates(int[] nums) {

        int i = 0;
        for (int j = 0; nums.length > j; j++) {
            if (j == 0) {
                nums[i] = nums[j];
                i++;
            } else {
                int prevtemp = nums[j - 1];
                int currentVal = nums[j];

                if (prevtemp != currentVal) {
                    nums[i] = nums[j];
                    i++;
                }
            }
        }
        return i;
    }

    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;

        for (int j = 0; n > j; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
        }

        n = n / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }

        return 0;
    }

    public static int romanToInt(String s) {
        //map symbol to value
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] array = s.toCharArray();

        int j = 0;
        char prev = array[j];

        int val = 0;

        for (int i = 0; i < array.length; i++) {


            if (i == 0) {
                val = val + map.get(array[i]);


            } else if (map.get(array[i - 1]) < map.get(array[i])) {
                val = val - (map.get(array[i - 1])) + (map.get(array[i]) - map.get(array[i - 1]));


            } else {

                int ok = map.get(array[i]);
                val = val + ok;
            }

        }
        return val;

    }

    public static boolean processLinkedList(String palidrom) {

        LinkedList<Character> queue = new LinkedList<>();

        LinkedList<Character> stack = new LinkedList<>();

        String lowerCase = palidrom.toLowerCase();

        for (int i = 0; i < palidrom.length(); i++) {

            char c = lowerCase.charAt(i);

            if(c>='a' && c<='z'){

                queue.addLast(c);
                stack.push(c);
            }

        }

        while(!stack.isEmpty()){

            if(!queue.removeFirst().equals(stack.pop())){

                return false;

            }
        }

        return true;


    }

    public static boolean stackChallenge(String s){

        LinkedList<Character> frontstack = new LinkedList<>();
        LinkedList<Character> backstack = new LinkedList<>();

        String lowerCase=s.toLowerCase();

        for(int i=0;i<s.length();i++){
            char c= lowerCase.charAt(i);
            if(c>='a' & c<='z'){
                frontstack.push(c);
            }
        }

        for(int j=s.length();j>0;j--){
            char c=lowerCase.charAt(j);

            if(c>='a' && c<='z'){
                backstack.push(c);
            }
        }

        while(!frontstack.isEmpty()){
            if(!frontstack.pop().equals(backstack.pop())){
                return false;
            }
        }
        return true;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int startIdx = -1;
        int[] arrIdx = new int[gas.length];
        Arrays.fill(arrIdx, -1); //fill our array with -1;

        for(int i = 0; i < gas.length; i++) {
            if(gas[i] >= cost[i]) {
                arrIdx[i] = Math.abs(gas[i] - cost[i]);
            }
        }

        for(int i = arrIdx.length - 1; i >= 0; i--) {
            if(arrIdx[i] != -1) {
                startIdx = startingIndex(i, gas, cost);
                if(startIdx >= 0) return startIdx;
            }
        }

        return startIdx;

    }

    public static int startingIndex(int startIdx, int[] gas, int[] cost) {
        int n = gas.length;
        int tank = 0 + gas[startIdx];

        int k = 0;
        while(k < n) {
            if(startIdx + k == n - 1) {
                if(tank < cost[startIdx + k]){
                    return -1;
                }else{
                    tank = tank - cost[startIdx + k] + gas[0];
                }
            }else if(startIdx + k > n - 1) {
                int idx = startIdx + k - n;
                if(tank < cost[idx]) {
                    return -1;
                }else {
                    tank = tank - cost[idx] + gas[idx + 1];
                }
            }else{
                if(tank < cost[startIdx + k]) {
                    return -1;
                }else {
                    tank = tank - cost[startIdx + k] + gas[startIdx + k + 1];
                }
            }

            k++;
        }

        return startIdx;
    }

    public static int candy(int[] ratings) {
        int sz = ratings.length;
        int maxRat = 2 * 10000 + 1;
        int cand[] = new int[sz];
        Arrays.fill(cand, 1);
        int minCand = 0;
        for(int indx = 0; indx < sz; indx++){
            int leftNeigh = (indx - 1) > -1 ? ratings[indx-1] : maxRat;
            int self = ratings[indx];
            if(self > leftNeigh){
                cand[indx] = cand[indx-1] + 1;
            }
        }
        for(int indx = sz-1; indx > -1; indx--){
            int rightNeigh =(indx + 1) < sz ? ratings[indx + 1] : maxRat;
            int self = ratings[indx];
            if(self > rightNeigh){
                if(cand[indx] <= cand[indx+1])
                    cand[indx] = cand[indx+1] + 1;
            }
        }
        for(var c : cand){
            minCand += c;
        }
        return minCand;
    }

    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        var m=M[num/1000];


        var cm=num%1000;
        var cmv=(num%1000)/100;
        var c=C[(num%1000)/100];

        var xp=2209%100;
        var xc=num%100;
        var x=X[(num%100)/10];
        var i=I[num%10];


        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    public static String reverseWords(String s) {

        String sc=s.trim();

        String rs="";
        int prev_point=sc.length();

        int len=sc.length();
        for(int i=len-1;i>0;i--){

            char c=sc.charAt(i);
            if(c==' '){

                //include the test
                rs=rs + sc.substring(i,prev_point)+" ";
                prev_point=i;

                while(sc.charAt(i-1)==' ') {
                    prev_point=prev_point-1;
                    i--;
                }


            }

        }

        return rs=rs+sc.substring(0,prev_point);
    }

    public static int strStr(String haystack, String needle) {
        for(int i=0;i+needle.length()<=haystack.length(); i++){

            String  x=haystack.substring(i,i+needle.length());
            if(needle.equals(x)){
                return i;
            }

        }

        return -1;
    }

}
