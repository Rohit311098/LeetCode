p and q node always exist in this tree if that is given then below 2 approaches work if p and q may or may not present then 3 approach work

1. Brute Force Approach-> Using Root to node path
  TC-O(N)    SC-O(N)
    
class Solution {
    public ArrayList<TreeNode> getpath(TreeNode root,TreeNode p)
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        
        if(root==p)
        {
            ArrayList<TreeNode> result=new ArrayList<>();  
            result.add(root);
            return result;
        }
        
        ArrayList<TreeNode> leftside=getpath(root.left,p);
        
        if(leftside.size()>0)
        {
            leftside.add(root);
            return leftside;
        }
        
        ArrayList<TreeNode> rightside=getpath(root.right,p);
        
        if(rightside.size()>0)
        {
            rightside.add(root);
            return rightside;
        }
        
        return new ArrayList<>();
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null)
        {
            return null;
        }
        
        ArrayList<TreeNode> path1=getpath(root,p);
        
        ArrayList<TreeNode> path2=getpath(root,q);
        
        
        TreeNode result=null;
        
        int i=path1.size()-1,j=path2.size()-1;
        
        while(i>=0 && j>=0)
        {
            if(path1.get(i).val==path2.get(j).val)
            {
                result=path1.get(i);
            }
            else
            {
                return result;
            }   
            i--;
            j--;
        }
        return result;
    }
}




2. Optimised Approach -> Returing node approach
  TC-O(N)    SC-O(1)
    
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null)
        {
            return null;
        }
        
        if(root==p || root==q)
        {
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        
        if(left!=null && right!=null)
        {
            return root;
        }
        
         if(left!=null)
        {
            return left;
        }
        
        return right;
    }
}


3. If p and q node may or may not present



