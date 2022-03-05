1. Recursive Approach-> TC-O(N)  SC-(H) Recusion space
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

2. Iterative Method-> TC-O(N)  SC-O(H) (Khud ka stack)
    class Solution {
    public class Pair
    {
        TreeNode node;
        char state;
        
        Pair(TreeNode node)
        {
            this.node=node;
            this.state='l';
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        
         if(root==null)
        {
            return new ArrayList<>();
        }
        
        ArrayList<Integer> result=new ArrayList<>();
         Stack<Pair> stk=new Stack<>();
        stk.push(new Pair(root));
        
        while(stk.size()!=0)
        {
            if(stk.peek().state=='l')
            {
                if(stk.peek().node.left!=null)
                {
                    Pair p=stk.pop();
                    p.state='i';
                    stk.push(p);
                    stk.push(new Pair(p.node.left));
                }
                else
                {
                    Pair p=stk.pop();
                    p.state='i';
                    stk.push(p);
                }
                
            }
            else if(stk.peek().state=='i')
            {
                result.add(stk.peek().node.val);
                stk.peek().state='r';
            }
            else
            {
                Pair top=stk.pop();
                if(top.node.right!=null)
                {
                    stk.push(new Pair(top.node.right));
                }
            }
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
