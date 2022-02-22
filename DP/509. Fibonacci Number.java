//Recursion Approach
class Solution {
    public int fib(int n) {
        if(n==0 || n==1)
        {
            return n;
        }
        
        return fib(n-1)+fib(n-2);
        
    }
}

//Memoization Approach
class Solution {
    public int fib(int n) {
        if(n==0 || n==1)
        {
            return n;
        }
        
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        
        return helper(n,dp);
    }
    
    public int helper(int n,int[] dp) {
        if(n==0 || n==1)
        {
            return n;
        }
        
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        
        
        int total=fib(n-1)+fib(n-2);
        
        dp[n]=total;
        
        return dp[n];
        
    }
    
}


//Iterative Approach

class Solution {
    public int fib(int n) {
        if(n==0 || n==1)
        {
            return n;
        }
        
        int first=0,second=1;
        
        for(int i=2;i<=n;i++)
        {
            int curr=first+second;
            first=second;
            second=curr;
        }
        
        return second;
    }
  
    
}
