package TicTacToeGames;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
   
public class GameFrame extends javax.swing.JFrame {
    public String whoseTurn = "X";
    public String PlayersTurn = "";
    public String PlayerOne = "Player One";
    public String PlayerTwo = "Player Two";
    public int CountPlayerOne = 0;
    public int CountPlayerTwo = 0;
    
    public ArrayList<JButton> gameButton = new ArrayList<>();
  
    // This method to add buttons in ArrayList
    public void addButton(ArrayList<JButton> myGameButton){
        myGameButton.add(jButton1);
        myGameButton.add(jButton2);
        myGameButton.add(jButton3);
        myGameButton.add(jButton4);
        myGameButton.add(jButton5);
        myGameButton.add(jButton6);
        myGameButton.add(jButton7);
        myGameButton.add(jButton8);
        myGameButton.add(jButton9);
    }
    // Gets buttons' text part and add ArrayList to get quickly - TO DO
    private void InitializeTxt(ArrayList<String> txtButtons){
        for(int i=0; i<gameButton.size(); ++i) {
            txtButtons.add(gameButton.get(i).getText());
        }
    }
    // Constructor
    public GameFrame() {
        initComponents();
        setSize(600,600);
        setLocationRelativeTo(null);
        getPlayerName();
        setPlayerName();
        setScore();
        addButton(gameButton);
    }
    // This method shows that nobody wins the game which means game will start again
    public void tieGame(){
        ArrayList<String> txtButton = new ArrayList<>();
        int counter = 9; // Number of button
        for(int i=0; i<gameButton.size(); ++i){
            txtButton.add(gameButton.get(i).getText());
            if(!"".equals(txtButton.get(i))){
                counter--;
            }
        }
        if(counter == 0){
                Effects.GameOverEffect(gameButton);
                JOptionPane.showMessageDialog(this,
                        "Game is a tie", 
                        "Tie Game",
                        JOptionPane.INFORMATION_MESSAGE);
                playAgain();
        }
    }
    // This method determines who makes a move X or 0
    private void determineWhoseTurn(){
        if(whoseTurn.equalsIgnoreCase("X")){
            whoseTurn = "O";
        }
        else{
            whoseTurn = "X";
        }
    }
    // This method shows players name on the board
    private void setPlayerName(){
        if(whoseTurn.equalsIgnoreCase("X")){
            PlayersTurn = PlayerOne;
        }
        else{
            PlayersTurn = PlayerTwo;
        }
        jLabel_Score.setText(PlayerOne + " : " + CountPlayerOne + " \t      " 
                            + PlayersTurn + "'s move    " 
                            + PlayerTwo + " : " + CountPlayerTwo);
    } 
    // This method to get players' name from players by using page
    private void getPlayerName(){
        PlayerOne = JOptionPane.showInputDialog(this, 
                            "Player One", 
                            "Player Name", 
                            JOptionPane.INFORMATION_MESSAGE);
        PlayerTwo = JOptionPane.showInputDialog(this, 
                            "Player Two", 
                            "Player Name", 
                            JOptionPane.INFORMATION_MESSAGE);
        
        if(PlayerOne.equals("")){
            PlayerOne = "Player One";
        }
        if(PlayerTwo.equals("")){
            PlayerTwo = "Player Two";
        }
    }
    // This method sets scores
    private void setScore(){
        jLabel_Score.setText(PlayerOne + " : " + CountPlayerOne + " \t      " 
                            + PlayersTurn + "'s move    " 
                            + PlayerTwo + " : " + CountPlayerTwo);
    }
    // This method shows winner X or O 
    public void showWinner(JButton b1, JButton b2, JButton b3){
        boolean winnerX = Effects.winningEffect(b1, b2, b3, gameButton);
        if(winnerX){
            JOptionPane.showMessageDialog(this,
                "" + PlayerOne + " Wins",
                "Winner",
                JOptionPane.INFORMATION_MESSAGE);
            CountPlayerOne++;
        }else{
            JOptionPane.showMessageDialog(this,
                "" + PlayerTwo + " Wins",
                "Winner",
                JOptionPane.INFORMATION_MESSAGE);
            CountPlayerTwo++;
        }
        playAgain();
    }
    //This method arranges game to play again
    private void playAgain(){
        for(int i=0; i<gameButton.size(); ++i){
            gameButton.get(i).setText("");
        }
        setScore();
        Effects.clearEffect(gameButton);
    }
    // These methods to determine who's winner X or O
    // <editor-fold defaultstate="collapsed" desc=" Determine Winner">
    // This method dtermines who is winner X or O 
    private void chooseWinner(){
        ArrayList<String> txtGameButtons = new ArrayList<>();
        InitializeTxt(txtGameButtons);// Gets buttons' text part to check X and O
        //HORIZANTAL AND DIAGONAL X and O TOGETHER
        if(txtGameButtons.get(0).equals("X") && txtGameButtons.get(1).equals("X") && txtGameButtons.get(2).equals("X")
           && txtGameButtons.get(5).equals("X") && txtGameButtons.get(8).equals("X") ||
           txtGameButtons.get(0).equals("O") && txtGameButtons.get(1).equals("O") && txtGameButtons.get(2).equals("O")
           && txtGameButtons.get(5).equals("O") && txtGameButtons.get(8).equals("O")){
                checkHorizontal(txtGameButtons);
        }
        if(txtGameButtons.get(0).equals("X") && txtGameButtons.get(1).equals("X") && txtGameButtons.get(2).equals("X")
           && txtGameButtons.get(3).equals("X") && txtGameButtons.get(6).equals("X") ||
           txtGameButtons.get(0).equals("O") && txtGameButtons.get(1).equals("O") && txtGameButtons.get(2).equals("O")
           && txtGameButtons.get(3).equals("O") && txtGameButtons.get(6).equals("O")){
                checkHorizontal(txtGameButtons);
        }
        if(txtGameButtons.get(0).equals("X") && txtGameButtons.get(3).equals("X") && txtGameButtons.get(6).equals("X")
           && txtGameButtons.get(7).equals("X") && txtGameButtons.get(8).equals("X") ||
           txtGameButtons.get(0).equals("O") && txtGameButtons.get(3).equals("O") && txtGameButtons.get(6).equals("O")
           && txtGameButtons.get(7).equals("O") && txtGameButtons.get(8).equals("O")){
                checkVertical(txtGameButtons);
        }
        if(txtGameButtons.get(2).equals("X") && txtGameButtons.get(5).equals("X") && txtGameButtons.get(8).equals("X")
           && txtGameButtons.get(6).equals("X") && txtGameButtons.get(7).equals("X") ||
           txtGameButtons.get(2).equals("O") && txtGameButtons.get(5).equals("O") && txtGameButtons.get(8).equals("O")
           && txtGameButtons.get(6).equals("O") && txtGameButtons.get(7).equals("0")){
                checkVertical(txtGameButtons);
        }
        checkHorizontal(txtGameButtons);
        checkVertical(txtGameButtons);
        checkDiagonal(txtGameButtons);
    }
    // This method checks horizontal axis to determine who's winner X or O
    public boolean checkHorizontal(ArrayList<String> txtGameButtons){ 
        if(txtGameButtons.get(0).equals("X") && txtGameButtons.get(1).equals("X") && txtGameButtons.get(2).equals("X") ||
           txtGameButtons.get(0).equals("O") && txtGameButtons.get(1).equals("O") && txtGameButtons.get(2).equals("O")){
                showWinner(jButton1, jButton2, jButton3);
                return true;
        }
        if(txtGameButtons.get(3).equals("X") && txtGameButtons.get(4).equals("X") && txtGameButtons.get(5).equals("X") ||
           txtGameButtons.get(3).equals("O") && txtGameButtons.get(4).equals("O") && txtGameButtons.get(5).equals("O")){
                showWinner(jButton4, jButton5, jButton6);
                return true;
        }
        if(txtGameButtons.get(6).equals("X") && txtGameButtons.get(7).equals("X") && txtGameButtons.get(8).equals("X") ||
           txtGameButtons.get(6).equals("O") && txtGameButtons.get(7).equals("O") && txtGameButtons.get(8).equals("O")){
                showWinner(jButton7, jButton8, jButton9); 
                return true;
        }
        return false;
    }
    // This method checks diagonal axis to determine who's winner X or O
    public boolean checkVertical(ArrayList<String> txtGameButtons){  
        if(txtGameButtons.get(0).equals("X") && txtGameButtons.get(3).equals("X") && txtGameButtons.get(6).equals("X") ||
           txtGameButtons.get(0).equals("O") && txtGameButtons.get(3).equals("O") && txtGameButtons.get(6).equals("O")){
                showWinner(jButton1, jButton4, jButton7);    
                return true;
        }
        if(txtGameButtons.get(1).equals("X") && txtGameButtons.get(4).equals("X") && txtGameButtons.get(7).equals("X") ||
           txtGameButtons.get(1).equals("O") && txtGameButtons.get(4).equals("O") && txtGameButtons.get(7).equals("O")){
                showWinner(jButton2, jButton5, jButton8);    
                return true;
        }
        if(txtGameButtons.get(2).equals("X") && txtGameButtons.get(5).equals("X") && txtGameButtons.get(8).equals("X") ||
           txtGameButtons.get(2).equals("O") && txtGameButtons.get(5).equals("O") && txtGameButtons.get(8).equals("O")){
                showWinner(jButton3, jButton6, jButton9);   
                return true;
        }
        return false;
    }
    // This method checks cross axis to determine who's winner X or O
    public boolean checkDiagonal(ArrayList<String> txtGameButtons){
        if(txtGameButtons.get(0).equals("X") && txtGameButtons.get(4).equals("X") && txtGameButtons.get(8).equals("X") ||
           txtGameButtons.get(0).equals("O") && txtGameButtons.get(4).equals("O") && txtGameButtons.get(8).equals("O")){
                showWinner(jButton1, jButton5, jButton9);
                return true;
        }
        if(txtGameButtons.get(2).equals("X") && txtGameButtons.get(4).equals("X") && txtGameButtons.get(6).equals("X") ||
           txtGameButtons.get(2).equals("O") && txtGameButtons.get(4).equals("O") && txtGameButtons.get(6).equals("O")){
                showWinner(jButton3, jButton5, jButton7);
                return true;
        }
        return false;
    }
    // </editor-fold>
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_Score = new javax.swing.JLabel();
        jPanel_GridHolder = new javax.swing.JPanel();
        Panel_1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Panel_2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        Panel_3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        Panel_4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        Panel_5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        Panel_6 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        Panel_7 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        Panel_8 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        Panel_9 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        ResetScoresButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic-Tac-Toe");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel_Score.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Score.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel_Score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Score.setText("jLabel1");
        jPanel1.add(jLabel_Score, java.awt.BorderLayout.PAGE_END);

