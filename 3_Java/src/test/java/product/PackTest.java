package product;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class PackTest {

    @Test(expected = IllegalArgumentException.class)
    public  void constructorTestEx(){
        Pack object = new Pack("",-15);
    }

    @Test
    public  void constructorTest(){
        Pack object = new Pack("dsds",15);

        assertNotNull(object);
    }
}
