class Solution
{
    int globalmaxsum=Integer.MIN_VALUE;
    
    int getsum(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        
        //If current node is leaf node then return its value
        if(root.left==null && root.right==null)
        {
            return root.data;
        }
        
        if(root.left==null)
        {
            return root.data+getsum(root.right);
        }
        
        if(root.right==null)
        {
            return root.data+getsum(root.left);
        }
        int leftsum=getsum(root.left);
        int rightsum=getsum(root.right);
        int currentsum=root.data+leftsum+rightsum;
        if(currentsum>globalmaxsum)
        {
            globalmaxsum=currentsum;
        }
        return root.data+Math.max(leftsum,rightsum);
    }
    int maxPathSum(Node root)
    { 
        //If tree is empty
        if(root==null)
        {
            return 0;
        }
        
        //If root is only node in tree
        
        if(root.left==null && root.right==null)
        {
            return root.data;
        }
        globalmaxsum=Integer.MIN_VALUE;
        
        int sum=getsum(root);
        
        //If root is one of the leaf node
        if(root.left==null || root.right==null)
        {
            globalmaxsum=Math.max(globalmaxsum,sum);
        }
        
        return globalmaxsum;
    } 
}
