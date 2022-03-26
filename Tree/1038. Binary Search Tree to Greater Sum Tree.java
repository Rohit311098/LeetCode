class Solution {
    
    int prevsum;
    public TreeNode bstToGst(TreeNode root) {
        
        if(root==null)
        {
            return null;
        }
        
        prevsum=0;
        return reverseinorder(root);
    }
    public TreeNode reverseinorder(TreeNode root)
    {
        if(root==null)
        {
            return null;
        }
        
        root.right=reverseinorder(root.right);
        root.val+=prevsum;
        prevsum=root.val;
        root.left=reverseinorder(root.left);
        
        return root;
    }

}
