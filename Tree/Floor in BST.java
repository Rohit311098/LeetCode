class Tree {
    // Function to return the ceil of given number in BST.
    

    int findCeil(Node root, int key) {
        if (root == null) return -1;
        
        int floor=-1;
        
        while(root!=null)
        {
            
            if(root.data==key)
            {
                return root.data;
            }
            
            if(root.data<key)
            {
                floor=root.data;
                root=root.right;
            }
            else
            {
                root=root.left;
            }
        }
        return floor;
    }
}
