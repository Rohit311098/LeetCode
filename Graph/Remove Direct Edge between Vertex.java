 public static int getidx(ArrayList<Edge> graph[], int src,int nbr)
    {
        for(int i=0;i<graph[src].size();i++)
        {
            Edge e=graph[src].get(i);
            
            if(e.nbr==nbr)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public static void removeEdge(ArrayList<Edge> graph[], int src,int nbr)
    {
        int i=getidx(graph,src,nbr);
        
        graph[src].remove(i);
        
        int j=getidx(graph,nbr,src);
        
        graph[nbr].remove(j);
    }
