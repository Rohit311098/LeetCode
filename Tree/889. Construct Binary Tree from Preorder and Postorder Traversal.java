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
    
    public int find(int val,int[] postorder)
    {
        for(int i=0;i<postorder.length;i++)
        {
            if(postorder[i]==val)
            {
                return i;
            }
        }
        return -1;
    }
    public TreeNode helper(int[] preorder,int[] postorder,int prel,int prer,int postl,int postr)
    {
        if(prel>prer)
        {
            return null;
        }
        
        //If only 1 node possible means leaf node
        if(prel==prer)
        {
            return new TreeNode(preorder[prel]);
        }
        
        TreeNode root=new TreeNode(preorder[prel]);
        
        //Agar hum last node per hai preorder k toh aage kuch nhi hoga 
        if(prel+1>=preorder.length) return root;
        
        
        int leftchild=preorder[prel+1];
        
        int postidx=find(leftchild,postorder);
        
        int noofnode=postidx-postl+1;
        root.left=helper(preorder,postorder,prel+1,prel+noofnode,postl,postidx);
        
        root.right=helper(preorder,postorder,prel+noofnode+1,prer,postidx+1,prer);
        
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder,postorder,0,preorder.length-1,0,postorder.length-1);
    }
}
