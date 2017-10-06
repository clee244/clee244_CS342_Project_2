import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/*
 * Name: Christopher Lee
 * NetID: clee244
 * About: CS342 Project 2
 * General: The Main class where you play the game as well as:
 * Shuffle the board, determine if playable, etc
 * Uses Example code: GridDemoLayout
 */

public class Board extends JFrame implements ActionListener{
    private JButton buttons[]; //button list
    private final String Value[] = //List of button names
            {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", ""};
    private Container container; //Holder of the game
    private GridLayout grid;
    private int index; //index value of buttons


    //constructor for the Board
    public Board() {
        super("15 Puzzle");
        Menu menu = new Menu();

        //specify variable container
        container = getContentPane();

        //initialize the 4x4 board
        grid = new GridLayout(5, 4, 5, 5);
        container.setLayout(grid);

        //create our buttons
        buttons = new JButton[Value.length];

        for (int numButton = 0; numButton < 16; numButton++) {
            buttons[numButton] = new JButton(Value[numButton]);

            buttons[numButton].addActionListener(this);
            buttons[numButton].putClientProperty("index", new Integer(numButton));
            container.add(buttons[numButton], BorderLayout.CENTER);
        }
        container.add(menu.getJMenuBar(), BorderLayout.PAGE_START);

        //shuffle the board keeping index 16 and until true.
        do {
            shuffle();
        } while (isSolvable() != true);

        //Display the Game
        //setLayout(grid);
        setSize(600, 600);
        setVisible(true);
    }

    //Checks the inversions and returns true is even and false if odd
    public boolean isSolvable() {
        int countInversions = 0;
        for (int i = 0; i < Value.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((int) buttons[j].getClientProperty("index") + 1 > (int) buttons[i].getClientProperty("index") + 1) {
                    countInversions++;
                }
            }
        }
        if(countInversions%2 == 0)
            return true;
        else
            return false;
    }

    //Shuffle every button except the empty one.
    private void shuffle() {
        // don't include the blank space in the shuffle, leave it
        // in the home position
        Random rand = new Random();

        int n = Value.length - 1;
        while (n > 1) {
            int r = rand.nextInt(n--);
            String tmp = buttons[r].getText();
            buttons[r].setText(buttons[n].getText());
            buttons[n].setText(tmp);
        }
    }

    //If clicked, checks if next to blank button and switch.
    public void actionPerformed( ActionEvent event )
    {
        JButton button = (JButton) event.getSource(); //Find the button clicked
        index = (int)button.getClientProperty("index"); //get the index of that button in the container

        //Move the buttons while checking if changing columns or falling out of bounds
        if(index - 4 >= 0 && buttons[index - 4].getText() == ""){
            String s = buttons[index].getText();
            buttons[index].setText(buttons[index - 4].getText());
            buttons[index - 4].setText(s);
        }
        else if(index + 4 < 16 && buttons[index + 4].getText() == ""){
            String s = buttons[index].getText();
            buttons[index].setText(buttons[index + 4].getText());
            buttons[index + 4].setText(s);
        }
        else if(index - 1 >= 0 && buttons[index - 1].getText() == "" &&
                buttons[index - 1].getY() == buttons[index].getY()){
            String s = buttons[index].getText();
            buttons[index].setText(buttons[index - 1].getText());
            buttons[index - 1].setText(s);
        }
        else if(index + 1 < 16 && buttons[index + 1].getText() == "" &&
                buttons[index + 1].getY() == buttons[index].getY()){
            String s = buttons[index].getText();
            buttons[index].setText(buttons[index + 1].getText());
            buttons[index + 1].setText(s);
        }
    }

    public static void main( String args[] )
    {
        Board application = new Board();
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}
