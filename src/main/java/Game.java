import javax.swing.*;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Game implements ActionListener {
    Board board;
    JLabel curPlayText;
    JPanel butPanel;
    ArrayList<JButton> buttons;
    HashMap<Integer, Optional<Character>> marksOnBoard;
    boolean win;
    char whoTurn;
    Optional<Character> winner;
    ArrayList<Integer> winInds;

    Game() {
        board = new Board();
        win = false;

        marksOnBoard = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            marksOnBoard.put(i, Optional.empty());
        }
        winInds = new ArrayList<>();

    }

    //set the current player on the panel above the buttons and the current player at the beginning
    public void setCurrentPlayer(char curr) {
        //player X starts first
        curPlayText = new JLabel();
        curPlayText.setText("Player " + curr);
        whoTurn = curr;
        curPlayText.setPreferredSize(new Dimension(50, 50));
        curPlayText.setBackground(Color.BLACK);
        curPlayText.setOpaque(true);
        curPlayText.setForeground(Color.WHITE);
        curPlayText.setHorizontalAlignment(JLabel.CENTER);
        board.getFrame().add(curPlayText, BorderLayout.NORTH);
    }

    // set up the Buttons on the board at the beginning of the game
    public void setButtons() {
        butPanel = new JPanel();
        butPanel.setLayout(new GridLayout(3, 3));
        buttons = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            buttons.add(new JButton());
        }

        for (JButton x : buttons
        ) {
            butPanel.add(x);
            x.addActionListener(this);
        }
        board.getFrame().add(butPanel, BorderLayout.CENTER);
        board.getFrame().setVisible(true);


    }

    /**
     * check if there is a win or a draw. Return true if win and false otherwise
     * set then win to true and get the winner
     */

    public boolean check() {
        if (marksOnBoard.get(0).isPresent() && marksOnBoard.get(1).isPresent() && marksOnBoard.get(2).isPresent()) {
            if (marksOnBoard.get(0).get() == marksOnBoard.get(1).get() && marksOnBoard.get(1).get() == marksOnBoard.get(2).get()) {
                win = true;
                winner = marksOnBoard.get(0);
                winInds.add(0);
                winInds.add(1);
                winInds.add(2);
                return true;
            }
        }

        if (marksOnBoard.get(0).isPresent() && marksOnBoard.get(3).isPresent() && marksOnBoard.get(6).isPresent()) {
            if (marksOnBoard.get(0).get() == marksOnBoard.get(3).get() && marksOnBoard.get(3).get() == marksOnBoard.get(6).get()) {
                win = true;
                winner = marksOnBoard.get(0);
                winInds.add(0);
                winInds.add(3);
                winInds.add(6);
                return true;
            }
        }

        if (marksOnBoard.get(0).isPresent() && marksOnBoard.get(4).isPresent() && marksOnBoard.get(8).isPresent()) {
            if (marksOnBoard.get(0).get() == marksOnBoard.get(4).get() && marksOnBoard.get(4).get() == marksOnBoard.get(8).get()) {
                win = true;
                winner = marksOnBoard.get(0);
                winInds.add(0);
                winInds.add(4);
                winInds.add(8);
                return true;
            }
        }

        if (marksOnBoard.get(1).isPresent() && marksOnBoard.get(4).isPresent() && marksOnBoard.get(7).isPresent()) {
            if (marksOnBoard.get(1).get() == marksOnBoard.get(4).get() && marksOnBoard.get(4).get() == marksOnBoard.get(7).get()) {
                win = true;
                winner = marksOnBoard.get(1);
                winInds.add(1);
                winInds.add(4);
                winInds.add(7);
                return true;
            }
        }
        if (marksOnBoard.get(2).isPresent() && marksOnBoard.get(5).isPresent() && marksOnBoard.get(8).isPresent()) {
            if (marksOnBoard.get(2).get() == marksOnBoard.get(5).get() && marksOnBoard.get(5).get() == marksOnBoard.get(8).get()) {
                win = true;
                winner = marksOnBoard.get(2);
                winInds.add(2);
                winInds.add(5);
                winInds.add(8);
                return true;
            }
        }

        if (marksOnBoard.get(6).isPresent() && marksOnBoard.get(7).isPresent() && marksOnBoard.get(8).isPresent()) {
            if (marksOnBoard.get(6).get() == marksOnBoard.get(7).get() && marksOnBoard.get(8).get() == marksOnBoard.get(6).get()) {
                win = true;
                winner = marksOnBoard.get(6);
                winInds.add(6);
                winInds.add(7);
                winInds.add(8);
                return true;
            }
        }

        if (marksOnBoard.get(3).isPresent() && marksOnBoard.get(4).isPresent() && marksOnBoard.get(5).isPresent()) {
            if (marksOnBoard.get(3).get() == marksOnBoard.get(4).get() && marksOnBoard.get(4).get() == marksOnBoard.get(5).get()) {
                win = true;
                winner = marksOnBoard.get(3);
                winInds.add(3);
                winInds.add(4);
                winInds.add(5);
                return true;
            }
        }

        if (marksOnBoard.get(6).isPresent() && marksOnBoard.get(4).isPresent() && marksOnBoard.get(2).isPresent()) {
            if (marksOnBoard.get(6).get() == marksOnBoard.get(4).get() && marksOnBoard.get(4).get() == marksOnBoard.get(2).get()) {
                win = true;
                winner = marksOnBoard.get(6);
                winInds.add(2);
                winInds.add(4);
                winInds.add(6);
                return true;
            }
        }

        return false;
    }

    /**
     * return true if there  is no mark set at this spot and no o/w
     */
    public boolean isFreeAt(int index) {
        return marksOnBoard.get(index).isEmpty();
    }

    /**
     * return true if the board is full of marks
     */
    public boolean isFull() {
        for (Optional<Character> i : marksOnBoard.values()
        ) {
            if (i.isEmpty()) return false;
        }
        return true;
    }

    /**
     * return true if the game ends
     */

    public boolean isClosed() {
        return isFull() || win;
    }

    /**
     * set the mark c at the given index
     */

    public boolean setMarkAt(int index, char c) {
        if (isFreeAt(index) && !isClosed()) {
            marksOnBoard.put(index, Optional.of(c));
            return true;
        }
        return false;
    }

    /**
     * set the player the current
     */
    public void setPlayer(char curr) {
        curPlayText.setText("Player " + curr);
        whoTurn = curr;
    }

    public void winEffect(ArrayList<Integer> arr) {
        buttons.get(arr.get(0)).setBackground(Color.green);
        buttons.get(arr.get(1)).setBackground(Color.green);
        buttons.get(arr.get(2)).setBackground(Color.green);
    }

    /**
     * the logic of the game
     */

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // there are only at most 9 moves so

        //when clicking on the button the for loop is for getting the index of the button that has been pressed
        for (int i = 0; i < 9; i++) {
            // if end then players must not perform any actions
            if (isClosed()) break;

            if (actionEvent.getSource() == buttons.get(i)) {
                if (whoTurn == 'X') {
                    if (isFreeAt(i)) {
                        buttons.get(i).setFont(new Font("MV ", Font.BOLD, 120));
                        buttons.get(i).setForeground(Color.RED);
                        buttons.get(i).setText("X");
                        setMarkAt(i, 'X');
                        if (check()) {
                            curPlayText.setText(winner.get().toString().concat(" wins"));
                            winEffect(winInds);
                            break;
                        }
                        if (isClosed() && !win) {
                            curPlayText.setText("Draw");
                            break;
                        }
                        if (!win) {
                            setPlayer('O');
                        }

                    }
                } else if (whoTurn == 'O') {
                    if (isFreeAt(i)) {
                        buttons.get(i).setFont(new Font("MV ", Font.BOLD, 120));
                        buttons.get(i).setForeground(Color.BLUE);
                        buttons.get(i).setText("O");
                        setMarkAt(i, 'O');
                        if (check()) {
                            curPlayText.setText(winner.get().toString().concat(" wins"));
                            winEffect(winInds);
                            break;
                        }
                        if (isClosed()) {
                            curPlayText.setText("Draw");
                            break;
                        }
                        if (!win) {
                            setPlayer('X');
                        }
                    }
                }

            }
        }
    }
}
