class BSTIterator {
    
    Stack<TreeNode> stk=new Stack<>();
    public BSTIterator(TreeNode root) {
        insertAllleft(root);
    }
    
    public void insertAllleft(TreeNode root)
    {
        while(root!=null)
        {
            stk.push(root);
            root=root.left;
        }
    }
    
    public int next() {
       
        TreeNode  ele=stk.pop();
        insertAllleft(ele.right);
        
        return ele.val;
    }
    
    public boolean hasNext() {
        if(stk.size()==0)
        {
            return false;
        }
        
        return true;
    }
}
