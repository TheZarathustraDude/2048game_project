package gameLogic;

import java.util.Random;

public class Move {

    private Grid grid;

    public Move(Grid grid) {
        this.grid = grid;
    }

    private boolean is2048 = false;

    private boolean didMoveLeft = false;
    private boolean didMoveRight = false;
    private boolean didMoveUp = false;
    private boolean didMoveDown = false;

    public boolean getIs2048() {
        return is2048;
    }

    //Moving numbers in the grid and merging if they are the same
    public void moveRight() {
        //MOVE RIGHT
        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j > 0; j--) {
                if (grid.grid[i][j] == grid.grid[i][j - 1] && grid.grid[i][j] != 0) {
                    grid.grid[i][j] += grid.grid[i][j - 1];
                    grid.grid[i][j - 1] = 0;

                    if (grid.grid[i][j] >= 2048) {
                        is2048 = true;
                    }
                    didMoveRight =true;
                }

                if (grid.grid[i][j] == 0 && grid.grid[i][j - 1] != 0 ) {
                    grid.grid[i][j] = grid.grid[i][j - 1];
                    grid.grid[i][j - 1] = 0;

                    didMoveRight =true;
                }
            }
        }
        newNum();
    }

    public void moveLeft() {
        //MOVE LEFT
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid.grid[i][j] == grid.grid[i][j + 1] && grid.grid[i][j] != 0) {
                    grid.grid[i][j] += grid.grid[i][j + 1];
                    grid.grid[i][j + 1] = 0;

                    if (grid.grid[i][j] >= 2048) {
                        is2048 = true;
                    }
                    didMoveLeft = true;
                }

                if (grid.grid[i][j] == 0 & grid.grid[i][j + 1] != 0 ) {
                    grid.grid[i][j] = grid.grid[i][j + 1];
                    grid.grid[i][j + 1] = 0;

                    didMoveLeft = true;
                }
            }
        }
        newNum();
    }

    public void moveUp() {
        //MOVE UP
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 3; j++) {
                if (grid.grid[i][j] == grid.grid[i + 1][j] && grid.grid[i][j] != 0) {
                    grid.grid[i][j] += grid.grid[i + 1][j];
                    grid.grid[i + 1][j] = 0;

                    if (grid.grid[i][j] >= 2048) {
                        is2048 = true;
                    }
                    didMoveUp = true;
                }

                if (grid.grid[i][j] == 0 & grid.grid[i + 1][j] != 0 ) {
                    grid.grid[i][j] = grid.grid[i + 1][j];
                    grid.grid[i + 1][j] = 0;

                    didMoveUp = true;
                }
            }
        }
        newNum();
    }

    public void moveDown() {
        //MOVE DOWN
        for (int i = 3; i > 0; i--) {
            for (int j = 3; j >= 0; j--) {
                if (grid.grid[i][j] == grid.grid[i - 1][j] && grid.grid[i - 1][j] != 0) {
                    grid.grid[i][j] += grid.grid[i - 1][j];
                    grid.grid[i - 1][j] = 0;

                    if (grid.grid[i][j] >= 2048) {
                        is2048 = true;
                    }
                    didMoveDown = true;
                }

                if (grid.grid[i][j] == 0 && grid.grid[i - 1][j] != 0 ) {
                    grid.grid[i][j] = grid.grid[i - 1][j];
                    grid.grid[i - 1][j] = 0;

                    didMoveDown = true;
                }
            }
        }
        newNum();
    }


    //===================================
    //Check if there is any possible move
    public boolean moveCheck() {
        boolean canMove = false;
        //CHECK MOVE RIGHT
        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j > 0; j--) {
                if (grid.grid[i][j] == grid.grid[i][j - 1]) {
                    canMove = true;
                }
                if (grid.grid[i][j] == 0) {
                    canMove = true;
                }
            }
        }

        //CHECK MOVE LEFT
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid.grid[i][j] == grid.grid[i][j + 1]) {
                    canMove = true;
                }
                if (grid.grid[i][j] == 0) {
                    canMove = true;
                }
            }
        }

        //CHECK MOVE UP
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 3; j++) {
                if (grid.grid[i][j] == grid.grid[i + 1][j]) {
                    canMove = true;
                }
                if (grid.grid[i][j] == 0) {
                    canMove = true;
                }
            }
        }

        //CHECK MOVE DOWN
        for (int i = 3; i > 0; i--) {
            for (int j = 3; j >= 0; j--) {
                if (grid.grid[i][j] == grid.grid[i - 1][j]) {
                    canMove = true;
                }
                if (grid.grid[i][j] == 0) {
                    canMove = true;
                }
            }
        }
        return canMove;
    }

    //===================================
    //Add number after move

    private static int newRandNum() {
        Random num = new Random();
        //10% chance of new number being a 4 and 90% chance of it being a 2
        if (num.nextInt(10) > 8) {
            return 4;
        } else {
            return 2;
        }
    }

    public void newNum() {
        Random num = new Random();

        if (didMoveRight) {
            while (true) {
                int x = num.nextInt(2);
                int y = num.nextInt(4);
                if (grid.grid[y][x] == 0) {
                    grid.grid[y][x] = newRandNum();
                    break;
                }
            }
            didMoveRight = false;
        }

        if (didMoveLeft) {
            while (true) {
                int x = num.nextInt(2);
                int y = num.nextInt(4);
                if (grid.grid[y][x + 2] == 0) {
                    grid.grid[y][x + 2] = newRandNum();
                    break;
                }
            }
            didMoveLeft = false;
        }

        if (didMoveUp) {
            while (true) {
                int x = num.nextInt(4);
                int y = num.nextInt(2);
                if (grid.grid[y + 2][x] == 0) {
                    grid.grid[y + 2][x] = newRandNum();
                    break;
                }
            }
            didMoveUp = false;
        }

        if (didMoveDown) {
            while (true) {
                int x = num.nextInt(4);
                int y = num.nextInt(2);
                if (grid.grid[y][x] == 0) {
                    grid.grid[y][x] = newRandNum();
                    break;
                }
            }
            didMoveDown = false;
        }
    }

}

