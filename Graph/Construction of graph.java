import java.util.*;

public class Main
{
      static class Edge
      {
          int src;
          int nbr;
          int wt;

          Edge(int src,int nbr,int wt)
          {
              this.src=src;
              this.nbr=nbr;
              this.wt=wt;
          }
      }

      public static void main(String[] args)
      {
          Scanner sc=new Scanner(System.in);

          int vertex=sc.nextInt();

          ArrayList<Edge> graph[]=new ArrayList[vertex];

          for(int i=0;i<vertex;i++)
          {
              graph[i]=new ArrayList<>();
          }

          int edges=sc.nextInt();

          for(int i=0;i<edges;i++)
          {
              int src=sc.nextInt();
              int nbr=sc.nextInt();
              int wt=sc.nextInt();

              graph[src].add(new Edge(src,nbr,wt));
              graph[nbr].add(new Edge(nbr,src,wt));
          }

          display(graph,vertex);
      }
  
  public static void display(ArrayList<Edge>[] graph,int vertex)
    {
        for(int i=0;i<vertex;i++)
        {
            System.out.print(i+"----->");
            
            for(Edge e:graph[i])
            {
                System.out.print("("+" "+e.nbr+"@"+e.wt+")");
            }
            
            System.out.println();
        }
    }
    
    
}