        jPanel_GridHolder.setBackground(new java.awt.Color(0, 102, 102));
        jPanel_GridHolder.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        Panel_1.setBackground(new java.awt.Color(255, 255, 255));
        Panel_1.setLayout(new java.awt.BorderLayout());

        jButton1.setFont(new java.awt.Font("Arial Black", 1, 75)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Panel_1.add(jButton1, java.awt.BorderLayout.CENTER);

        jPanel_GridHolder.add(Panel_1);

        Panel_2.setBackground(new java.awt.Color(255, 255, 255));
        Panel_2.setLayout(new java.awt.BorderLayout());

        jButton2.setFont(new java.awt.Font("Arial Black", 1, 75)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Panel_2.add(jButton2, java.awt.BorderLayout.CENTER);

        jPanel_GridHolder.add(Panel_2);

        Panel_3.setBackground(new java.awt.Color(255, 255, 255));
        Panel_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_3.setLayout(new java.awt.BorderLayout());

        jButton3.setFont(new java.awt.Font("Arial Black", 1, 75)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Panel_3.add(jButton3, java.awt.BorderLayout.CENTER);

        jPanel_GridHolder.add(Panel_3);

        Panel_4.setBackground(new java.awt.Color(255, 255, 255));
        Panel_4.setLayout(new java.awt.BorderLayout());

        jButton4.setFont(new java.awt.Font("Arial Black", 1, 75)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Panel_4.add(jButton4, java.awt.BorderLayout.CENTER);

        jPanel_GridHolder.add(Panel_4);

        Panel_5.setBackground(new java.awt.Color(255, 255, 255));
        Panel_5.setLayout(new java.awt.BorderLayout());

        jButton5.setFont(new java.awt.Font("Arial Black", 1, 75)); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Panel_5.add(jButton5, java.awt.BorderLayout.CENTER);

        jPanel_GridHolder.add(Panel_5);

        Panel_6.setBackground(new java.awt.Color(255, 255, 255));
        Panel_6.setLayout(new java.awt.BorderLayout());

        jButton6.setFont(new java.awt.Font("Arial Black", 1, 75)); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Panel_6.add(jButton6, java.awt.BorderLayout.CENTER);

        jPanel_GridHolder.add(Panel_6);

        Panel_7.setBackground(new java.awt.Color(255, 255, 255));
        Panel_7.setLayout(new java.awt.BorderLayout());

        jButton7.setFont(new java.awt.Font("Arial Black", 1, 75)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        Panel_7.add(jButton7, java.awt.BorderLayout.CENTER);

        jPanel_GridHolder.add(Panel_7);

        Panel_8.setBackground(new java.awt.Color(255, 255, 255));
        Panel_8.setLayout(new java.awt.BorderLayout());

        jButton8.setFont(new java.awt.Font("Arial Black", 1, 75)); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        Panel_8.add(jButton8, java.awt.BorderLayout.CENTER);

        jPanel_GridHolder.add(Panel_8);

        Panel_9.setBackground(new java.awt.Color(255, 255, 255));
        Panel_9.setLayout(new java.awt.BorderLayout());

        jButton9.setFont(new java.awt.Font("Arial Black", 1, 75)); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        Panel_9.add(jButton9, java.awt.BorderLayout.CENTER);

        jPanel_GridHolder.add(Panel_9);

        jPanel1.add(jPanel_GridHolder, java.awt.BorderLayout.CENTER);

        ResetScoresButton.setBackground(java.awt.Color.red);
        ResetScoresButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        ResetScoresButton.setText("RESET SCORES");
        ResetScoresButton.setSelected(true);
        ResetScoresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetScoresButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ResetScoresButton, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // Those are buttons and their actions when touched
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setText(whoseTurn);
        if(whoseTurn.equalsIgnoreCase("X")){
            jButton1.setForeground(Color.red);
        }
        else{
            jButton1.setForeground(Color.blue);
        }
        jButton1.setEnabled(false);
        determineWhoseTurn();
        chooseWinner();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jButton2.setText(whoseTurn);
        if(whoseTurn.equalsIgnoreCase("X")){
            jButton2.setForeground(Color.red);
        }
        else{
            jButton2.setForeground(Color.blue);
        }
        jButton2.setEnabled(false);
        determineWhoseTurn();
        chooseWinner();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton3.setText(whoseTurn);
        if(whoseTurn.equalsIgnoreCase("X")){
            jButton3.setForeground(Color.red);
        }
        else{
            jButton3.setForeground(Color.blue);
        }
        jButton3.setEnabled(false);
        determineWhoseTurn();
        chooseWinner();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton4.setText(whoseTurn);
        if(whoseTurn.equalsIgnoreCase("X")){
            jButton4.setForeground(Color.red);
        }
        else{
            jButton4.setForeground(Color.blue);
        }
        jButton4.setEnabled(false);
        determineWhoseTurn();
        chooseWinner();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jButton5.setText(whoseTurn);
        if(whoseTurn.equalsIgnoreCase("X")){
            jButton5.setForeground(Color.red);
        }
        else{
            jButton5.setForeground(Color.blue);
        }
        jButton5.setEnabled(false);
        determineWhoseTurn();
        chooseWinner();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jButton6.setText(whoseTurn);
        if(whoseTurn.equalsIgnoreCase("X")){
            jButton6.setForeground(Color.red);
        }
        else{
            jButton6.setForeground(Color.blue);
        }
        jButton6.setEnabled(false);
        determineWhoseTurn();
        chooseWinner();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jButton7.setText(whoseTurn);
        if(whoseTurn.equalsIgnoreCase("X")){
            jButton7.setForeground(Color.red);
        }
        else{
            jButton7.setForeground(Color.blue);
        }
        jButton7.setEnabled(false);
        determineWhoseTurn();
        chooseWinner();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jButton8.setText(whoseTurn);
        if(whoseTurn.equalsIgnoreCase("X")){
            jButton8.setForeground(Color.red);
        }
        else{
            jButton8.setForeground(Color.blue);
        }
        jButton8.setEnabled(false);
        determineWhoseTurn();
        chooseWinner();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jButton9.setText(whoseTurn);
        if(whoseTurn.equalsIgnoreCase("X")){
            jButton9.setForeground(Color.red);
        }
        else{
            jButton9.setForeground(Color.blue);
        }
        jButton9.setEnabled(false);
        determineWhoseTurn();
        chooseWinner();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton9ActionPerformed
    // This button resets all scores 
    private void ResetScoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetScoresButtonActionPerformed
        CountPlayerOne = 0;
        CountPlayerTwo = 0;
        setScore();
    }//GEN-LAST:event_ResetScoresButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Panel_1;
    public javax.swing.JPanel Panel_2;
    public javax.swing.JPanel Panel_3;
    public javax.swing.JPanel Panel_4;
    public javax.swing.JPanel Panel_5;
    public javax.swing.JPanel Panel_6;
    public javax.swing.JPanel Panel_7;
    public javax.swing.JPanel Panel_8;
    public javax.swing.JPanel Panel_9;
    public javax.swing.JButton ResetScoresButton;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    public javax.swing.JButton jButton7;
    public javax.swing.JButton jButton8;
    public javax.swing.JButton jButton9;
    public javax.swing.JLabel jLabel_Score;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel_GridHolder;
    // End of variables declaration//GEN-END:variables
}
