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
    static int mintime=0;
     public  static int dfs(Node root,int target)
    {
        if(root==null)
        {
            return -1;
        }
        if(root.data==target)
        {
            height(root,null,0);
            return 1;
        }
        
        int left=dfs(root.left,target);
        if(left>0)
        {
           height(root,root.left,left);
            return 1+left;
        }
        
        int right=dfs(root.right,target);
        if(right>0)
        {
            height(root,root.right,right);
            return 1+right;
        }
        return -1;
    }
    public static int height(Node root,Node blocker,int time)
     {
         if(root==null || root==blocker)
         {
             return 0;
         }
         mintime=Math.max(mintime,time);
         return 1+Math.max(height(root.left,blocker,time+1),height(root.right,blocker,time+1));
     }
    public static int minTime(Node root, int target) 
    {
       mintime=0;
       dfs(root,target);
       return mintime;
    }
}
