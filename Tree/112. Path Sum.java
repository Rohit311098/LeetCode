1.Helper function use kiya hai isme

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root==null)
        {
            return false;
        }
        
        return helper(root,targetSum,0);
    }
    
    public boolean helper(TreeNode root,int targetSum,int currsum)
    {
        if(root==null)
        {
            return false;
        }
        
        currsum+=root.val;
        if(root.left==null && root.right==null)
        {
            if(currsum==targetSum)
            {
                return true;
            }   
            return false;
        }
        if(helper(root.left,targetSum,currsum) || helper(root.right,targetSum,currsum))
        {
            return true;
        }
        return false;
    }
}



2. Isme ek hi function se hua hai

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root==null)
        {
            return false;
        }
        
        if(root.left==null && root.right==null)
        {
            return (targetSum==root.val);
        }
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
        
    }
    
}

