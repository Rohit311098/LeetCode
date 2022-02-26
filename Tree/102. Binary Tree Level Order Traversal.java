 1. BFS Approach
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
    public List<List<Integer>> levelOrder(TreeNode root) {
         
        List<List<Integer>> result=new ArrayList<>();
        
        if(root==null)
        {
            return result;
        }
        
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        List<Integer> currlevel=new ArrayList<>();
        while(queue.size()>0)
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                
                TreeNode ele=queue.remove();
               currlevel.add(ele.val);
               
                if(ele.left!=null)
                {
                    queue.add(ele.left);
                }
                
                if(ele.right!=null)
                {
                    queue.add(ele.right);
                }
            }
            
            result.add(currlevel);
            currlevel=new ArrayList<>();
        }
        return result;
        
    }
}

2. DFS Approach
class Solution {
     TreeMap<Integer,ArrayList<Integer>> hm;
    
    public void DFS(TreeNode root,int row)
    {
        if(root==null)
        {
            return;
        }
        
        if(hm.containsKey(row)==false)
        {
            hm.put(row,new ArrayList<>());
        }
        
        hm.get(row).add(root.val);
        
        DFS(root.left,row+1);
        DFS(root.right,row+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
         
        List<List<Integer>> result=new ArrayList<>();
        hm=new TreeMap<>();
        
        // 0 is the current row
        DFS(root,0);
        
        List<Integer> oned=new ArrayList<>();
        for(Integer i:hm.keySet())
        {
            ArrayList<Integer> currrow=hm.get(i);
            
            for(Integer j:currrow)
            {
                oned.add(j);
            }
            
            result.add(oned);
            oned=new ArrayList<>();
        }
        
        return result;
        
    }
}
