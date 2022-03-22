class Solution {
    int max=0;
    public int longestZigZag(TreeNode root) {
        if(root==null)return 0;
        getlen(root.left,true,1);
        getlen(root.right,false,1);
        return max;
    }
    public void getlen(TreeNode root,boolean dir,int len)    
    {
        if(root==null)
            return;
        max=Math.max(max,len);
        int left=!dir?len+1:1;
        int right=dir?len+1:1;
        getlen(root.left,true,left);
        getlen(root.right,false,right);
    }
}
