/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public void DFS(TreeNode root,int level,ArrayList<Integer> arr)
    {
        if(root==null)
        {
            return;
        }
        
        if(arr.size()>level)
        {
            int curr=arr.get(level);
            arr.set(level,curr+root.val);
        }
        else
        {
            arr.add(root.val);
        }
        
        DFS(root.left,level+1,arr);
        DFS(root.right,level+1,arr);
    }
    public int maxLevelSum(TreeNode root) {
        
        ArrayList<Integer> arr=new ArrayList<>();
        if(root==null)
        {
            return 0;
        }
        
        arr.add(0);
        DFS(root,1,arr);
        
        int result=1;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<arr.size();i++)
        {
            if(max<arr.get(i))
            {
                max=arr.get(i);
                result=i;
            }
        }
        return result;
    }
}
