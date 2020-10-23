import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FemtonSpel extends JFrame implements ActionListener {

    JButton newgame = new JButton("New Game");
    JPanel gamePanel = new JPanel();
    JPanel topPanel = new JPanel();
    JButton[] bricks = new JButton[16];
    String empty = " ";

    public FemtonSpel(){
        setTitle("Fifteen - It's in the Game");
        topPanel.setLayout(new FlowLayout());
        newgame.setSize(50,25);
        newgame.setBackground(new Color(173, 192, 203));
        topPanel.add(newgame,SwingConstants.CENTER);

        gamePanel.setLayout(new GridLayout(4,4));
        add(topPanel,BorderLayout.NORTH);
        add(gamePanel,BorderLayout.CENTER);

        addLabels();
      //  shuffle(); // Kommentera bort denna shuffle för redovisning av vinst
        addLabelsToFrame();
        newgame.addActionListener(this);
        for(int i = 0; i < bricks.length; i++){
            bricks[i].addActionListener(this);
        }

        setLocation(300,200);
        setSize(350,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addLabels(){
        for(int i = 0; i < bricks.length; i++){
            if(i == 15){
                bricks[15] = new JButton(empty);
                bricks[15].setBorder(new BevelBorder(BevelBorder.LOWERED));
                bricks[i].setFont(new Font("Monospaced", Font.BOLD, 20));
                bricks[i].setBackground(Color.PINK);
                bricks[i].setVisible(false);
            }
            else {
                bricks[i] = new JButton("" + (i + 1));
                bricks[i].setBorder(new BevelBorder(BevelBorder.RAISED));
                bricks[i].setFont(new Font("Monospaced", Font.BOLD, 20));
                bricks[i].setBackground(Color.PINK);
            }
        }
    }

    public void shuffle(){
        Random nr = new Random();
        for(int i = 0; i < bricks.length; i++){
            bricks[i].setBorder(new BevelBorder(BevelBorder.RAISED));
            bricks[i].setVisible(true);
            int tmpIndex = nr.nextInt(bricks.length);
            String tmp = bricks[tmpIndex].getText();
            bricks[tmpIndex].setText(bricks[i].getText());
            bricks[i].setText(tmp);
        }
        for (int i = 0; i < bricks.length; i++) {
            if(bricks[i].getText().equals(empty)){
                bricks[i].setVisible(false);
                break;
            }
        }
    }

    public void addLabelsToFrame(){
        for(int i = 0; i < bricks.length; i++){
            gamePanel.add(bricks[i]);

        }
    }

    public void checkAction(int pressedIndex, int checkIndex1, int checkIndex2){
        boolean ok = false;
        int changeIndex = 0;
        if(nullFinder(checkIndex1)) {ok = true; changeIndex = checkIndex1;}
        else if(nullFinder(checkIndex2)) {ok = true; changeIndex = checkIndex2;}

        if(ok){
            changeValue(pressedIndex, changeIndex);
            if(isWinner()) declareWinner();
        }
    }

    public void checkAction(int pressedIndex, int checkIndex1, int checkIndex2, int checkIndex3){
        boolean ok = false;
        int changeIndex = 0;
        if(nullFinder(checkIndex1)) {ok = true; changeIndex = checkIndex1;}
        else if(nullFinder(checkIndex2)) {ok = true; changeIndex = checkIndex2;}
        else if(nullFinder(checkIndex3)) {ok = true; changeIndex = checkIndex3;}

        if(ok){
            changeValue(pressedIndex, changeIndex);
            if(isWinner()) declareWinner();
        }
    }

    public void checkAction(int pressedIndex, int checkIndex1, int checkIndex2, int checkIndex3, int checkIndex4){
        boolean ok = false;
        int changeIndex = 0;
        if(nullFinder(checkIndex1)) {ok = true; changeIndex = checkIndex1;}
        else if(nullFinder(checkIndex2)) {ok = true; changeIndex = checkIndex2;}
        else if(nullFinder(checkIndex3)) {ok = true; changeIndex = checkIndex3;}
        else if(nullFinder(checkIndex4)) {ok = true; changeIndex = checkIndex4;}

        if(ok){
            changeValue(pressedIndex, changeIndex);
            if(isWinner()) declareWinner();
        }
    }

    public boolean nullFinder(int index){
        return bricks[index].getText().equals(empty);
    }

    public void changeValue(int clickedIndex, int nullIndex) {
        bricks[nullIndex].setText(bricks[clickedIndex].getText());
        bricks[nullIndex].setBorder(new BevelBorder(BevelBorder.RAISED));
        bricks[nullIndex].setVisible(true);

        bricks[clickedIndex].setText(empty);
        bricks[clickedIndex].setBorder(new BevelBorder(BevelBorder.LOWERED));
        bricks[clickedIndex].setVisible(false);

    }

    public String convertArrayToString() {
        String result = "";
        for(int i = 0; i < bricks.length; i++){
            result += bricks[i].getText();
        }
        return result;
    }

    public boolean isWinner(){
        if(convertArrayToString().equals("123456789101112131415 ")) return true;
        if(convertArrayToString().equals(" 123456789101112131415")) return true;
        else return false;
    }

    public void declareWinner(){
        JOptionPane.showMessageDialog(null, null,("WINNER!"),
                                    JOptionPane.PLAIN_MESSAGE, new ImageIcon("src\\images\\victorysweet.gif"));
        reset();
        shuffle();
    }

    public void reset(){
        for(int i = 0; i < bricks.length; i++){
            if(i == 15) bricks[15].setText(empty);
            else bricks[i].setText(""+(i+1));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newgame){
            reset();
            shuffle();
        }
        // ActionListeners for each button
        if(e.getSource() == bricks[0]) {
            checkAction(0,1,4);
        } else if(e.getSource() == bricks[1]) {
            checkAction(1,0,2,5);
        } else if(e.getSource() == bricks[2]) {
            checkAction(2,1,3,6);
        } else if(e.getSource() == bricks[3]) {
            checkAction(3,2,7);
        } else if(e.getSource() == bricks[4]) {
            checkAction(4,0,5,8);
        } else if(e.getSource() == bricks[5]) {
            checkAction(5,1,4,6,9);
        } else if(e.getSource() == bricks[6]) {
            checkAction(6,2,5,7,10);
        } else if(e.getSource() == bricks[7]) {
            checkAction(7,3,6,11);
        } else if(e.getSource() == bricks[8]) {
            checkAction(8,4,9,12);
        } else if(e.getSource() == bricks[9]) {
            checkAction(9,5,8,10,13);
        } else if(e.getSource() == bricks[10]) {
            checkAction(10,6,9,11,14);
        } else if(e.getSource() == bricks[11]) {
            checkAction(11,7,10,15);
        } else if(e.getSource() == bricks[12]) {
            checkAction(12,8,13);
        } else if(e.getSource() == bricks[13]) {
            checkAction(13,9,12,14);
        } else if(e.getSource() == bricks[14]) {
            checkAction(14,10,13,15);
        } else if(e.getSource() == bricks[15]) {
            checkAction(15,11,14);
        }
    }

    public static void main(String[] args) {
        FemtonSpel start = new FemtonSpel();
    }
}

//TODO DESGIN
