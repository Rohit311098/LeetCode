/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int leftdepth(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        return 1+leftdepth(root.left);
    }
    
    public int rightdepth(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        return 1+rightdepth(root.right);
    }
    
    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        return 1+Math.max(height(root.right),height(root.left));
    }
    public int countNodes(TreeNode root) {
        
        if(root==null)
        {
            return 0;
        }
        
        int ld=leftdepth(root);
        
        int rd=rightdepth(root);
        
        if(ld==rd)
        {
            int getheight=height(root);
            return (int)(Math.pow(2,getheight))-1;
        }
        
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
