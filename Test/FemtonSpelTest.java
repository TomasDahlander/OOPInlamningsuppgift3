import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class FemtonSpelTest {

    FemtonSpel go = new FemtonSpel();

    @Test
    public final void nullFinderTest(){
        go.bricks[0] = new JButton(" ");
        go.bricks[1] = new JButton("1");

        assertEquals(go.nullFinder(0),true);
        assertEquals(go.nullFinder(1),false);
    }

    @Test
    public final void convertArrayToStringTest(){
        go.addLabels();
        assertEquals(go.convertArrayToString(),"123456789101112131415 ");
        assertNotEquals(go.convertArrayToString(),"123456789101112131514 ");
    }

    @Test
    public final void isWinnerTest(){
        go.addLabels();
        System.out.println(go.convertArrayToString());
        System.out.println("123456789101112131415 ");

        assertTrue(go.isWinner());
        assertNotEquals(go.isWinner(), "123456789101112131415");
    }

}
