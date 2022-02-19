1.Using DFS technique
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
    
    int parentx=-1,parenty=-1,levelx=0,levely=0;
    public void DFS(TreeNode root,int x,int y,int level,int parent)
    {
        if(root==null)
        {
            return;
        }
        if(root.val==x)
        {
            levelx=level;
            parentx=parent;
        }
        if(root.val==y)
        {
            levely=level;
            parenty=parent;
        }
        DFS(root.left,x,y,level+1,root.val);
        DFS(root.right,x,y,level+1,root.val);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(x==y)
        {
            return false;
        }
        DFS(root,x,y,0,-1);
        
        if(levelx!=levely)
        {
            return false;
        }
        
        if(parentx==parenty)
        {
            return false;
        }
        
        return true;
    }
}


2.Using BFS Approach
