1 With Extra space for storing root to node path
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public  ArrayList<TreeNode> getpath(TreeNode root,TreeNode target)
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        if(root.val==target.val)
        {
            ArrayList<TreeNode> arr=new ArrayList<>();
            arr.add(root);
            return arr;
        }
        
        ArrayList<TreeNode> leftside=getpath(root.left,target);
        if(leftside.size()!=0)
        {
            leftside.add(0,root);
            return leftside;
        }
        
        ArrayList<TreeNode> rightside=getpath(root.right,target);
        if(rightside.size()!=0)
        {
            rightside.add(0,root);
            return rightside;
        }
        
        
        return new ArrayList<>();
    }
    public void kleveldown(TreeNode root,TreeNode blocker,int k,List<Integer> result)
     {
         if(k<0 || root==null || root==blocker)
         {
             return ;
         }
         if(k==0)
         {
             result.add(root.val);
             return;
         }
         kleveldown(root.left,blocker,k-1,result);
         kleveldown(root.right,blocker,k-1,result);
     }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        if(root==null)
        {
            return null;
        }
        
        List<Integer> result=new ArrayList<>();
        ArrayList<TreeNode> root2node=new ArrayList<>();
        
        root2node=getpath(root,target);
        
        //System.out.println(root2node);
        //null esliye add kiya hai taki last wale element k liye blocker null ho
        root2node.add(null);
        
        int n=root2node.size();
        for(int i=n-2;i>=0;i--)
        {
            TreeNode curr=root2node.get(i);
            
            TreeNode blocker=root2node.get(i+1);
            
            kleveldown(curr,blocker,k,result);
            k--;
        }
        
        return result;
    }
}


2. Without extra space of storing root to node path
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public  int dfs(TreeNode root,TreeNode target,int k,List<Integer> result)
    {
        if(root==null)
        {
            return -1;
        }
        if(root.val==target.val)
        {
            kleveldown(root,null,k,result);
            return 1;
        }
        
        int left=dfs(root.left,target,k,result);
        
        if(left>0)
        {
            kleveldown(root,root.left,k-left,result);
            return 1+left;
        }
        
        int right=dfs(root.right,target,k,result);
        
        if(right>0)
        {
            kleveldown(root,root.right,k-right,result);
            return 1+right;
        }
        return -1;
    }
    public void kleveldown(TreeNode root,TreeNode blocker,int k,List<Integer> result)
     {
         if(k<0 || root==null || root==blocker)
         {
             return ;
         }
         if(k==0)
         {
             result.add(root.val);
             return;
         }
         kleveldown(root.left,blocker,k-1,result);
         kleveldown(root.right,blocker,k-1,result);
     }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) { 
        if(root==null)
        {
            return null;
        }
        List<Integer> result=new ArrayList<>();
        dfs(root,target,k,result);
        return result;
    }
}
