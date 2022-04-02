import java.util.*;
public class Main
{
  public static void main(String[] args)
  {
    Scanner scn = new Scanner(System.in);
        int noofpairs_src_des = scn.nextInt();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < noofpairs_src_des; i++) {
          String s1 = scn.next();
          String s2 = scn.next();
          map.put(s1, s2);	
        }

    HashMap<String,Boolean> potentialsrc=new HashMap<>();

        for(String src:map.keySet())
        {
          String dest=map.get(src);

          potentialsrc.put(dest,false);

          if(potentialsrc.containsKey(src)==false)
          {
            potentialsrc.put(src,true);
          }
        }

        String mainsrc="";
        for(String src:potentialsrc.keySet())
        {
          if(potentialsrc.get(src)==true)
          {
            mainsrc=src;
            break;
          }
        }

        while(true)
        {
          if(map.containsKey(mainsrc)==true)
          {
            System.out.print(mainsrc+ " -> ");
            mainsrc=map.get(mainsrc);
          }
          else
          {
            System.out.print(mainsrc+".");
            break;
          }
        }
  }
}
