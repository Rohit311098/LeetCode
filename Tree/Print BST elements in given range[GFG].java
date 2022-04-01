
class Solution
{   
    //Function to return a list of BST elements in a given range.
    
    public static void helper(Node root,int low,int high,ArrayList<Integer> result)
    {
        if(root==null)
        {
            return;
        }
	    
	 if(root.data>=low)   
          	helper(root.left,low,high,result);
	    
        if(root.data>=low && root.data<=high)
        {
            result.add(root.data);
        }
	
	if(root.data<=high)
        	helper(root.right,low,high,result);
    }
	public static ArrayList<Integer> printNearNodes(Node root,int low,int high) {
        // code here.
        if(root==null)
        {
            return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> result=new ArrayList<>();
        
        helper(root,low,high,result);
        return result;
    }
    
}
