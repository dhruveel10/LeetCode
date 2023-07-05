class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }
    
    public static void fill(int[][] image, int sr, int sc, int color, int newColor){
        //always out of box condition first and then the condition
        if(sr >= image.length || sc >= image[0].length || sr < 0 || sc < 0 || image[sr][sc] != color)
            return;
        
        image[sr][sc] = newColor;
        fill(image, sr-1, sc, color, newColor);
        fill(image, sr+1, sc, color, newColor);
        fill(image, sr, sc-1, color, newColor);
        fill(image, sr, sc+1, color, newColor);
    }
}