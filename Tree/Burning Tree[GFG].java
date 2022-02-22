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
    static int time=0;
     public  static int dfs(Node root,int target)
    {
        if(root==null)
        {
            return -1;
        }
        if(root.data==target)
        {
            //-1 esliye return kiya hai because height in terms of nodes hai but haime in terms of edges chahiye from current node
            time=Math.max(time,height(root,null)-1);
            return 1;
        }
        
        int left=dfs(root.left,target);
        if(left>0)
        {
            //-1 esliye return kiya hai because height in terms of nodes hai but haime in terms of edges chahiye from current node
            time=Math.max(time,left+height(root,root.left)-1);
            return 1+left;
        }
        
        int right=dfs(root.right,target);
        if(right>0)
        {
            //-1 esliye return kiya hai because height in terms of nodes hai but haime in terms of edges chahiye from current node
            time=Math.max(time,right+height(root,root.right)-1);
            return 1+right;
        }
        return -1;
    }
    public static int height(Node root,Node blocker)
     {
         if(root==null || root==blocker)
         {
             return 0;
         }
         return 1+Math.max(height(root.left,blocker),height(root.right,blocker));
     }
    public static int minTime(Node root, int target) 
    {
       time=0;
       
       dfs(root,target);
       return time;
    }
}
