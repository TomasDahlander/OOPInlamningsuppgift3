import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FemtonSpel extends JFrame implements ActionListener {

    JButton newgame = new JButton("Nytt spel");
    JPanel panel = new JPanel();
    JButton[] labels = new JButton[16];


    public FemtonSpel(){
        panel.setLayout(new GridLayout(4,4));
        add(newgame,BorderLayout.NORTH);
        newgame.setHorizontalAlignment(SwingConstants.CENTER);
        add(panel,BorderLayout.CENTER);
        addLabels();
        shuffle();
        addLabelsToFrame();
        newgame.addActionListener(this);

        setLocation(200,200);
        setSize(350,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addLabelsToFrame(){
        for(int i = 0; i < labels.length; i++){
            panel.add(labels[i]);

        }
    }

    public void addLabels(){
        for(int i = 0; i < labels.length; i++){
            if(i == 15){
                labels[15] = new JButton("");
                labels[15].setBorder(new EtchedBorder());
            }
            else {
                labels[i] = new JButton("" + (i + 1));
                labels[i].setBorder(new EtchedBorder());
            }
        }
    }

    public void shuffle(){
        Random nr = new Random();
        for(int i = 0; i <16; i++){
            int tmpIndex = nr.nextInt(16);
            JButton tmpLabel = labels[tmpIndex]; // skapar en extra referens till index 7
            labels[tmpIndex]=labels[i]; // sätts till index 0
            labels[i]=tmpLabel; // sätts till index 7
        }
    }

    public void reset(){
        for(int i = 0; i < labels.length; i++){
            if(i == 15) labels[15].setText("");
            else labels[i].setText(""+(i+1));
        }
    }

    public boolean nullFinder(int index){
        return labels[index].getText().equals("");
    }

    public void changeValue(int clickedIndex, int nullIndex) {
        labels[nullIndex].setText(labels[clickedIndex].getText());
        labels[clickedIndex].setText("");
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newgame){
            reset();
            shuffle();
        }
        // ActionListeners for each button
        if(e.getSource() == labels[0]) {
            checkAction(0,1,4);
        }
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


//TODO Skapa if satser för lyssnaren
//TODO Skapa metod för att leta efter en knapp med tom text
//TODO Skapa metod att byta textvärden i två st knappar
//TODO Skapa metod för att läsa av om spelet är vunnit
//TODO Skapa samlingsmetod för att ta utföra ett drag eller ej "Actioncall"
//TODO DESGIN
