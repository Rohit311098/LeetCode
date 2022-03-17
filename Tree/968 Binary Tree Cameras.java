class Solution {
    
    int camera;
    public int helper(TreeNode root)
    {
        
        if(root==null)
        {
            return 1;
        }
        
        int left=helper(root.left);
        int right=helper(root.right);
        
        if(left==-1 || right==-1)
        {
            camera++;
            return 0;
        }
        
        if(left==0 || right==0)
        {
            return 1;
        }
        return -1;
    }
    public int minCameraCover(TreeNode root) {
        
        if(root==null)
        {
            return 1;
        }
        
        camera=0;
        if(helper(root)==-1)
            camera++;
        return camera;
    }
}
