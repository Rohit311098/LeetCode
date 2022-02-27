TC-O(N2)->Because for each node we are calculating string for each node SC-O(N)
class Solution {
    
    HashMap<String,Integer> h;
    List<TreeNode> result;
    public String helper(TreeNode root)
    {
        if(root==null)
        {
            return "#";   
        }
        
        String curr=root.val+","+helper(root.left)+","+helper(root.right);
        
        
        h.put(curr,h.getOrDefault(curr,0)+1);
        if(h.get(curr)==2)
        {
            result.add(root);
        }
        
        return curr;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        if(root==null)
        {
            return new ArrayList<>();
        }
        
        h=new HashMap<>(); 
        result=new ArrayList<>();
        helper(root);
        return result;
    }
}
