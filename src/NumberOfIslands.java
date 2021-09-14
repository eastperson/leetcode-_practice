public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslandsSolution numberOfIslandsSolution = new NumberOfIslandsSolution();
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numberOfIslandsSolution.numIslands(grid));
    }
}

class NumberOfIslandsSolution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j =0; j <grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    mark(grid,i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void mark(char[][] grid, int row, int col){
        grid[row][col] = '-';
        if(row < grid.length - 1 && grid[row+1][col] == '1'){
            mark(grid, row+1, col); // 상
        }
        if(row > 0 && grid[row-1][col] == '1'){
            mark(grid, row-1, col); // 하
        }
        if(col > 0 && grid[row][col-1] == '1'){
            mark(grid, row, col-1); // 좌
        }
        if(col < grid[row].length - 1 && grid[row][col+1] == '1'){
            mark(grid, row, col+1); //우
        }
    }

}