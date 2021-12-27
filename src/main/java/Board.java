import javax.swing.*;
import java.awt.*;
public class Board extends JFrame {
    private JFrame frame;
/***
 * this class is for creating the board for the game
 * */

    Board() {
        //set up the board
        frame = new JFrame();
        frame.setTitle("TicTacToe");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());



    }
    public JFrame getFrame (){
        return this.frame;
    }

}
