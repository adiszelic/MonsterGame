import com.googlecode.lanterna.terminal.Terminal;

import java.util.List;
import java.util.Random;

public class Monsters {


    // DONT LOOK HERE! *SCARY MONSTERS*

    Terminal terminal;

    public int x;
    public int y;
    public Position playerPosition;
    public Speed speed = new Speed();
    public List<Position> positionList;
    public Player player;
    public boolean isDead;


    public Monsters(int x, int y, Terminal terminal, List<Position> positionList, Player player) {
        this.x = x;
        this.y = y;
        this.terminal = terminal;
        this.positionList = positionList;
        this.isDead = false;
        this.player = player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public void fallingEnemy() {

        if (speed.hitObjectMonster(this, positionList)) {

            System.out.println(y);
            System.out.println(y);

            terminal.moveCursor(x, y);
            System.out.println("3");
            terminal.putCharacter(' ');
            System.out.println("4");
            this.isDead = true;
            DrawScreen.monsterList.remove(this);
        }

        else {
            terminal.moveCursor(x, y);
            terminal.putCharacter(' ');
            y++;

            terminal.moveCursor(x, y);
            terminal.putCharacter('\u25B2');
        }
    }


}