class Solution {

    
    public int area(int x1, int y1, int x2, int y2) {

        int length = x2 - x1;
        int breadth = y2 - y1;

        return length * breadth;
    }

    
    public int overlap(int ax1, int ay1, int ax2, int ay2,
                       int bx1, int by1, int bx2, int by2) {

        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);

        if (overlapWidth <= 0 || overlapHeight <= 0) {
            return 0;
        }

        return overlapWidth * overlapHeight;
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {

        int area1 = area(ax1, ay1, ax2, ay2);
        int area2 = area(bx1, by1, bx2, by2);

        int commonArea = overlap(ax1, ay1, ax2, ay2,
                                 bx1, by1, bx2, by2);

        return area1 + area2 - commonArea;
    }
}