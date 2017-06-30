import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class Speed {
    public Player player;
    public DrawScreen drawScreen;
    public Position position;
    public Monsters monsters;

    //minst jump y 21
    //if han slår i huvudet på en character - abort!
    //if han står på character - falling = false
    //sätt velocity och energi
    //
    public static void Speed() {
        double velocity;
        double energy;
    }

    public boolean hitObject(Player player, List<Position> positionList) {
        for (Position position : positionList) {
            if (player.x == position.getX() && player.y == position.getY()) {
                if ((position.getObjectType() == 'X') || (position.getObjectType() == '-') ||
                        (position.getObjectType() == '❤')) {
                    return true;
                }
            }
        }
        return false;}
        //run until true
        // check if object is below/above/left/right
        //
        public boolean hitObjectMonster(Monsters monsters, List<Position> positionList) {
            for (Position position : positionList) {
                if (monsters.x == position.getX() && monsters.y == position.getY()-1) {
                    if ((position.getObjectType() == 'X') || (position.getObjectType() == '-') ||
                            (position.getObjectType() == '❤') || (position.getObjectType() == '^')) {
                        return true;
                    }
                }
            }
            return false;
        }

    public boolean death (Player player, List<Position> positionList) {
        for (Position position : positionList) {
            if (player.x == position.getX() && player.y == position.getY() && position.getObjectType() == '^') {
                return true;
            }
        }

        return false;

    }
}
