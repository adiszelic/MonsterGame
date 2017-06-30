import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import javafx.geometry.Pos;

import java.nio.charset.Charset;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawScreen {
    static public boolean game = true;
    static int counter = 0;
    static Terminal terminal = TerminalFacade.createTerminal(System.in,
            System.out, Charset.forName("UTF8"));
    static Board board = new Board(100, 29);
    static List<Position> positionList = new ArrayList<>();
    static Player player = new Player(47, 18, terminal, positionList); //Utgångspunkt player
    static public Speed speed = new Speed();
    static public Position pos;
    static List<Position> monsterList = new ArrayList<>();

    public static int setX() {
        Random rand = new Random();
        int max = 100;
        int min = 0;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }



    public static void start() throws Exception {
        terminal.setCursorVisible(false);
        terminal.enterPrivateMode();



        Monsters monster1 = new Monsters(setX(), 7, terminal, positionList, player);
        Monsters monster2 = new Monsters(setX(), 12,terminal,positionList, player);
        Monsters monster3 = new Monsters(setX(), 15,terminal,positionList, player);

        List<Monsters> monsterList = new ArrayList<>();
        for (int i=0; i<10; i++){
            monsterList.add(new Monsters(setX(), 7, terminal, positionList, player));
        }

        for (board.x = 0; board.x < 100; board.x++) {
            positionList.add(new Position(100, board.x, '❤'));
            positionList.add(new Position(board.x, 29, '^'));
            positionList.add(new Position(0, board.x, '❤'));
            positionList.add(new Position(board.x, 0, '❤'));
        }

        for (board.x = 20; board.x < 25; board.x++) {
            for (board.y = 20; board.y < 30; board.y++) {
                terminal.applyForegroundColor(Terminal.Color.GREEN);
                positionList.add(new Position(board.x, board.y, 'X'));
            }
        }
        for (board.x = 70; board.x < 75; board.x++) {
            for (board.y = 15; board.y < 30; board.y++) {
                positionList.add(new Position(board.x, board.y, 'X'));
            }
        }
        for (board.x = 35; board.x < 40; board.x++) {
            for (board.y = 27; board.y < 30; board.y++) {
                positionList.add(new Position(board.x, board.y, 'X'));
            }
        }

        for (board.x = 25; board.x < 35; board.x++) {
            for (board.y = 50; board.y < 60; board.y++) {

                positionList.add(new Position(board.x, board.y, '^'));
            }
        }

        for (board.x = 75; board.x < 99; board.x++) {
            for (board.y = 50; board.y < 60; board.y++) {
                positionList.add(new Position(board.x, board.y, '^'));
            }
        }

        for (board.x = 45; board.x < 50; board.x++) {
            board.y = 20;
            terminal.applyForegroundColor(Terminal.Color.GREEN);
            positionList.add(new Position(board.x, board.y, '-'));
        }
        for (board.x = 60; board.x < 65; board.x++) {
            board.y = 24;
            positionList.add(new Position(board.x, board.y, '-'));
        }

        for (board.x = 27; board.x < 32; board.x++) {
            board.y = 24;
            positionList.add(new Position(board.x, board.y, '-'));
        }
        for (board.x = 75; board.x < 82; board.x++) {
            board.y = 15;
            positionList.add(new Position(board.x, board.y, '-'));
        }
        for (board.x = 57; board.x < 62; board.x++) {
            board.y = 17;
            positionList.add(new Position(board.x, board.y, '-'));
        }

        for (board.x = 91; board.x < 97; board.x++) {
            board.y = 20;
            positionList.add(new Position(board.x, board.y, '-'));
        }
        for (board.x = 75; board.x < 82; board.x++) {
            board.y = 24;
            positionList.add(new Position(board.x, board.y, '-'));
        }
        for (Position position : positionList) {
            if (position.getObjectType() == '^') {
                terminal.applyForegroundColor(Terminal.Color.RED);
            } else if (position.getObjectType() == 'X') {
                terminal.applyForegroundColor(Terminal.Color.GREEN);
            } else {
                terminal.applyForegroundColor(100, 200, 190);
            }
            terminal.moveCursor(position.getX(), position.getY());
            terminal.putCharacter(position.getObjectType());
        }
        int counter2 = 0;


        while (game) {
            for (Monsters monster : monsterList) {
                if ((monster.x == player.x) && (monster.y == player.y)) {
                    game = false;

                    player.gameOver();
                    break;
                }
            }
            //Wait for a key to be pressed
            Key key;
            do {
                Thread.sleep(5);
                key = terminal.readInput();
                counter2++;
                if (counter2 % 50 == 0) {
                    player.moveDown();
                    int numberOfEnemies = monsterList.size();
                    for (int i = numberOfEnemies-1; i >= 0; i--) {
                        Monsters monster = monsterList.get(i);
                        monster.fallingEnemy();
                        if (monster.isDead){
                            monsterList.set(i,new Monsters(setX(), 7, terminal, positionList, player));

                        }
                    }
                }
            }

            while (key == null);
            switch (key.getKind()) {

                case NormalKey: {
                    switch (key.getCharacter()) {
                        case '8':
                            player.jumpUp();
                            counter++;
                            break;
                        case '4':
                            player.moveLeft();
                            counter++;
                            break;
                        case '6':
                            player.moveRight();
                            counter++;
                            break;
                        case '7':
                            player.jumpUpLeft();
                            counter++;
                            break;
                        case '9':
                            player.jumpUpRight();
                            counter++;
                            break;
                    }
                }

            }
        }
    }

}
