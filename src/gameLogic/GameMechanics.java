package gameLogic;

import java.util.Random;

public class GameMechanics {

    private Move move;
    private Grid grid;
    private Render render;

    public GameMechanics(Move move, Grid grid, Render render) {
        this.move = move;
        this.grid = grid;
        this.render = render;
    }

    private static int getRandomNum() {
        Random num = new Random();
        return num.nextInt(4);
    }

    public void gridGameStart(){
        //range of numbers we need to start the game (fail safe if random throws two identical coordinates)
        int range = 2;
        //Get 2 random numbers as coordinates and place value 2 in two starting points
        for (int i=0; i<range ;i++){
            int x = getRandomNum();
            int y = getRandomNum();
            if(grid.grid[y][x] == 0){
                grid.grid[y][x] = 2;
            }
            else {
                range++;
            }
        }
    }

    public void start(){
        System.out.println("Game 2048\n"+
                           "Controls:\n"+
                           "w - up | a - left | s - down | d - right\n" +
                           "q - quit/end the game");
        gridGameStart();
        render.printGrid();
    }

    public void gameEndLoss() {
       System.out.println("Game Over");
       System.exit(0);
    }

    public void gameEndWin() {
        System.out.println("You Win");
        System.exit(0);
    }

    public void lossConditionCheck(){
        if(!move.moveCheck()) {
            gameEndLoss();
        }
    }

    public void winConditionCheck() {
        if(move.getIs2048()) {
          gameEndWin();
        }
    }

    public void move(Command command) {
        switch (command){
            case LEFT:
                move.moveLeft();
                break;
            case RIGHT:
                move.moveRight();
                break;
            case UP:
                move.moveUp();
                break;
            case DOWN:
                move.moveDown();
                break;
            case QUIT:
                gameEndLoss();
                break;
            case NOTHING:
                break;
            default:
                break;
        }
    }

}
