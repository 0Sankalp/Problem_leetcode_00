class Solution {
    public int singleNumber(int[] nums) {
      int ses = 0;
        for (int num: nums){
            ses=ses^num;
        }
        return ses;



    }
}