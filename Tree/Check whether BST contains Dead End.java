class GFG
{
    static boolean end;
    
    public static boolean helper(Node root,int left,int right)
    {
        if(root==null)
        {
            return false;
        }
        
        if(left==right)
        {
           return true;
        }
        return helper(root.left,left,root.data-1) || helper(root.right,root.data+1,right);
    }
    public static boolean isDeadEnd(Node root)
    {
        return helper(root,1,Integer.MAX_VALUE);
    }
}
