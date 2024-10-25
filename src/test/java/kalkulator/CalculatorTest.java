package kalkulator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
//dodawanie
	@Test
	public void testAddOne(){
		// Arrange
		// sut = System Under Test
		Calculator sut = new Calculator();
		// Act
		sut.add(1);
		// Assert
		assertEquals("0+1 = 1", 1, sut.getState());
	}

	@Test
    public void testAddLargeNumber(){
        Calculator sut = new Calculator();
        sut.add(Integer.MAX_VALUE);
        assertEquals("0 + Integer.MAX_VALUE", Integer.MAX_VALUE, sut.getState());
    }

    @Test
    public void testAddOverflow(){
        Calculator sut = new Calculator();
        sut.add(Integer.MAX_VALUE);
        sut.add(1);
        assertEquals("Integer.MAX_VALUE + 1", Integer.MIN_VALUE, sut.getState());
    }

	@Test
    public void testAddZero(){
        Calculator sut = new Calculator();
        sut.add(0);
        assertEquals("0 + 0 = 0", 0, sut.getState());
    }

    @Test
    public void testAddNegativeNumber(){
        Calculator sut = new Calculator();
        sut.add(-5);
        assertEquals("0 + (-5) = -5", -5, sut.getState());
    }
//mnozenie
	    @Test
    public void testMultOneByTwo(){
        Calculator sut = new Calculator();
        sut.setState(1);
        sut.mult(2);
        assertEquals("1 * 2 = 2", 2, sut.getState());
    }

    @Test
    public void testMultByZero(){
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.mult(0);
        assertEquals("5 * 0 = 0", 0, sut.getState());
    }

    @Test
    public void testMultByOne(){
        Calculator sut = new Calculator();
        sut.setState(7);
        sut.mult(1);
        assertEquals("7 * 1 = 7", 7, sut.getState());
    }

    @Test
    public void testMultNegative(){
        Calculator sut = new Calculator();
        sut.setState(3);
        sut.mult(-2);
        assertEquals("3 * -2 = -6", -6, sut.getState());
    }

    @Test
    public void testMultByLargeNumber(){
        Calculator sut = new Calculator();
        sut.setState(2);
        sut.mult(Integer.MAX_VALUE / 2);
        assertEquals("2 * (Integer.MAX_VALUE / 2)", Integer.MAX_VALUE - 1, sut.getState());
    }

    @Test
    public void testMultOverflow(){
        Calculator sut = new Calculator();
        sut.setState(Integer.MAX_VALUE);
        sut.mult(2);
        assertEquals("Integer.MAX_VALUE * 2", -2, sut.getState());
    }
}
