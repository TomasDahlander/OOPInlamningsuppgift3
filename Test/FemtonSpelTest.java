import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class FemtonSpelTest {

    FemtonSpel go = new FemtonSpel();

    @Test
    public final void nullFinderTest(){
        go.labels[0] = new JButton("");
        go.labels[1] = new JButton("1");

        assertEquals(go.nullFinder(0),true);
        assertEquals(go.nullFinder(1),false);
    }



}
