1. Brute force - TC-O(N2)
  
  Below is optimised code TC-O(N) SC-O(N) using prefix sum technique

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> h=new HashMap<>();
        
        int[] prefix=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            prefix[i]=prefix[i-1]+nums[i];
        }
        
        h.put(0,1);
        
        int count=0;
        for(int i=0;i<prefix.length;i++)
        {
            int sum=prefix[i]-k;
            
            if(h.containsKey(sum)==true)
            {
                count+=h.get(sum);
            }
            h.put(prefix[i],h.getOrDefault(prefix[i],0)+1);
        }
        
        return count;
    }
}
