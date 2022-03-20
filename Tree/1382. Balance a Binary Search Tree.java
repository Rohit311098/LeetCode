class Solution {
    
     public TreeNode balanceBST(TreeNode root) {
        
        ArrayList<Integer> arr=new ArrayList<>();
        
        getinorder(root,arr);
        
        System.out.println(arr);
        return balanceBSTHelper(arr,0,arr.size()-1);
        
    }
    public void getinorder(TreeNode root,ArrayList<Integer> arr)
    {
        if(root==null)
        {
            return;
        }
        
        getinorder(root.left,arr);
        arr.add(root.val);
        getinorder(root.right,arr);
    }
    
    public TreeNode balanceBSTHelper(ArrayList<Integer> arr,int left,int right)
    {
        if(left>right)
        {
            return null;
        }
        
        int mid=left+(right-left)/2;
        
        TreeNode root=new TreeNode(arr.get(mid));
        root.left=balanceBSTHelper(arr,left,mid-1);
        root.right=balanceBSTHelper(arr,mid+1,right);
        return root;
    }
   
}
