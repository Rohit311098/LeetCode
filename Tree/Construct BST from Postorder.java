class GFG
{
    static int idx=0;
    
    public static Node helper(int post[],int lr,int rr)
    {
        if(idx<0 || post[idx]<lr || post[idx]>rr)
        {
            return null;
        }
        
        Node root=new Node(post[idx--]);
        
        root.right=helper(post,root.data,rr);
        
        root.left=helper(post,lr,root.data);
        
        return root;
    }
    public static Node constructTree(int post[],int n)
    {
       idx=n-1;   
     return helper(post,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}
