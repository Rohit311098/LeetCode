class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static class Pair
    {
        int size;
        int minvalue;
        int maxvalue;
        Pair(int size,int maxvalue,int minvalue)
        {
            this.size=size;
            this.maxvalue=maxvalue;
            this.minvalue=minvalue;
        }
    }
    
    static Pair largestBsthelper(Node root)
    {
        if(root==null)
        {
            Pair p=new Pair(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
            return p;
        }
        
       Pair left=largestBsthelper(root.left);
       Pair right=largestBsthelper(root.right);
       
       if(root.data>left.maxvalue && root.data<right.minvalue)
       {
           Pair newpair=new Pair(left.size+right.size+1,Math.max(root.data,right.maxvalue),
                                              Math.min(root.data,left.minvalue));
                                              
            return newpair;
       }
       
       return new Pair(Math.max(left.size,right.size),Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    static int largestBst(Node root)
    {
        Pair ans=largestBsthelper(root);
        
        return ans.size;
    }
    
}
