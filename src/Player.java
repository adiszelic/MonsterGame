import com.googlecode.lanterna.terminal.Terminal;
import java.util.List;

public class Player {

    public int x;
    public int y;
    public Terminal terminal;
    public Speed speed = new Speed();
    public List<Position> positionList;
    public List<Monsters> monsterList;

    public Player(int x, int y, Terminal terminal, List<Position> positionList) {
        this.x = x;
        this.y = y;
        this.terminal = terminal;
        this.positionList = positionList;
    }

    public void jumpUp() {
        System.out.println("y " + y);
        if (y <= 0) {
            terminal.moveCursor(x, y);
            terminal.putCharacter('\u25C6');
        } else {
            terminal.moveCursor(x, y);
            terminal.putCharacter(' ');
            y--;
            if (speed.hitObject(this, positionList)) {
                y++;
            }
            terminal.moveCursor(x, y);
            terminal.putCharacter('\u25C6');
        }
    }

    public void jumpUpLeft() {
        if (x < 0) {
            terminal.moveCursor(x, y);
            terminal.putCharacter('\u25C6');
        } else {
            terminal.moveCursor(x, y);
            terminal.putCharacter(' ');
            y--;
            x--;
            if (speed.hitObject(this, positionList)) {
                y++;
                x++;
            }
            terminal.moveCursor(x, y);
            terminal.putCharacter('\u25C6');
        }
    }
    public void jumpUpRight() {
        if (y < 0) {
            terminal.moveCursor(x, y);
            terminal.putCharacter('\u25C6');
        } else {
            terminal.moveCursor(x, y);
            terminal.putCharacter(' ');
            y --;
            x ++;
            if (speed.hitObject(this, positionList)) {
                y++;
                x--;
            }
            terminal.moveCursor(x, y);
            terminal.putCharacter('\u25C6');
        }
    }

    public void moveLeft() {
        if (x <= 0) {
            terminal.moveCursor(x, y);
            terminal.putCharacter('\u25C6');
        } else {
            terminal.moveCursor(x, y);
            terminal.putCharacter(' ');
            x--;
            if (speed.hitObject(this, positionList)) {
                x++;
            }
            terminal.moveCursor(x, y);
            terminal.putCharacter('\u25C6');
        }
    }

    public void moveRight() {
        if (x >= 100) {
            terminal.moveCursor(x, y);
            terminal.putCharacter('\u25C6');
        } else {
            terminal.moveCursor(x, y);
            terminal.putCharacter(' ');
            x++;
            if (speed.hitObject(this, positionList)) {
                x--;
            }
            terminal.moveCursor(x, y);
            terminal.putCharacter('\u25C6');
        }
    }
    public void moveDown() throws InterruptedException {
        if (y > 28) {
            terminal.moveCursor(x, y);
            terminal.putCharacter('\u25C6');
        } else {
            terminal.moveCursor(x, y);
            terminal.putCharacter(' ');
            y++;
            if (speed.hitObject(this, positionList)) {
                y--;
            }
            if (speed.death(this, positionList)) {
                gameOver();
            }

            terminal.moveCursor(x, y);
            terminal.putCharacter('\u25C6');
        }
    }

    public void gameOver() throws InterruptedException {

        terminal.clearScreen();
        String message1 = "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n";
        String message2 = "███▀▀▀██┼███▀▀▀███┼███▀█▄█▀███┼██▀▀▀\n";
        String message3 = "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼█┼┼┼██┼██┼┼┼\n";
        String message4 = "██┼┼┼▄▄▄┼██▄▄▄▄▄██┼██┼┼┼▀┼┼┼██┼██▀▀▀\n";
        String message5 = "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██┼┼┼\n";
        String message6 = "███▄▄▄██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██▄▄▄\n";
        String message7 = "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n";
        String message8 = "███▀▀▀███┼▀███┼┼██▀┼██▀▀▀┼██▀▀▀▀██▄┼\n";
        String message9 = "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██┼┼┼┼██┼┼┼┼┼██┼\n";
        String message10 = "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██▀▀▀┼██▄▄▄▄▄▀▀┼\n";
        String message11 = "██┼┼┼┼┼██┼┼┼██┼┼█▀┼┼██┼┼┼┼██┼┼┼┼┼██┼\n";
        String message12 = "███▄▄▄███┼┼┼─▀█▀┼┼─┼██▄▄▄┼██┼┼┼┼┼██▄\n";
        String message13 = "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼";
        String message14 = "Your score was " + DrawScreen.counter; //ändra sen till en variabel score




        printText(10,1,message1,terminal);
        printText(10,2,message2,terminal);
        printText(10,3,message3,terminal);
        printText(10,4,message4,terminal);
        printText(10,5,message5,terminal);
        printText(10,6,message6,terminal);
        printText(10,7,message7,terminal);
        printText(10,8,message8,terminal);
        printText(10,9,message9,terminal);
        printText(10,10,message10,terminal);
        printText(10,11,message11,terminal);
        printText(10,12,message12,terminal);
        printText(10,13,message13,terminal);
        printText(10,16,message14,terminal);
        Thread.sleep(10000);
        System.exit(2);

    }
    private static void printText(int x, int y, String message, Terminal
            terminal) {
        for (int i=0;i<message.length();i++)
        {
            terminal.moveCursor(x++, y);
            terminal.putCharacter(message.charAt(i));
        }
    }
}


