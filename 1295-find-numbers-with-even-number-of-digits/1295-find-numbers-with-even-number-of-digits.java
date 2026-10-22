class Solution {
    public int findNumbers(int[] nums) {
        
        int count =0;
        for(int num:nums){
            if(even(num)){
                count++;
            }
        }
        return count;
    }
    boolean even(int num){
        int numberofDigits = digits(num);
        return numberofDigits % 2 == 0;
    }

        int digits(int num){
            if(num == 0){
                return 1;
            }
            int count = 0;
            while(num>0){
                count++;
                num =num / 10;
            }
            return count;
        }
    }
