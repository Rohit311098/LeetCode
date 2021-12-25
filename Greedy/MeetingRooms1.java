// MeetingRooms1
https://www.lintcode.com/problem/920/



/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
      public static class Mycomparator implements Comparator<Interval>
    {
        public int compare(Interval obj1,Interval obj2)
        {
            if(obj1.start!=obj2.start)
            {
                return obj1.start-obj2.start;
            }
            return obj1.end-obj2.end;
        }
    }
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        
        Collections.sort(intervals, new Mycomparator());
        for(int i=1;i<intervals.size();i++)
        {
                 if(intervals.get(i-1).end>intervals.get(i).start)
                 {
                     return false;
                 }
        }

        return true;

    }
}
