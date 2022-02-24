//Recursive Approach
class Solution {
    public int climbStairs(int n) {
        if(n<0)
        {
            return 0;
        }
        
        if(n==0)
        {
            return 1;
        }
        
        int stair1=climbStairs(n-1);
        
        int stair2=climbStairs(n-2);
        
        return stair1+stair2;
    }
}

//Memoization Approach
class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        
        return helper(n,dp);
    }
    
    public int helper(int n,int[] dp)
    {
        if(n<0)
        {
            return 0;
        }
        
        if(n==0)
        {
            return 1;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        int stair1=helper(n-1,dp);
        int stair2=helper(n-2,dp);
        dp[n]=stair1+stair2;
        return dp[n];
    }
}

//Optimised Approach or Iterative Approach
class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        
        return dp[n];
    }
    

}

