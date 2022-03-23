class Solution {
    
    public int getmax(TreeNode root)
    {
        if(root.right==null)
        {
            return root.val;
        }
        
        return getmax(root.right);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
        {
            return null;
        }
        if(root.val>key)
        {
            root.left=deleteNode(root.left,key);
        }
        else if(root.val<key)
        {
            root.right=deleteNode(root.right,key); 
        }
        else
        {
            //If jo node delete karni hai vo leaf node hai
            if(root.left==null && root.right==null)
            {
                return null;
            }
            else if(root.left!=null && root.right==null)
            {
                //SSingle child node
                return root.left;
            }
            else if(root.left==null && root.right!=null)
            {
                //single child node
                return root.right;
            }
            else
            {
                // Both child exist
                int maxleft=getmax(root.left);
                root.val=maxleft;
                root.left=deleteNode(root.left,maxleft);
            }
            
        }
        
        return root;
        
    }
}
