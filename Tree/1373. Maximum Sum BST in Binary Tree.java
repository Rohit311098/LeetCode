1. Brute Force- TC-O(N2)

class Solution {
    
    int result=0;
    public int getsum(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        
        return root.val+getsum(root.left)+getsum(root.right);
    }
    public boolean isbst(TreeNode root,long min,long max)
    {
        if(root==null)
        {
            return true;
        }
        
        if(root.val<=min || root.val>=max)
        {
            return false;
        }
        
        return (isbst(root.left,min,root.val) && isbst(root.right,root.val,max));
    }
    
    int maxresult=0;
    public int maxSumBST(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        
        if(isbst(root,Long.MIN_VALUE,Long.MAX_VALUE))
        {
            maxresult=Math.max(maxresult,getsum(root));
        }
        
        maxSumBST(root.left);
        maxSumBST(root.right);
        return maxresult;
    }
}


2. Optimised Value

