class Solution {
    public int countDaysTogether(
        String arriveAlice, 
        String leaveAlice, 
        String arriveBob, 
        String leaveBob) {
        
        String Start = arriveAlice.compareTo(arriveBob)>0?arriveAlice:arriveBob;

        String end = leaveAlice.compareTo(leaveBob)<0?leaveAlice:leaveBob;

        if (Start.compareTo(end) > 0) return 0;

        int[] days = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };

        int startDay = days[Integer.parseInt(Start.substring(0, 2))-1]+Integer.parseInt(Start.substring(3));

        int endDay = days[Integer.parseInt(end.substring(0, 2)) - 1]+Integer.parseInt(end.substring(3));

        return endDay-startDay+1;

    }
}