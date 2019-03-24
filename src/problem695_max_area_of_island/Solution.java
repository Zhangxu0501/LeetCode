package problem695_max_area_of_island;


class Solution {
    public static int maxAreaOfIsland(int[][] grid) {
        if(grid==null){
            return 0;
        }
        int max=0;
        int x=grid.length;
        int y=grid[0].length;
        boolean [] [] visited=new boolean[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    int current=search(i,j,grid,visited);
                    if(current>max){
                        max=current;
                    }
                }
            }
        }
        return max;
    }
    public static int search(int i,int j,int [] [] grid,boolean [] [] visited){
        if(i>=grid.length||j>=grid[0].length||i<0||j<0){
            return 0;
        }
        if(grid[i][j]==1&&!visited[i][j]){
            visited[i][j]=true;
            int area = search(i+1,j,grid,visited)+search(i,j+1,grid,visited)+search(i,j-1,grid,visited)+search(i-1,j,grid,visited);
            return area+1;
        }
        return 0;

    }

    public static void main(String[] args) {
        int [] [] a={{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxAreaOfIsland(a));
    }
}