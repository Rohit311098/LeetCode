//Recursion Approach
 public int tribonacci(int n) {
        
        if(n==0 || n==1)
        {
            return n;
        }
        
        if(n==2)
        {
            return 1;
        }
        
        
        return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }


// Memoization Approach
class Solution {
    public int tribonacci(int n) {
        
        if(n==0 || n==1)
        {
            return n;
        }
        
        if(n==2)
        {
            return 1;
        }
        int[] dp=new int[n+1];
       Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        return helper(n,dp);
    }

    public int helper(int n,int[] dp)
    {
         if(n==0 || n==1)
        {            
             return n;
        }  
        if(n==2)
        {
            return 1;
        }
        
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        
        int total=helper(n-1,dp)+helper(n-2,dp)+helper(n-3,dp);
        dp[n]=total;
        
        return dp[n];
    }
}


//Iterative approach
class Solution {
    public int tribonacci(int n) {
        if(n==0 || n==1)
        {
            return n;
        }
        if(n==2)
        {
            return 1;
        }
        
        int first=0,second=1,third=1;
        
        for(int i=3;i<=n;i++)
        {
            int curr=first+second+third;
            first=second;
            second=third;
            third=curr;
        }
        
        return third;
        
    }
}
