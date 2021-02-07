import TicTacToeGames.GameFrame;
import java.util.ArrayList;
import javax.swing.JButton;
import org.junit.Assert;


import org.junit.Test;
import static org.junit.Assert.*;


public class JUnitTestGameFrame {
    GameFrame frame = new GameFrame();
    
    // This method tests whether buttons can added to list or not
    @Test
    public void testAddButton(){
        ArrayList<JButton> buttons = new ArrayList<>();
        frame.addButton(buttons);
        for(int i=0; i<9; ++i){
            if(buttons.get(i) == null){
                Assert.fail("Buttons could NOT added");
            }
        }
        assertTrue(true);
    }
    
    // This method tests whether the horizontal axis is working to win or not
    @Test
    public void testCheckHorizontal(){
        ArrayList<JButton> buttons2 = new ArrayList<>();
        JButton b1 = new JButton();
        JButton b2 = new JButton();
        JButton b3 = new JButton();
        b1.setText("X");
        b2.setText("X");
        b3.setText("X");
        buttons2.add(b1);
        buttons2.add(b2);
        buttons2.add(b3);
        
        ArrayList<String> txtButtons = new ArrayList<>();
        for(int i=0; i<buttons2.size(); ++i){
            txtButtons.add(buttons2.get(i).getText());
        }
        assertTrue(frame.checkHorizontal(txtButtons));
    }
    // This method tests whether the diagonal axis is working to win or not
    @Test
    public void testCheckVertical(){
        JButton b1 = new JButton();
        JButton b2 = new JButton();
        JButton b3 = new JButton();
        JButton b4 = new JButton();
        JButton b5 = new JButton();
        JButton b6 = new JButton();
        JButton b7 = new JButton();
        JButton b8 = new JButton();
        JButton b9 = new JButton();
        b1.setText("X");
        //b2.setText("O");  
        b4.setText("X");
        //b5.setText("X");
        b7.setText("X");
        //b8.setText("X");

        ArrayList<String> txtButtons = new ArrayList<>();
        txtButtons.add(b1.getText());
        txtButtons.add(b2.getText());
        txtButtons.add(b3.getText());
        txtButtons.add(b4.getText());
        txtButtons.add(b5.getText());
        txtButtons.add(b6.getText());
        txtButtons.add(b7.getText());
        txtButtons.add(b8.getText());
        txtButtons.add(b9.getText());
        
        assertTrue(frame.checkVertical(txtButtons));
        //assertFalse(frame.checkDiagonal(txtButtons));
    }
    // This method tests whether the cross axis is working to win or not
    @Test
    public void testCheckDiagonal(){
        JButton b1 = new JButton();
        JButton b2 = new JButton();
        JButton b3 = new JButton();
        JButton b4 = new JButton();
        JButton b5 = new JButton();
        JButton b6 = new JButton();
        JButton b7 = new JButton();
        JButton b8 = new JButton();
        JButton b9 = new JButton();
        b1.setText("X");
        //b3.setText("O");
        b5.setText("X");
        //b7.setText("X");
        b9.setText("X");

        ArrayList<String> txtButtons = new ArrayList<>();
        txtButtons.add(b1.getText());
        txtButtons.add(b2.getText());
        txtButtons.add(b3.getText());
        txtButtons.add(b4.getText());
        txtButtons.add(b5.getText());
        txtButtons.add(b6.getText());
        txtButtons.add(b7.getText());
        txtButtons.add(b8.getText());
        txtButtons.add(b9.getText());
        
        assertTrue(frame.checkDiagonal(txtButtons));
        //assertFalse(frame.checkDiagonal(txtButtons));
    }
}
