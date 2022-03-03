// Using Extra Space and TC-O(N)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        if(root==null)
        {
            return new ArrayList<Integer>();
        }
        
        List<Integer> result=new ArrayList<Integer>();
        
        List<Integer> left_child=inorderTraversal(root.left);
        for(Integer i:left_child)
        {
            result.add(i);
        }
        
        result.add(root.val);
        
        List<Integer> right_child=inorderTraversal(root.right);
        
        for(Integer i:right_child)
        {
            result.add(i);
        }
        
        return result;
    }
}


2. Morris Traversal-> TC-O(N)   SC-O(1)


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result=new ArrayList<>();
        
        while(root!=null)
        {
            if(root.left!=null)
            {
                TreeNode rootkleftkaright=root.left;
                
                while(rootkleftkaright.right!=null && rootkleftkaright.right!=root)
                {
                    rootkleftkaright=rootkleftkaright.right;
                }
                
                if(rootkleftkaright.right==root)
                {
                    result.add(root.val);
                    rootkleftkaright.right=null;
                    root=root.right;
                }
                else
                {
                    rootkleftkaright.right=root;
                    root=root.left;
                }
            }
            else
            {
                result.add(root.val);
                root=root.right;
            }
        }
        
        return result;
        
    }
}
