import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


class HorseTest {

    @Test
    public void horseConstructorFirstParamIsNull(){

        assertThrows(IllegalArgumentException.class,
                ()->new Horse(null,1d,1d));
    }

    @Test
    public void horseConstructorFirstParamIsNullMessage(){
        Throwable ex = assertThrows(IllegalArgumentException.class,
                ()->new Horse(null,1d,1d));
        assertEquals("Name cannot be null.",ex.getMessage());
    }

    @ParameterizedTest
    @ValueSource (strings = {"", "\t","\n"})
    public void horseConstructorFirstParamIsEnpty(String arg){
        assertThrows(IllegalArgumentException.class,
                ()->new Horse(arg,1d,1d));
    }

    @ParameterizedTest
    @ValueSource (strings = {"", " ","   "})
    public void horseConstructorFirstParamIsEnptyMessage(String arg){
        Throwable ex = assertThrows(IllegalArgumentException.class,
                ()->new Horse(arg,1d,1d));
        assertEquals("Name cannot be blank.",ex.getMessage());
    }

    @Test
    public void horseConstructorSecondParam(){
        assertThrows(IllegalArgumentException.class,
                ()-> new Horse("Horse",-1d,1d));
    }

    @Test
    public void horseConstructorSecondParamMessage(){
        Throwable ex = assertThrows(IllegalArgumentException.class,
                ()-> new Horse("Horse",-1d,1d));
        assertEquals("Speed cannot be negative.",ex.getMessage());
    }

    @Test
    public void horseConstructorThirdParam(){
        assertThrows(IllegalArgumentException.class,
                ()-> new Horse("Horse",1d,-1d));
    }

    @Test
    public void horseConstructorThirdParamMessage(){
        Throwable ex = assertThrows(IllegalArgumentException.class,
                ()-> new Horse("Horse",1d,-1d));
        assertEquals("Distance cannot be negative.",ex.getMessage());
    }

    @Test
    public void horseGetNameReturnConstructorFirstParam(){
        String param = "Horse";
        Horse horse = new Horse(param,1d,1d);
        assertEquals(param,horse.getName());
    }

    @Test
    public void horseGetSpeedReturnConstructorSecondParam(){
        double param = 1d;
        Horse horse = new Horse("Horse",param, 1);
        assertEquals(param, horse.getSpeed());
    }

    @Test
    public void horseGetDistanceReturnThirdConstructorParam(){
        double param = 1d;
        Horse horse = new Horse("Horse",1d, param);
        assertEquals(param,horse.getDistance());
    }

    @Test
    public void horseGetDistanceReturnZeroConstructorTwoParam(){
        Horse horse = new Horse("Horse", 1d);
        assertEquals(0, horse.getDistance());
    }


    @Test
    public void horseMoveCallsGetRandomWhithParam(){
        try(MockedStatic<Horse> horseMockedStatic = Mockito.mockStatic(Horse.class)){
            Horse horse = new Horse("Horse", 1d);
            horse.move();
            horseMockedStatic.verify(()->Horse.getRandomDouble(0.2, 0.9));
        }
    }

    @Test
    void horseMoveDistanceFormula() {
        try (MockedStatic<Horse> horseMockedStatic = Mockito.mockStatic(Horse.class)) {
            horseMockedStatic.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(0.5);
            Horse horse = new Horse("Horse", 1.0);
            horse.move();

            assertEquals(0.5, horse.getDistance());
        }
    }





}