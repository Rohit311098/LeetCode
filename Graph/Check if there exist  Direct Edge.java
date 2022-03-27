public static int getidx(ArrayList<Edge> graph[], int src,int nbr)
    {
        for(int i=0;i<graph[src].size();i++)
        {
            Edge e=graph[src].get(i);
            
            if(e.nbr==nbr)
            {
              //If edge exist return its index
                return i;
            }
        }
        
      //There is no edge exist hence return -1
        return -1;
    }
