//TC-O(N) Approach Using HashMap

class Solution {
    HashMap<Integer,Integer> hm;
    
    public void helper(TreeNode root,HashMap<Integer,Integer> hm)
    {
        if(root==null)
        {
            return;
        }
        
        if(hm.containsKey(root.val)==false)
        {
            hm.put(root.val,1);
        }
        else
        {
            hm.put(root.val,1+hm.get(root.val));
        }
        
        helper(root.left,hm);
        helper(root.right,hm);
    }
    public int[] findMode(TreeNode root) {
        hm=new HashMap<>();
        
        helper(root,hm);
        
        int maxval=Integer.MIN_VALUE;
        ArrayList<Integer> result=new ArrayList<>();
        for(Integer i:hm.keySet())
        {
            if(hm.get(i)>maxval)
            {
                maxval=hm.get(i);
            }
        }
        
        for(Integer i:hm.keySet())
        {
            if(hm.get(i)==maxval)
            {
                result.add(i);
            }
        }
        int[] array =new int[result.size()];
        
        for(int i=0;i<result.size();i++)
        {
            array[i]=result.get(i);
        }
        
        return array;
    }
}
