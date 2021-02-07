import TicTacToeGames.Effects;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import org.junit.Test;
import static org.junit.Assert.*;


public class JUnitTestEffects{
    // This test method tests winning effect method from effects class
    // We check whether the method can change the color of the buttons or not
    @Test
    public void testWinningEffect(){
        ArrayList<JButton> buttons = new ArrayList<>();
        JButton b1 = new JButton();
        JButton b2 = new JButton();
        JButton b3 = new JButton();
        b1.setText("X");
        b2.setText("X");
        b3.setText("X");
        
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        
        assertTrue(Effects.winningEffect(b1, b2, b3, buttons));
    }
    // This test method tests game-over effect method from effects class
    // We check whether the method can change the color of the buttons or not
    @Test
    public void testGameOverEffect(){
        // Implementation new button list to compare other one which will come from effects class
        ArrayList<JButton> buttons = new ArrayList<>();
        JButton b1 = new JButton();// Expected
        b1.setBackground(Color.red);
        b1.setForeground(Color.white);
        buttons.add(b1);
      
        ArrayList<JButton> buttons2 = new ArrayList<>();
        JButton b12 = new JButton();// Actual
        buttons2.add(b12);
        
        Effects.GameOverEffect(buttons2);
        assertEquals(buttons.get(0).getBackground(), buttons2.get(0).getBackground());
    }
    // This test method tests buttons are enabled or not
    @Test
    public void TestEnableButtons(){
        // Implementation new button to compare other one which will come from effects class
        ArrayList<JButton> buttons = new ArrayList<>();
        JButton b1 = new JButton(); // Expected 
        b1.setEnabled(true);
        buttons.add(b1);
        
        ArrayList<JButton> buttons2 = new ArrayList<>();
        JButton b12 = new JButton(); // Actual
        buttons2.add(b12);
        
        Effects.enableButtons(buttons2);
        assertEquals(buttons.get(0).isEnabled(), buttons2.get(0).isEnabled());
    }
    // This test method tests clear effect method from effects class
    // We check whether the method can change the color of the buttons or not
    @Test
    public void TestClearEffect(){
        // Implementation new button list to compare other one which will come from effects class
        ArrayList<JButton> buttons = new ArrayList<>();
        JButton b1 = new JButton(); // Expected
        b1.setBackground(Color.LIGHT_GRAY);
        buttons.add(b1);
        
        ArrayList<JButton> buttons2 = new ArrayList<>();
        JButton b12 = new JButton(); // Actual
        buttons2.add(b12);
        
        Effects.clearEffect(buttons2);
        assertEquals(buttons.get(0).getBackground(), buttons2.get(0).getBackground());
    }  
}
