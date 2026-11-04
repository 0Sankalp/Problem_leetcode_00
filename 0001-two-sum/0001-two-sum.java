
class Solution {
    public int[] twoSum(int[] nums, int target) {
/*
        // Brute force solution
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
        */

        //Optimal hasshing Solution

        Map<Integer,Integer>map=new HashMap<>();
        //[2,7,11,15]
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i],i);
        }
        //[2:0,7:1,11:2,15:3]
        for(int i = 0; i<nums.length; i++){
            int lookupNumber = target - nums[i];

            if(map.containsKey(lookupNumber)&& 
            map.get(lookupNumber) != i){
                return new int []{ map.get(lookupNumber),i };
            }
        }
        return new int [] {-1,1};
    }
}
