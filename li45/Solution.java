package day9.li45;

import java.util.Arrays;
import java.util.Comparator;

// 把数组排成最小数
public class Solution {
     public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
         for (int i = 0; i < nums.length; i++) {
             strings[i] = String.valueOf(nums[i]);
         }
         Arrays.sort(strings, new Comparator<String>() {
             @Override
             public int compare(String o1, String o2) {
                 return (o1+o2).compareTo(o2 + o1);
             }
         });
         StringBuilder sb = new StringBuilder();
         for (String str : strings){
             sb.append(str);
         }
         return sb.toString();
     }
}
