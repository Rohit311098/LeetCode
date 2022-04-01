class Tree
{
    //Function to count number of nodes in BST that lie in the given range.
    public int count=0;
    int getCount(Node root,int l, int h)
    {
        if(root==null)
        {
            return 0;
        }
        
        if(root.data>=l)
         getCount(root.left,l,h);
        if(root.data>=l && root.data<=h)
        {
            count++;
        }
        
        if(root.data<=h)
            getCount(root.right,l,h);
        
        return count;
    }
}
