//919 LintCode

Approach 1 -> Using List 
public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        //Sorting the interval list based on meeting start time.
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval x, Interval y){
                return x.start - y.start;
            }
        });
        
        List<Integer> rooms = new ArrayList<Integer>();
				
        boolean flag = false;
        for(Interval x: intervals){
				//for each meeting check all the rooms. if any room is avaiable then update the meeting end time in that room.
            for(int i=0;i<rooms.size();i++){
                if(x.start>rooms.get(i)){
                    rooms.set(i,x.end);
                    flag = true;
                    break;
                }
            }
            
						// rooms were not available then add a new room.
            if(!flag){
                rooms.add(x.end);
            }
            flag = false;
        }
        
        return rooms.size();
    }
    
    
    
    
    
    
 Approach 2-> Using Sorting and 2 pointer
 
