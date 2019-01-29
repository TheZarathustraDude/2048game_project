package gameLogic;

public class Render {

    private Grid grid;

    public Render(Grid grid) {
        this.grid = grid;
    }

    public void printGrid() {
        System.out.println("_________________________");
        for (int i = 0; i < 4; i++) {
            System.out.print("|");
            for (int j = 0; j < 4; j++) {
                if (grid.grid[i][j] == 0) {
                    System.out.print("     ");
                } else if (grid.grid[i][j] < 10) {
                    System.out.print("    " + grid.grid[i][j]);
                } else if (grid.grid[i][j] >= 10 && grid.grid[i][j] < 100) {
                    System.out.print("   " + grid.grid[i][j]);
                } else if (grid.grid[i][j] >= 100 && grid.grid[i][j] < 1000) {
                    System.out.print("  " + grid.grid[i][j]);
                } else {
                    System.out.print(" " + grid.grid[i][j]);
                }
                System.out.print("|");
            }
            System.out.println();
            System.out.println("|_____|_____|_____|_____|");
        }
        System.out.println();
    }
}
