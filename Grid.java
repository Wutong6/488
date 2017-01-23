package a1;

public class Grid
{
protected int rows;         // number of grid rows
protected int cols;         // number of grid columns
 
protected boolean [][] grid;     // the grid containing blobs
// You may define helper variables as needed

public Grid(int rows, int cols, boolean[][] grid)

{
 this.rows = rows;
 this.cols = cols;
 this.grid = grid;
 
}

@Override
public String toString()
{
 String gridString = "";
 for (int i = 0; i < rows; i++)
 {
   for (int j = 0; j < cols; j++)
   {
     if (grid[i][j])
       gridString = gridString + "X";
     else
       gridString = gridString + ".";
    }
   gridString = gridString + "\n";   // end of row
 }  
 return gridString;
}

public int blobCount()
// returns the number of blobs in this grid
{
 int count = 0;
 // Your code goes here
 Grid grid2 = new Grid(rows, cols, this.grid);
 for (int i = 0; i < rows; i++){
	 
	 for (int j = 0; j < cols; j++){
		 
		 if (grid2.grid[i][j]){
			 count += 1;
			 checkBlob(i, j, grid2);
		 }
	 }
 }
 
 return count;
}

// You may define heper methods as needed

public void checkBlob(int i, int j, Grid g){
        if (i < 0 || j < 0 || i >= rows || j >= cols){
                return;
        }
	if (g.grid[i][j]){
		g.grid[i][j] = false;
		checkBlob(i-1, j, g);
		checkBlob(i+1, j, g);
		checkBlob(i, j-1, g);
		checkBlob(i, j+1, g);
	}
}

/*public static void main(String[] args){
        boolean f[][] = {{true, true}, {false, true}};
	Grid g = new Grid(2, 2, f);
	int i = g.blobCount();
        System.out.println(i);
}
*/
}

