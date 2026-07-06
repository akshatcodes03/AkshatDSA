class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        
        Arrays.sort(intervals, (a, b) -> {
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            else{
                return a[0]-b[0];
            }
        });

        
        List<int[]> result = new ArrayList<>();

        
        result.add(intervals[0]);

        
        int[] current = intervals[0];

        
        int count = 0;

        
        for (int i = 1; i < intervals.length; i++) {

            
            if (current[0] <= intervals[i][0] &&
                current[1] >= intervals[i][1]) {

                
                count++;
            }
            else if (intervals[i][1] > current[1]) {
                current = intervals[i];
                }
        }

        
        return intervals.length - count;
    }
}