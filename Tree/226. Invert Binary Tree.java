class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if(root==null)
        {
            return null;
        }
        
        TreeNode rootkaleft=invertTree(root.left);
        TreeNode rootkaright=invertTree(root.right);
        TreeNode temp=rootkaright;
        root.right=rootkaleft;
        root.left=temp;
        
        return root;
    }
}
