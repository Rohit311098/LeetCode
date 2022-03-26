1. Brute Force- TC-O(N2)  SC-O(1)
  
  class Solution
{
    static int count=0;
	public static int countPairs(Node root1, Node root2, int x)
	{
	     if(root1==null || root2==null)
		{
		    return 0;
		}
		
		if(search(root2,x-root1.data))
		{
		    count++;
		}
	    
	    countPairs(root1.left,root2,x);
	    countPairs(root1.right,root2,x);
    
    return count;
	}
	

	
	public static boolean search(Node root,int k)
	{
	    if(root==null)
	    {
	        return false;
	    }
	    
	    if(root.data==k)
	    {
	        return true;
	    }
	    
	    return search(root.left,k) || search(root.right,k);
	}
}

2. Optimised Approach

class Solution
{
    static int count;
    static HashSet<Integer> hm;
	public static int countPairs(Node root1, Node root2, int x)
	{
	    count=0;
	    hm=new HashSet<>();
	    fillvalues(root2);
	    dfs(root1,x);
	    return count;
		
	}
	
	public static void fillvalues(Node root)
	{
	    if(root==null)
	    {
	        return;
	    }
	    
	    hm.add(root.data);
	    
	    fillvalues(root.left);
	    fillvalues(root.right);
	}
	public static void dfs(Node root1, int x)
	{
	    if(root1==null)
		{
		    return;
		}
		
		if(hm.contains(x-root1.data))
		{
		    count++;
		}
	    
	    dfs(root1.left,x);
	    dfs(root1.right,x);
	}
}
