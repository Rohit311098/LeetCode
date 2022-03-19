class Solution {
    public int LISS(Node node){
        if(node==null)
        {
            return 0;
        }
        
        int child=LISS(node.left)+LISS(node.right);
        
        int myself=1;
        
        if(node.left!=null)
        {
            myself+=LISS(node.left.left)+LISS(node.left.right);
        }
        
        
        if(node.right!=null)
        {
            myself+=LISS(node.right.left)+LISS(node.right.right);
            
        }
        
        return Math.max(child,myself);
    }
}
