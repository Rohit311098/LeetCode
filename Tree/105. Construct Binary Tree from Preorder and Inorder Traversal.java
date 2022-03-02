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
    
    public int find(int[] inorder,int val)
    {
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==val)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public TreeNode construct(int[] preorder,int[] inorder,int preidx,int inol,int inor)
    {
        if(inol>inor)
        {
            return null;
        }
        
        TreeNode root=new TreeNode(preorder[preidx]);
        int getindex=find(inorder,preorder[preidx]);
        int noofele=getindex-inol;
        
        root.left=construct(preorder,inorder,preidx+1,inol,getindex-1);
        
        root.right=construct(preorder,inorder,preidx+1+noofele,getindex+1,inor);
        
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length==1)
        {
            return new TreeNode(preorder[0]);
        }
        
        return construct(preorder,inorder,0,0,inorder.length-1);
    }
}
