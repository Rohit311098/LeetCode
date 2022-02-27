class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
          ArrayList<Integer> result=new ArrayList<>();
          
          Queue<Node> queue=new ArrayDeque<>();
          
          Node curr=null;
          queue.add(root);
          while(curr!=null || queue.size()>0)
          {
              curr=queue.remove();
              
              while(curr!=null)
              {
                  result.add(curr.data);
                  if(curr.left!=null)
                  {
                      queue.add(curr.left);
                  }
                  curr=curr.right;
              }
          }
          
          return result;
      }
}
