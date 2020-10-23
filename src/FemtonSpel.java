import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FemtonSpel extends JFrame implements ActionListener {

    JButton newgame = new JButton("Nytt spel");
    JPanel panel = new JPanel();
    JButton[] labels = new JButton[16];
    String empty = " ";


    public FemtonSpel(){
        panel.setLayout(new GridLayout(4,4));
        add(newgame,BorderLayout.NORTH);
        newgame.setHorizontalAlignment(SwingConstants.CENTER);
        add(panel,BorderLayout.CENTER);
        addLabels();
        shuffle();
        addLabelsToFrame();

        newgame.addActionListener(this);
        for(int i = 0; i < labels.length; i++){
            labels[i].addActionListener(this);
        }

        setLocation(200,200);
        setSize(350,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addLabels(){
        for(int i = 0; i < labels.length; i++){
            if(i == 15){
                labels[15] = new JButton(empty);
                labels[15].setBorder(new BevelBorder(BevelBorder.RAISED));
                labels[i].setFont(new Font("Monospaced", Font.BOLD, 20));
                labels[i].setBackground(Color.PINK);
            }
            else {
                labels[i] = new JButton("" + (i + 1));
                labels[i].setBorder(new BevelBorder(BevelBorder.RAISED));
                labels[i].setFont(new Font("Monospaced", Font.BOLD, 20));
                labels[i].setBackground(Color.PINK);
            }
        }
    }

    public void shuffle(){
        Random nr = new Random();
        for(int i = 0; i <labels.length; i++){
            labels[i].setBorder(new BevelBorder(BevelBorder.RAISED));
            labels[i].setVisible(true);
            int tmpIndex = nr.nextInt(labels.length);
            String tmp = labels[tmpIndex].getText();
            labels[tmpIndex].setText(labels[i].getText());
            labels[i].setText(tmp);
        }
        for (int i = 0; i < labels.length; i++) {
            if(labels[i].getText().equals(empty)){
                labels[i].setVisible(false);
                break;
            }
        }
    }

    public void addLabelsToFrame(){
        for(int i = 0; i < labels.length; i++){
            panel.add(labels[i]);

        }
    }

    public void checkAction(int pressedIndex, int checkIndex1, int checkIndex2){
        boolean ok = false;
        int changeIndex = 0;
        if(nullFinder(checkIndex1)) {ok = true; changeIndex = checkIndex1;}
        else if(nullFinder(checkIndex2)) {ok = true; changeIndex = checkIndex2;}

        if(ok){
            changeValue(pressedIndex, changeIndex);
            if(isWinner()){
                JOptionPane.showMessageDialog(null,"Grattis!\nDu klara spelet!");
                reset();
                shuffle();
            }
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
            if(isWinner()){
                JOptionPane.showMessageDialog(null,"Grattis!\nDu klara spelet!");
                reset();
                shuffle();
            }
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
            if(isWinner()){
                JOptionPane.showMessageDialog(null,"Grattis!\nDu klara spelet!");
                reset();
                shuffle();
            }
        }
    }

    public boolean nullFinder(int index){
        return labels[index].getText().equals(empty);
    }

    public void changeValue(int clickedIndex, int nullIndex) {
        labels[nullIndex].setText(labels[clickedIndex].getText());
        labels[nullIndex].setBorder(new BevelBorder(BevelBorder.RAISED));
        labels[nullIndex].setVisible(true);

        labels[clickedIndex].setText(empty);
        labels[clickedIndex].setBorder(new BevelBorder(BevelBorder.LOWERED));
        labels[clickedIndex].setVisible(false);

    }

    public String convertArrayToString() {
        String result = "";
        for(int i = 0; i < labels.length; i++){
            result += labels[i].getText();
        }
        return result;
    }

    public boolean isWinner(){
        if(convertArrayToString().equals("123456789101112131415 ")) return true;
        if(convertArrayToString().equals(" 123456789101112131415")) return true;
        else return false;
    }

    public void reset(){
        for(int i = 0; i < labels.length; i++){
            if(i == 15) labels[15].setText(empty);
            else labels[i].setText(""+(i+1));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newgame){
            reset();
            shuffle();
        }
        // ActionListeners for each button
//        if(e.getSource() == labels[0]) {
//            checkAction(0,1,4);
//        }
        labels[0] = (e1) -> checkAction(0,1,4);
        labels[0].addActionListener(e -> System.out.println("Handled by Lambda listener"));
        labels[0].addActionListener(e1 -> checkAction(0,1,4));

        if(e.getSource() == labels[1]) {
            checkAction(1,0,2,5);
        }
        if(e.getSource() == labels[2]) {
            checkAction(2,1,3,6);
        }
        if(e.getSource() == labels[3]) {
            checkAction(3,2,7);
        }
        if(e.getSource() == labels[4]) {
            checkAction(4,0,5,8);
        }
        if(e.getSource() == labels[5]) {
            checkAction(5,1,4,6,9);
        }
        if(e.getSource() == labels[6]) {
            checkAction(6,2,5,7,10);
        }
        if(e.getSource() == labels[7]) {
            checkAction(7,3,6,11);
        }
        if(e.getSource() == labels[8]) {
            checkAction(8,4,9,12);
        }
        if(e.getSource() == labels[9]) {
            checkAction(9,5,8,10,13);
        }
        if(e.getSource() == labels[10]) {
            checkAction(10,6,9,11,14);
        }
        if(e.getSource() == labels[11]) {
            checkAction(11,7,10,15);
        }
        if(e.getSource() == labels[12]) {
            checkAction(12,8,13);
        }
        if(e.getSource() == labels[13]) {
            checkAction(13,9,12,14);
        }
        if(e.getSource() == labels[14]) {
            checkAction(14,10,13,15);
        }
        if(e.getSource() == labels[15]) {
            checkAction(15,11,14);
        }
    }

    public static void main(String[] args) {
        FemtonSpel start = new FemtonSpel();
    }
}

//TODO DESGIN
