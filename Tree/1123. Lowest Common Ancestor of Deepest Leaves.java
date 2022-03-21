class Solution {
    
    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        
        int left=height(root.left);
        int right=height(root.right);
        
        return 1+Math.max(left,right);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        
        int maxheight=height(root);
        
        return dfs(root,1,maxheight);
    }
    
    public TreeNode dfs(TreeNode root,int currheight,int maxheight)
    {
        if(root==null)
        {
            return null;
        }
        
        if(currheight==maxheight)
        {
            return root;
        }
        
        TreeNode left=dfs(root.left,currheight+1,maxheight);
        
        
        TreeNode right=dfs(root.right,currheight+1,maxheight);
        
        if(left!=null && right!=null)
        {
            return root;
        }
        
        return (left==null) ? right:left;
    }
}
