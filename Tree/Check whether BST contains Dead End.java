class GFG
{
    static boolean end;
    
    public static void helper(Node root,int left,int right)
    {
        if(root==null)
        {
            return;
        }
        
        if(left==right)
        {
            end=true;
            return;
        }
        
        helper(root.left,left,root.data-1);
        
        if(end==true)
        {
            return;
        }
        
        helper(root.right,root.data+1,right);
        
        if(end==true)
        {
            return;
        }
    }
    public static boolean isDeadEnd(Node root)
    {
        end=false;
        helper(root,1,Integer.MAX_VALUE);
        return end;
    }
}
