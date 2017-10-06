import javax.swing.*;
import java.awt.event.*;

/*
 * Name: Christopher Lee
 * netID: clee244
 *
 * General: creates the menu items and button
 * Uses Example Code: MenuTest
 */

public class Menu extends JFrame{

    public Menu() {
        // set up File menu and its menu items
        JMenu fileMenu = new JMenu( "File" );
        fileMenu.setMnemonic( 'F' );

        // set up About... menu item
        JMenuItem aboutItem = new JMenuItem( "About..." );
        aboutItem.setMnemonic( 'A' );
        fileMenu.add( aboutItem );
        aboutItem.addActionListener(

                new ActionListener() {  // anonymous inner class

                    // display message dialog when user selects About...
                    public void actionPerformed( ActionEvent event )
                    {
                        JOptionPane.showMessageDialog( Menu.this,
                                "Name: Christopher Lee\nWhen: 10/3/17" +
                                        "\nWhy: The 2nd programming assignment for CS 342",
                                "About", JOptionPane.PLAIN_MESSAGE );
                    }

                }  // end anonymous inner class

        ); // end call to addActionListener

        // set up Help... menu item
        JMenuItem helpItem = new JMenuItem( "Help..." );
        aboutItem.setMnemonic( 'H' );
        fileMenu.add( helpItem );
        aboutItem.addActionListener(

                new ActionListener() {  // anonymous inner class

                    // display message dialog when user selects About...
                    public void actionPerformed( ActionEvent event )
                    {
                        JOptionPane.showMessageDialog( Menu.this,
                                "How to play: Click on any number next to the blank space to switch them.\n" +
                                        "To win you must get the buttons into numerical order.\n" +
                                        "Description: About - Gives creator info. Help - gives game info." +
                                        " Exit - quits the program.",
                                "Help", JOptionPane.PLAIN_MESSAGE );
                    }

                }  // end anonymous inner class

        ); // end call to addActionListener

        // set up Exit menu item
        JMenuItem exitItem = new JMenuItem( "Exit" );
        exitItem.setMnemonic( 'x' );
        fileMenu.add( exitItem );
        exitItem.addActionListener(

                new ActionListener() {  // anonymous inner class

                    // terminate application when user clicks exitItem
                    public void actionPerformed( ActionEvent event )
                    {
                        System.exit( 0 );
                    }

                }  // end anonymous inner class

        ); // end call to addActionListener

        JMenuBar bar = new JMenuBar();
        setJMenuBar( bar );
        bar.add( fileMenu );
    }
}
