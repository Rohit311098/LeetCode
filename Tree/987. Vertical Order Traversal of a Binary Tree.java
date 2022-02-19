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
    
    TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> vertical;
    public void DFS(TreeNode root,int row,int col)
    {
        if(root==null)
        {
            return;
        }
        
        if(vertical.containsKey(col)==false)
        {
            vertical.put(col,new TreeMap<>());
        }
        
        if(vertical.get(col).containsKey(row)==false)
        {
            vertical.get(col).put(row,new ArrayList<>());
        }
        
        vertical.get(col).get(row).add(root.val);
        
        DFS(root.left,row+1,col-1);
        DFS(root.right,row+1,col+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        vertical=new TreeMap<>();
        
        List<List<Integer>> result=new ArrayList<>();
        
        //0 and 0 are rows and col
        DFS(root,0,0);
        
        for(Integer cols:vertical.keySet())
        {
            TreeMap<Integer,ArrayList<Integer>> allrows=vertical.get(cols);
            
            List<Integer> oned=new ArrayList<>();
            
            for(Integer row:allrows.keySet())
            {
                ArrayList<Integer> arr=allrows.get(row);
                Collections.sort(arr);
                for(Integer i:arr)
                {
                    oned.add(i);
                }
            }
            result.add(oned);
        }
        return result;
    }
}
