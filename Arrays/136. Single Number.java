Brute Force: Using two loop

Approach 1: Using hashset

Approach 2: Using Bitwise operator
TC-O(N)  SC-O(1)
  
  class Solution {
    public int singleNumber(int[] nums) {

      int result=0;
      
      for(int i=0;i<nums.length;i++)
      {
        result^=nums[i];
      }

      return result;
        
    }
}
