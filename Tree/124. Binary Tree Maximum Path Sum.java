class Solution {
    
    public static int maxpathsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxpathsum=Integer.MIN_VALUE;
        if(root==null)
        {
            return 0;
        }
        int ans=helper(root);
        return maxpathsum;
    }
    
    public static int helper(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int leftsum=helper(root.left);
        
        int rightsum=helper(root.right);
        
        int currsum=root.val+Math.max(0,leftsum)+Math.max(0,rightsum);
        maxpathsum=Math.max(maxpathsum,currsum);
        
        return Math.max(0,Math.max(leftsum,rightsum))+root.val;
        
    }
}
