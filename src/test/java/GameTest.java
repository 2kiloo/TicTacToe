import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    HashMap<Integer, Optional<Character>> markEmpty;
    HashMap<Integer, Optional<Character>> markWinX;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        markEmpty = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            markEmpty.put(i, Optional.empty());
        }


        markWinX = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            markWinX.put(i, Optional.of('X'));
            markWinX.put(i, Optional.of('X'));
            markWinX.put(i, Optional.of('X'));
        }    }

    /**
     * tests for the marks
     **/
    @org.junit.jupiter.api.Test
    void isFullBoardEmpty() {
        for (int i = 0; i < 9; i++) {
            assertTrue(markEmpty.get(i).isEmpty());
        }
    }

    @org.junit.jupiter.api.Test
    void winX() {
        for (int i = 0; i < 3; i++) {
            assertTrue(markWinX.get(i).get().equals('X'));
        }
    }
}