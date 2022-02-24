//Recursive Approach
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int target=cost.length;
        int zerostartidx=0;
        
        int cost1=helper(cost,zerostartidx,target);
        int onestartidx=1;
        int cost2=helper(cost,onestartidx,target);
        
        return Math.min(cost1,cost2);
    }
    
    public int helper(int[] cost,int idx,int target)
    {
        if(idx>target)
        {
            return Integer.MAX_VALUE;
        }
        if(idx==target)
        {
            return 0;
        }
        
        int cost1=helper(cost,idx+1,target);
        int cost2=helper(cost,idx+2,target);
        
        return cost[idx]+Math.min(cost1,cost2);
    }
}

//Memoization Approach

//Hum aage se minimum answer manga rahe hai and then apne aap ko add kar rahe hai
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int target=cost.length;
        int zerostartidx=0;
        
        int[] dp=new int[target];
        Arrays.fill(dp,-1);
       helper(cost,zerostartidx,target,dp);

        
        return Math.min(dp[0],dp[1]);
    }
    
    public int helper(int[] cost,int idx,int target,int[] dp)
    {
        if(idx>target)
        {
            return Integer.MAX_VALUE;
        }
        if(idx==target)
        {
            return 0;
        }
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        
        int cost1=helper(cost,idx+1,target,dp);
        int cost2=helper(cost,idx+2,target,dp);
        
        dp[idx]=cost[idx]+Math.min(cost1,cost2);
        return dp[idx];
    
    }
}

//Iterative Approach
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        dp[0]=cost[0];
        dp[1]=cost[1];
        
        for(int i=2;i<=n;i++)
        {
            if(i==n)
            {
                dp[i]=Math.min(dp[i-1],dp[i-2]);
            }
            else
            {
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
            }
        }
        
        return dp[n];
    }
  
}
