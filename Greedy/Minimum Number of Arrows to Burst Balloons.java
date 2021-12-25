Leetcode 452. Minimum Number of Arrows to Burst Balloons

class Solution {
    public static class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }
  
  public static class Mycomparator implements Comparator<Interval>
    {
        public int compare(Interval obj1,Interval obj2)
        {
            if(obj1.end<obj2.end)
            {
                return -1;
            }
            return 1;
        }
    }
    public int findMinArrowShots(int[][] arr) {
         int n=arr.length;
        Interval[] intervals=new Interval[n];
        for(int i=0;i<n;i++)
        {
            intervals[i]=new Interval(arr[i][0],arr[i][1]);
        }
        
        Arrays.sort(intervals, new Mycomparator());
        
        int count=1;
        int last=intervals[0].end;
        for(int i=1;i<n;i++)
        {
                 if(last<intervals[i].start)
                 {
                     last=intervals[i].end;
                     count++;
                 }
        }

        return count;
        
    }
}
