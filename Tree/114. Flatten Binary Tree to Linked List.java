1. Using Recursion  TC-O(N)  SC-O(N)( recursion stack )
  
  class Solution {
    public void flatten(TreeNode root) {
        
        if(root==null)
        {
            return;
        }
        
        flatten(root.left);
        flatten(root.right);
        
        while(root.left!=null)
        {
            //Root k right ko store kar lo
            TreeNode rootkaright=root.right;
            
            //root k right ko root ka left bana do
            root.right=root.left;
            
            root.left=null;
            //wahi root ka left wala traverse karte raho vo jo abhi root ka right ban chuka hai
            while(root.right!=null)
            {
                root=root.right;
            }
            root.right=rootkaright;
            
        }
    }
}



2. Using Explicit Stack





3. Using Morris traversal -> TC-O(N)   SC-O(1)
  class Solution {
    public void flatten(TreeNode root) {
        
        if(root==null)
        {
            return;
        }
        
        TreeNode curr=root;
        
        while(curr!=null)
        {
            if(curr.left!=null)
            {
                TreeNode rootkleftkaright=curr.left;
                
                while(rootkleftkaright.right!=null)
                {
                    rootkleftkaright=rootkleftkaright.right;
                }
                
                rootkleftkaright.right=curr.right;
                
                curr.right=curr.left;
                curr.left=null;
            }
            
            curr=curr.right;
        }
        
        
    }
}
  


