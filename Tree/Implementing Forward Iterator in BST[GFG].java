class BSTIterator
{
    Stack<TreeNode> stk=new Stack<>();
    public BSTIterator(Node root)
    {
        TreeNode curr = root;
        insertleft(root);
    }
    
    public void insertleft(TreeNode root)
    {
        while (root != null)
        {
            stk.push(root);
            root = root.left;
        }
        
    }
    public TreeNode curr()
    {
        return s.peek();
    }
    
    public void next()
    {
         TreeNode temp = s.pop();
         insertleft(temp.right);
    }
    
    public boolean isEnd()
    {
        return stk.isEmpty();
    }
}
