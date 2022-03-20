class Solution {
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        
        if(root==null)
        {
            return true;
        }
        
        boolean left =isValidBST(root.left);
        
        if(left==false)
        {
            return false;
        }
        if(prev==null)
        {
            prev=root;
        }
        else if(prev!=null && prev.val>=root.val)
        {
            return false;
        }
        
        prev=root;
        return isValidBST(root.right);
    }
}
