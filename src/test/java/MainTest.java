import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @Disabled
    @Timeout(22)
    public void mainTest(){

        try {
            Main.main(new String[1]);
        }
        catch (Exception ex){
            throw new RuntimeException();
        }

    }


}