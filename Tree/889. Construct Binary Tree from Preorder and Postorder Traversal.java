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
    HashMap<Integer,Integer> hm;
    
    public TreeNode construct(int[] preorder,HashMap<Integer,Integer> hm,int prel,int prer,int postl,int postr)
    {
        if(prel>prer)
        {
            return null;
        }
        
        TreeNode root=new TreeNode(preorder[prel]);
        if(prel==prer)
        {
            return root;
        }
        
        
        if(prel+1==preorder.length)
        {
            return root;
        }
        
        int postidx=hm.get(preorder[prel+1]);
        
        int noofele=postidx-postl+1;
        root.left=construct(preorder,hm,prel+1,prel+noofele,postl,postidx);
        root.right=construct(preorder,hm,prel+noofele+1,prer,postidx+1,postr);
        
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        hm=new HashMap<>();
        
        for(int i=0;i<postorder.length;i++)
        {
            hm.put(postorder[i],i);
        }
        
        return construct(preorder,hm,0,preorder.length-1,0,postorder.length-1);
    }
}
