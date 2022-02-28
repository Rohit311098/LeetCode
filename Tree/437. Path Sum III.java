1. Approach 1 - TC- n* DFS=O(N2) SC-O(1)
 Is Approach mai hum har node ko as a root node treat karege and then uske possible path calculate karege and ek global variable mai store kar lege
  class Solution {
    
    int noofpath=0;
    public int pathSum(TreeNode root, int targetSum) {
        noofpath=0;
        helper(root,targetSum);
        return noofpath;
    }
    
    public void helper(TreeNode root,int target)
    {
        if(root==null)
        {
            return;
        }
        
        //Calling second helper which calculate path possible is we take current node as starting node or root node
        helper2(root,0,target);
        
        //Checking path possible by making left and right child as root node
        helper(root.left,target);
        helper(root.right,target);
    }
    public void helper2(TreeNode root,int currsum,int target)
    {
        if(root==null)
        {
            return;
        }
        
        currsum+=root.val;
        if(currsum==target)
        {
            noofpath++;
        }
        
        helper2(root.left,currsum,target);
        helper2(root.right,currsum,target);
    }
}



2. Approach 2 Optimised
Using HashMap and Prefix sum wala technique TC-O(N) SC-O(N) because of HashMap
class Solution {
    HashMap<Integer,Integer> freq;
    
    public int getcount(TreeNode root,int target,int prefixsum)
    {
        if(root==null)
        {
            return 0;
        }
        
        prefixsum+=root.val;
        
        int count=freq.getOrDefault(prefixsum-target,0);
        
        freq.put(prefixsum,freq.getOrDefault(prefixsum,0)+1);
        
        count+=getcount(root.left,target,prefixsum);
        count+=getcount(root.right,target,prefixsum);
        
        //Backtracking and decreasing value of prefixsum
        freq.put(prefixsum,freq.getOrDefault(prefixsum,0)-1);
        
        return count;
    }
    public int pathSum(TreeNode root, int targetSum) {
        
        if(root==null)
        {
            return 0;
        }
        
        freq=new HashMap<>();
        
        freq.put(0,1);
        
        return getcount(root,targetSum,0);
    }
}
 
 
