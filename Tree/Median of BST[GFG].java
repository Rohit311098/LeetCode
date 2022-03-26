class Tree
{
    static ArrayList<Integer> result;
    public static float findMedian(Node root)
    {
       result=new ArrayList<>();
       
       dfs(root);
       
       int len=result.size();
       
       if(len%2==1)
       {
           return (float)result.get(len/2);
       }
       
       return (float)(result.get(len/2-1)+result.get(len/2))/2;
    }
    
    public static void dfs(Node root)
    {
        if(root==null)
        {
            return;
        }
        dfs(root.left);
        result.add(root.data);
        dfs(root.right);
    }
}
