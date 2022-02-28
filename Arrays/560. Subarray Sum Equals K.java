1. Brute force - TC-O(N2)
  
  Below is optimised code TC-O(N) SC-O(N) using prefix sum technique

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> h=new HashMap<>();
        h.put(0,1);
        
        int prefixsum=0;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            prefixsum+=nums[i];
            if(h.containsKey(prefixsum-k)==true)
            {
                count+=h.get(prefixsum-k);
            }
            h.put(prefixsum,h.getOrDefault(prefixsum,0)+1);
        }
        
        return count;
    }
}
