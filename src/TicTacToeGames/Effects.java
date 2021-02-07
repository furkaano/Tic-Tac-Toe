package TicTacToeGames;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

public class Effects {
    // This method sets buttons from disable to enable to play again
    public static void enableButtons(ArrayList<JButton> gameButton){
        for(int i=0; i<gameButton.size(); ++i){
            gameButton.get(i).setEnabled(true);
        }
    }
    // This method shows effects when X or O wins the game 
    public static boolean winningEffect(JButton b1, JButton b2, JButton b3, ArrayList<JButton> myGameButton){
        enableButtons(myGameButton);
        // Set Back-Ground Color
        b1.setBackground(Color.green);
        b2.setBackground(Color.green);
        b3.setBackground(Color.green);
        // Set Fore-Ground Color
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        b3.setForeground(Color.white);
        
        String one = b1.getText();
        String two = b2.getText();
        String three = b3.getText();
        
        if(one.equals("X") && two.equals("X") && three.equals("X")){
            return true;
        }
        else{
            return false;
        }
    }
    
    // This method shows effects when no one wins the game
    public static void GameOverEffect(ArrayList<JButton> myGameButton){
        enableButtons(myGameButton);
        for(int i=0; i<myGameButton.size(); ++i){
            myGameButton.get(i).setBackground(Color.red); // set buttons back-ground color
            myGameButton.get(i).setForeground(Color.white); // set buttons fore-ground color
        }    
    }
    
    // This method clears winning effects to continue game
    public static void clearEffect(ArrayList<JButton> myGameButton){
        for(int i=0; i<myGameButton.size(); ++i){
            myGameButton.get(i).setBackground(Color.LIGHT_GRAY);
        }
    }
}
