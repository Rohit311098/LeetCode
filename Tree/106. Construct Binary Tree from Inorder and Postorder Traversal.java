class Solution {
    
    public TreeNode construct(int[] postorder, HashMap<Integer,Integer> inhm,int inol,int inor,int postidx)
    {
        if(inol>inor)
        {
            return null;
        }
        
        TreeNode root=new TreeNode(postorder[postidx]);
        
        int inoidx=inhm.get(postorder[postidx]);
        
        int noofele=inor-inoidx;
        
        root.left=construct(postorder,inhm,inol,inoidx-1,postidx-noofele-1);
        
        root.right=construct(postorder,inhm,inoidx+1,inor,postidx-1);
        
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        HashMap<Integer,Integer> inhm=new HashMap<>();
        
        for(int i=0;i<inorder.length;i++)
        {
            inhm.put(inorder[i],i);
        }
        
        return construct(postorder,inhm,0,inorder.length-1,postorder.length-1);
    }
}
