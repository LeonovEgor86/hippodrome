import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HippodromeTest {

    @Test
    public void hippodromeConstructorParamNull(){
        assertThrows(IllegalArgumentException.class,()->new Hippodrome(null));
    }

    @Test
    public void hippodromeConstructorParamNullMessage(){
        Exception ex = assertThrows(IllegalArgumentException.class,()->new Hippodrome(null));
        assertEquals("Horses cannot be null.", ex.getMessage());
    }

    @Test
    public void hippodromeConstructorParamEmpty(){
        assertThrows(IllegalArgumentException.class, ()->new Hippodrome((new ArrayList<>())));
    }

    @Test
    public void hippodromeConstructorParamEmptyMessage(){
        Exception ex = assertThrows(IllegalArgumentException.class,()->new Hippodrome(new ArrayList<>()));
        assertEquals("Horses cannot be empty.", ex.getMessage());
    }

    @Test
    public void  hippodromeGetHorsesReturnList(){
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("Horse"+i,i));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses());
    }

    @Test
    public void hippodromeMove(){
        List<Horse> horses  = new ArrayList<Horse>();
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();

        for(Horse horse: horses){
           verify(horse).move();
        }
    }

    @Test
    public void hipodromeGetWiner(){
        List<Horse> horses  = new ArrayList<Horse>();
        horses.add(new Horse("Horse1",1, 1));
        horses.add(new Horse("Horse2",2, 2));
        horses.add(new Horse("Horse3",3, 3));
        horses.add(new Horse("Horse4",4, 4));
        horses.add(new Horse("Horse5",5, 5));

        Hippodrome hippodrome = new Hippodrome(horses);

        assertSame(horses.get(4), hippodrome.getWinner());

    }
}