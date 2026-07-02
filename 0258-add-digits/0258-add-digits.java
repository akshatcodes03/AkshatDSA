class Solution {
    private int sumDigit(int num){

        int sum = 0;

        while(num>0){
            int digit = num%10;
            sum+=digit;
            num/=10;
        }
        return sum;
    }

        public int addDigits(int num){
            while(num>=10){
                num=sumDigit(num);
            }
            return num;
        }

    }
