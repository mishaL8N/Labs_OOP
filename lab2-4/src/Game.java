import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game {
    public static byte numbTurn = 0;
    Move position = new Move();
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame  = new JFrame("Java TicTayToe");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(3,3));
                final Game game = new Game();
                final JButton[] buttons = new JButton[9];
                for (int i = 0;i<9;i++){
                    final int idx = i;
                    JButton button = new JButton();
                    buttons[i] = button;
                    button.setPreferredSize(new Dimension(100,100));
                    button.setFont(new Font(null, Font.PLAIN, 100));
                    button.setOpaque(true);
                    button.addMouseListener(new MouseListener() {
                        public void mousePressed(MouseEvent e) {}
                        public void mouseReleased(MouseEvent e) {}
                        public void mouseEntered(MouseEvent e) {}
                        public void mouseExited(MouseEvent e) {}

                        @Override
                        public void mouseClicked(MouseEvent e) {
                            numbTurn++;
                            button.setText("" + game.position.turn);
                            game.move(idx);
                            if (!game.position.gameEnd()){
                                numbTurn++;
                                int best = game.position.bestMove();
                                buttons[best].setText("" + game.position.turn);
                                game.move(best);
                            }
                            if (game.position.gameEnd()){
                                String message = "";
                                long finish = System.currentTimeMillis();
                                if (game.position.win('x')){
                                    message = "You won!";
                                }else if (game.position.win('0')){
                                    message = "Computer won!";
                                }else message = "Draw!";
                                JOptionPane.showMessageDialog(null,message  +"\nNumber of turns : " + numbTurn +
                                        "\nTime of game : " + (finish-start)/1000 + "s." );
                            }
                        }
                    });
                    frame.add(button);
                }
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    protected void move(int idx){
        position = position.move(idx);
    }
}