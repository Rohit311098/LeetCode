class Solution {
    
    int idx=0;
    public TreeNode preorderhelper(int[] preorder,int lr,int rr)
    {
        if(idx>=preorder.length || preorder[idx]<lr || preorder[idx]>rr)
        {
            return null;
        }
        
        TreeNode root=new TreeNode(preorder[idx++]);
        
        root.left=preorderhelper(preorder,lr,root.val);
        
        root.right=preorderhelper(preorder,root.val,rr);
        
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        
        
        return preorderhelper(preorder,1,1000);
        
    }
}
