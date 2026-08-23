class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftsum = 0;
        int rightsum = 0;
        int leftQ = 0 ;
        int rightQ = 0 ;
        for(int i = 0 ; i<n/2; i++){
            if(num.charAt(i)=='?') {
                leftQ++;
            }else{
                leftsum+=num.charAt(i)-'0';
            }
        }
        for(int i = n/2; i<n ;i++){
            if(num.charAt(i)=='?'){
                rightQ++;
            }else{
                rightsum+=num.charAt(i)-'0';
            }
        }
        if((leftQ+rightQ)%2!=0){
            return true;
        }else{
            return 2*(leftsum-rightsum)!=9*(rightQ-leftQ);
        }
    }
}