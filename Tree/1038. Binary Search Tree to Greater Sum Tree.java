class Solution {
    
    int prevsum=0;
    public TreeNode bstToGst(TreeNode root) {
        
        if(root==null)
        {
            return null;
        }
        bstToGst(root.right);
        root.val+=prevsum;
        prevsum=root.val;
        bstToGst(root.left);
        return root;
    }

}
