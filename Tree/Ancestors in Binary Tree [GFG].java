class Solution
{
    public static boolean findancestor(Node root,ArrayList<Integer> path,int target)
    {
        if(root==null) return false;
        
       if(root.data==target)
       {
           return true;
       }
        boolean left=findancestor(root.left,path,target);
        if(left==true)
        {
            path.add(root.data);
            return true;
        }
        boolean right=findancestor(root.right,path,target);
        if(right==true)
        {
            path.add(root.data);
            return true;
        }
        return false;
    }
    
    public static ArrayList<Integer> Ancestors(Node root, int target)
    {
        ArrayList<Integer> ancestor=new ArrayList<Integer>();
        findancestor(root,ancestor,target);
        return ancestor;
    }
}
