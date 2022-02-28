1. Approach 1 - TC- n* DFS=O(N2) SC-O(1)
 Is Approach mai hum har node ko as a root node treat karege and then uske possible path calculate karege and ek global variable mai store kar lege
  class Solution {
    
    int noofpath=0;
    public int pathSum(TreeNode root, int targetSum) {
        noofpath=0;
        helper(root,targetSum);
        return noofpath;
    }
    
    public void helper(TreeNode root,int target)
    {
        if(root==null)
        {
            return;
        }
        
        //Calling second helper which calculate path possible is we take current node as starting node or root node
        helper2(root,0,target);
        
        //Checking path possible by making left and right child as root node
        helper(root.left,target);
        helper(root.right,target);
    }
    public void helper2(TreeNode root,int currsum,int target)
    {
        if(root==null)
        {
            return;
        }
        
        currsum+=root.val;
        if(currsum==target)
        {
            noofpath++;
        }
        
        helper2(root.left,currsum,target);
        helper2(root.right,currsum,target);
    }
}
