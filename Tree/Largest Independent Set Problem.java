// TC-O(N2)   SC-O(1)

// If we have constructions rights then we can store LISS of each node and we don't need to calculate LISS of child and grandchild again and again

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
