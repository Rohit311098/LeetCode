Below is the class where we handle duplicates also Insert and delete both code are present
  
public class BST
{
    class TreeNode
    {
        int val;
        Node left;
        Node right;
        int count;
        
        TreeNode(int val)
        {
            this.val=val;
            this.count=1;
            left=right=null;
        }
    }
    public static TreeNode insert(TreeNode root,int key)
    {
        if(root==null)
        {
            return new TreeNode(key);
        }
        
        if(root.val==key)
        {
            root.count++;
            return root;
        }
        
        if(root.val>key)
        {
            root.left=insert(root.left,key);
        }
        else
        {
            root.right=insert(root.right,key);
        }
        
        return root;
    }
    
    public static TreeNode getleftmax(TreeNode root)
    {
        while(root.right!=null)
        {
            root=root.right;
        }
        
        return root;
    }
    
    public static TreeNode delete(TreeNode root,int key)
    {
        if(root==null)
        {
            return null;
        }
        
        if(root.val>key)
        {
            root.left=delete(root.left,key);
        }
        else if(root.val<key)
        {
            root.right=delete(root.right,key);
        }
        else
        {
            //Checking if count is greater than 1 then simply decrease count and return same node
            if(root.count>1)
            {
                root.count--;
                return root;
            }
            
            //Now count is 1 hence we have to make same cases as we make in our normal bst
            //If leaf node
            if(root.left==null && root.right==null)
            {
                return null;
            }
            
            //1 child Node
            else if(root.left==null && root.right!=null)
            {
                return root.right;
            }
            else if(root.left!=null && root.right==null)
            {
                return root.left;
            }
            //Both child Node
            else
            {
                Node leftmax=getleftmax(root.left);
                root.val=leftmax.val;
                root.count=leftmax.count;
                root.left=delete(root.left,leftmax.val);
            }
        }
        
        return root;
    }

}
