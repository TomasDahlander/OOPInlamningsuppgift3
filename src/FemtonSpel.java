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

    public void changeValue(int clickedIndex, int nullIndex) {
        labels[nullIndex].setText(labels[clickedIndex].getText());
        labels[clickedIndex].setText("");

        // Null index vill ha clicked index
        // Clicked index ska bli null/""
    }


    @Override
    public void actionPerformed(ActionEvent e) {




        if(e.getSource() == newgame){
            reset();
            shuffle();
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
