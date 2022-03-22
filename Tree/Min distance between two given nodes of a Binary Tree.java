class GfG {
    
    Node getlca(Node root,int a,int b)
    {
        if(root==null)
        {
            return null;
        }
        
        if(root.data==a || root.data==b)
        {
            return root;
        }
        Node left=getlca(root.left,a,b);
        Node right=getlca(root.right,a,b);
        if(left!=null && right!=null)
        {
            return root;
        }
        return (left==null) ? right:left;
    }
    
    int distfromlca(Node root,int a,int level)
    {
        if(root==null)
        {
            return -1;
        }
        
        if(root.data==a)
        {
            return level;
        }
        int left=distfromlca(root.left,a,level+1);
        
        if(left==-1)
                return distfromlca(root.right,a,level+1);
        
        return left;
    }
    
    int findDist(Node root, int a, int b) {
        
        Node lca=getlca(root,a,b);
        int d1=distfromlca(lca,a,0);
        int d2=distfromlca(lca,b,0);
        return d1+d2;
    }
}
