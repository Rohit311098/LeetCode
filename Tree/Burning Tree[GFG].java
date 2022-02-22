class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    static int maxtime=0;
     public  static int dfs(Node root,int target)
    {
        if(root==null)
        {
            return -1;
        }
        if(root.data==target)
        {
            kleveldown(root,null,0);
            return 1;
        }
        
        int left=dfs(root.left,target);
        if(left>0)
        {
            kleveldown(root,root.left,left);
            return 1+left;
        }
        
        int right=dfs(root.right,target);
        if(right>0)
        {
            kleveldown(root,root.right,right);
            return 1+right;
        }
        return -1;
    }
    public static void kleveldown(Node root,Node blocker,int k)
     {
         if(root==null || root==blocker)
         {
             return ;
         }
         
         if(k>maxtime)
         {
             maxtime=k;
         }
         kleveldown(root.left,blocker,k+1);
         kleveldown(root.right,blocker,k+1);
     }
    public static int minTime(Node root, int target) 
    {
       maxtime=0;
       
       dfs(root,target);
       return maxtime;
    }
}
