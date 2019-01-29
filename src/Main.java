import gameLogic.*;

public class Main {
    public static void main(String[] args) {

        Grid grid = new Grid();
        Move move = new Move(grid);
        Render render = new Render(grid);

        GameMechanics gmechanics = new GameMechanics(move,grid,render);

        Input input = new Input();

        gmechanics.start();

        while (true){
            gmechanics.winConditionCheck();
            gmechanics.lossConditionCheck();

            Command command = input.getCommand();

            gmechanics.move(command);
            render.printGrid();
        }
    }

}
