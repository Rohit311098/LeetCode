class Solution {
    public class Pair
    {
        int with=0;
        int without=0;
    }
    public Pair getans(TreeNode root)
    {
        if(root==null)
        {
            return new Pair();
        }
        Pair left=getans(root.left);    
        Pair right=getans(root.right);
    
        Pair curr=new Pair();
        curr.with=root.val+left.without+right.without;
        curr.without=Math.max(left.with,left.without)+ Math.max(right.with,right.without);
        return curr;
    }
    public int rob(TreeNode root) {
        
        Pair result=getans(root);
        
        return Math.max(result.with,result.without);
    }
}
