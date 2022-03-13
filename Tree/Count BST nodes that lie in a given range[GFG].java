class Tree
{
    //Function to count number of nodes in BST that lie in the given range.
    public int count=0;
     public  void helper(Node root,int low,int high)
    {
        if(root==null)
        {
            return;
        }
        helper(root.left,low,high);
        if(root.data>=low && root.data<=high)
        {
            count++;
        }
        helper(root.right,low,high);
    }
    int getCount(Node root,int l, int h)
    {
        //Your code here
        helper(root,l,h);
        return count;
    }
