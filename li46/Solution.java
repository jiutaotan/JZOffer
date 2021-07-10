package day10.li46;

public class Solution {
    public int translateNum(int num) {
       return reCount(num);
    }
    int reCount(int num){
        if (num < 10){
            return 1;
        }
        if (num % 100 < 26 && num % 100 > 9){
            return reCount(num / 10) + reCount(num / 100);
        }else {
            return reCount(num / 10);
        }
    }
}
