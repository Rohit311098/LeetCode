1. Recursive Approach
class Solution {
    public int rob(int[] nums) {
        
        if(nums.length==1)
        {
            return nums[0];
        }
        
        int idx=0;
        return helper(nums,idx);
    }
    
    public int helper(int[] nums,int idx)
    {
        if(idx>=nums.length)
        {
            return 0;
        }
        
        int taken=nums[idx]+helper(nums,idx+2);
        
        int nottaken=helper(nums,idx+1);
        
        return Math.max(taken,nottaken);
    }
}

2. Memoization

class Solution {
    public int rob(int[] nums) {
        
        if(nums.length==1)
        {
            return nums[0];
        }
        
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int idx=0;
        return helper(nums,idx,dp);
    }
    
    public int helper(int[] nums,int idx,int[] dp)
    {
        if(idx>=nums.length)
        {
            return 0;
        }
        
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        int taken=nums[idx]+helper(nums,idx+2,dp);
        int nottaken=helper(nums,idx+1,dp);
        
        dp[idx]=Math.max(taken,nottaken);
        
        return dp[idx];
    }
}

3. Iterative Approach
class Solution {
    public int rob(int[] nums) {
        
        if(nums.length==1)
        {
            return nums[0];
        }
        
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int taken=nums[i]+(i-2>=0?dp[i-2]:0);
            
            int notaken=dp[i-1];
            
            dp[i]=Math.max(taken,notaken);
        }
        
        return dp[nums.length-1];
    }
    
}
