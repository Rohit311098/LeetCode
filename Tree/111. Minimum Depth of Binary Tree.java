class Solution {
    public int minDepth(TreeNode root) {
        
        if(root==null) return 0;
        if(root.left==null && root.right==null)
        {
            return 1;
        }
        
        if(root.left==null)
        {
            return 1+minDepth(root.right);
        }
        
        
        if(root.right==null)
        {
            return 1+minDepth(root.left);
        }
        
        int leftans=minDepth(root.left);
        
        int rightans=minDepth(root.right);
        
        return 1+Math.min(leftans,rightans);
    }
}
