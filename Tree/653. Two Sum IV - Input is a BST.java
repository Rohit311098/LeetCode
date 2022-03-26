1. Brute Force- TC-O(N2)   SC-O(1)
  
  class Solution {
    public boolean findTarget(TreeNode root, int k) {
        
        return dfs(root,root,k);
    }
    
    public boolean dfs(TreeNode root,TreeNode mainroot,int k)
    {
       if(root==null)
       {
           return false;
       }
        
      if(k-root.val!=root.val && search(mainroot,k-root.val))
      {
          return true;
      }
        
        return dfs(root.left,mainroot,k) || dfs(root.left,mainroot,k);
    }
    
    
    public boolean search(TreeNode root,int k)
    {
        if(root==null)
        {
            return false;
        }
        
        if(root.val==k)
        {
            return true;
        }
        
        if(root.val>k)
            return search(root.left,k);
            
        return search(root.right,k);
    }
}


2. Optimised Approach - TC-O(N)  SC-O(N)
  class Solution {
    HashSet<Integer> hm=new HashSet<>();;
    public boolean findTarget(TreeNode root, int k) {
        
        if(root==null)
        {
            return false;
        }
        
        if(hm.contains(k-root.val))
        {
            return true;
        }
        
        hm.add(root.val);
        
    return findTarget(root.left,k) || findTarget(root.right,k);
    }
}
