1. My Approach Basic Approach
class Solution {
    public int[] getbinary(int n)
    {
        int[] binaryNum = new int[1000];
        int i = 0;
        while (n > 0) 
        {
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }
        return binaryNum;
    }
    public int[] countBits(int n) {
        int[] result=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            int[] binarynum=getbinary(i);
            int count=0;
            for(int j=0;j<binarynum.length;j++)
            {
                if(binarynum[j]==1)
                {
                    count++;
                }
            }
            result[i]=count;
        }
        return result;
    }
}


2. Optimised Approach
class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> res(n+1, 0);
        for (int i = 1; i <= n; ++i) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
};
