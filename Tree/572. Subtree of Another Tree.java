 TC-O(N2) SC-O(1)
 class Solution {
    
    public boolean helper(TreeNode root, TreeNode subRoot)
    {
        if(root==null && subRoot==null)
        {
            return true;
        }
        
        if(root==null || subRoot==null)
        {
            return false;
        }
        if(root.val!=subRoot.val)
        {
            return false;
        }
        return helper(root.left,subRoot.left) && helper(root.right,subRoot.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null)
        {
            return true;
        }
        if(root==null || subRoot==null)
        {
            return false;
        }
        return helper(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}
