class Solution {
    public int minDepth(TreeNode root) {
        
        if(root==null) return 0;
        int ans=helper(root);
        return ans;
    }
    
    public int helper(TreeNode root)
    {
        if(root==null) return Integer.MAX_VALUE;
        
        if(root.left==null && root.right==null) return 1;
        int left=helper(root.left);
        
        int right=helper(root.right);
        
        return 1+Math.min(left,right);
    }
}
