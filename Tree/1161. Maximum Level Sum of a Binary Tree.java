1. BFS Approach
class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        int maxval=Integer.MIN_VALUE;
        int maxlevel=1;
        int currlevel=1;
        
        
        while(q.size()>0)
        {
            int currlevelsum=0;
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.remove();
                
                currlevelsum+=curr.val;
                
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
            
            if(currlevelsum>maxval)
            {
                maxval=currlevelsum;
                maxlevel=currlevel;
            }
            
            currlevel++;
        }
        
        return maxlevel;
    }
}

2. DFS Approach
class Solution {
    
    public void DFS(TreeNode root,int level,ArrayList<Integer> arr)
    {
        if(root==null)
        {
            return;
        }
        
        if(arr.size()>level)
        {
            int curr=arr.get(level);
            arr.set(level,curr+root.val);
        }
        else
        {
            arr.add(root.val);
        }
        
        DFS(root.left,level+1,arr);
        DFS(root.right,level+1,arr);
    }
    public int maxLevelSum(TreeNode root) {
        
        ArrayList<Integer> arr=new ArrayList<>();
        if(root==null)
        {
            return 0;
        }
        
        arr.add(0);
        DFS(root,1,arr);
        
        int result=1;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<arr.size();i++)
        {
            if(max<arr.get(i))
            {
                max=arr.get(i);
                result=i;
            }
        }
        return result;
    }
}
