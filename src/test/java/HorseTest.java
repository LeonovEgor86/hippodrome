import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    public void HorseConstructorFirstParamIsNull(){

        assertThrows(IllegalArgumentException.class,
                ()->new Horse(null,1d,1d));
    }

    @Test
    public void HorseConstructorFirstParamIsNullMessage(){
        Throwable ex = assertThrows(IllegalArgumentException.class,
                ()->new Horse(null,1d,1d));
        assertEquals("Name cannot be null.",ex.getMessage());
    }

    @ParameterizedTest
    @ValueSource (strings = {"", " ","   "})
    public void HorseConstructorFirstParamIsEnpty(String arg){
        assertThrows(IllegalArgumentException.class,
                ()->new Horse(arg,1d,1d));
    }

    @ParameterizedTest
    @ValueSource (strings = {"", " ","   "})
    public void HorseConstructorFirstParamIsEnptyMessage(String arg){
        Throwable ex = assertThrows(IllegalArgumentException.class,
                ()->new Horse(arg,1d,1d));
        assertEquals("Name cannot be blank.",ex.getMessage());
    }

    @Test
    public void HorseConstructorSecondParam(){
        assertThrows(IllegalArgumentException.class,
                ()-> new Horse("Alfa",-1d,1d));
    }

    @Test
    public void HorseConstructorSecondParamMessage(){
        Throwable ex = assertThrows(IllegalArgumentException.class,
                ()-> new Horse("Alfa",-1d,1d));
        assertEquals("Speed cannot be negative.",ex.getMessage());
    }

    @Test
    public void HorseConstructorThirdParam(){
        assertThrows(IllegalArgumentException.class,
                ()-> new Horse("Alpha",1d,-1d));
    }

    @Test
    public void HorseConstructorThirdParamMessage(){
        Throwable ex = assertThrows(IllegalArgumentException.class,
                ()-> new Horse("Alpha",1d,-1d));
        assertEquals("Distance cannot be negative.",ex.getMessage());
    }

    @Test
    public void HorseGetNameReturnConstructorFirstParam(){
        String param = "Alpha";
        Horse horse = new Horse(param,1d,1d);
        assertEquals(param,horse.getName());
    }

    @Test
    public void HorseGetSpeedReturnConstructorSecondParam(){
        double param = 1d;
        Horse horse = new Horse("Alpha",param, 1);
        assertEquals(param, horse.getSpeed());
    }

    @Test
    public void HorseGetDistanceReturnThirdConstructorParam(){
        double param = 1d;
        Horse horse = new Horse("Alpha",1d, param);
        assertEquals(param,horse.getDistance());
    }

    @Test
    public void HorseGetDistanceReturnZeroCostructorTwoParam(){
        Horse horse = new Horse("Alpha", 1d);
        assertEquals(0, horse.getDistance());
    }
}