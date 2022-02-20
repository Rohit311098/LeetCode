class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
           ArrayList<Integer> result=new ArrayList<>();
           
           Queue<Node> queue=new ArrayDeque<>();
           
           queue.add(root);
           Node curr=null;
           
           while(curr!=null || queue.size()>0)
           {
               if(curr==null)
               {
                   curr=queue.remove();
                   continue;
               }
               
               result.add(curr.data);
               if(curr.left!=null)
               {
                   queue.add(curr.left);
               }
               curr=curr.right;
           }
           return result;
      }
}
