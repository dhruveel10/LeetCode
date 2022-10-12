class Solution {
    //973. K Closest Points to Origin - https://youtu.be/1rEUgAG7f_c
    //IMP question for Amazon
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> ((b[0]*b[0] + b[1]*b[1])
                                                                    - (a[0]*a[0] + a[1]*a[1])));
        //since distance is from the origin, sq(y2-y1) = sq(y2)

        for(int[]point:points){
            maxHeap.add(point);
            if(maxHeap.size() > k)
                maxHeap.remove();
        }

        int[][]result = new int[k][2];
        while(k > 0){
            result[--k] = maxHeap.remove();
        }
        return result;
    }
}