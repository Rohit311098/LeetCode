1. Using Inorder traversal and taking help of two nodes first and second;

TC-O(N)    SC-O(logn)-> Recursion stack space

class Solution {
    TreeNode first=null;
    TreeNode second=null;
    TreeNode prev=new TreeNode(Integer.MIN_VALUE);
    public void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        
        inorder(root.left);
        if(first==null && prev.val>root.val)
        {
            first=prev;
        }
        
        
        if(first!=null && prev.val>root.val)
        {
            second=root;
        }
        
        //Update 
        prev=root;
        
        inorder(root.right);
        
    }
    public void recoverTree(TreeNode root) {
        if(root==null)
        {
            return;
        }
        inorder(root);
        
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
        
    }
}

2. Using Morris Traversal - TC-O(N)   SC-O(1)

class Solution {
    
    public TreeNode getrightmost(TreeNode node,TreeNode root)
    {
        while(node.right!=null && node.right!=root)
        {
            node=node.right;
        }
        
        return node;
    }
    public void recoverTree(TreeNode root) {
         TreeNode first=null;
        TreeNode second=null;
        TreeNode prev=null;
        while(root!=null)
        {
            if(root.left!=null)
            {
                TreeNode rootkleftkaright=getrightmost(root.left,root);
                if(rootkleftkaright.right==root)
                {
                    rootkleftkaright.right=null;
                     if(prev!=null && prev.val>root.val)
                    {
                        if(first==null)
                        {
                            first=prev;
                        }
                        second=root;
                    }
                    
                    prev=root;
                    root=root.right;
                }
                else
                {
                    rootkleftkaright.right=root;
                    root=root.left;
                }
            }
            else
            {
                if(prev!=null && prev.val>root.val)
                {
                    if(first==null)
                    {
                        first=prev;
                    }
                    second=root;
                }
                prev=root;
                root=root.right;
            }
        }
        
        int temp=first.val;
        
        first.val=second.val;
        second.val=temp;
        
        
    }
}
