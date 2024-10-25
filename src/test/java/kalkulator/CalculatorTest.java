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
    public void testAddMinValue() {
        Calculator sut = new Calculator();
        sut.setState(Integer.MIN_VALUE);
        sut.add(-1);
        assertEquals("Integer.MIN_VALUE + (-1)", Integer.MAX_VALUE, sut.getState());
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
        assertEquals("3 * Integer.MAX_VALUE", Integer.MAX_VALUE - 1, sut.getState());
    }

    @Test
    public void testMultOverflow(){
        Calculator sut = new Calculator();
        sut.setState(Integer.MAX_VALUE);
        sut.mult(2);
        assertEquals("Integer.MAX_VALUE * 2", -2, sut.getState());
    }
//odejmowanie
    @Test
    public void testSubPositive() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.sub(3);
        assertEquals("10 - 3 = 7", 7, sut.getState());
    }

    @Test
    public void testSubNegative() {
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.sub(-2);
        assertEquals("5 - (-2) = 7", 7, sut.getState());
    }

    @Test
    public void testSubToZero() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.sub(10);
        assertEquals("10 - 10 = 0", 0, sut.getState());
    }

    @Test
    public void testSubFromZero() {
        Calculator sut = new Calculator();
        sut.sub(5);
        assertEquals("0 - 5 = -5", -5, sut.getState());
    }

    @Test
    public void testSubFromMinValue() {
        Calculator sut = new Calculator();
        sut.setState(Integer.MIN_VALUE);
        sut.sub(1);
        assertEquals("Integer.MIN_VALUE - 1", Integer.MAX_VALUE, sut.getState());
    }

    @Test
    public void testSubFromMaxValue() {
        Calculator sut = new Calculator();
        sut.setState(Integer.MAX_VALUE);
        sut.sub(1);
        assertEquals("Integer.MAX_VALUE - 1", Integer.MAX_VALUE - 1, sut.getState());
    }
//dzielenie
    @Test
    public void testDivByPositive() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.div(2);
        assertEquals("10 / 2 = 5", 5, sut.getState());
    }

    @Test
    public void testDivByPositive2() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.div(2);
        assertEquals("11 / 2 = 5", 5, sut.getState());
    }

    @Test
    public void testDivByNegative() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.div(-2);
        assertEquals("10 / -2 = -5", -5, sut.getState());
    }

    @Test
    public void testDivByOne() {
        Calculator sut = new Calculator();
        sut.setState(7);
        sut.div(1);
        assertEquals("7 / 1 = 7", 7, sut.getState());
    }

    @Test
    public void testDivResultZero() {
        Calculator sut = new Calculator();
        sut.setState(1);
        sut.div(3);
        assertEquals("1 / 3 = 0 (integer division)", 0, sut.getState());
    }

    @Test
    public void testDivMinValueByNegativeOne() {
        Calculator sut = new Calculator();
        sut.setState(Integer.MIN_VALUE);
        sut.div(-1);
        assertEquals("Integer.MIN_VALUE / -1", Integer.MIN_VALUE, sut.getState());
    }

    @Test
    public void testDivMaxValueByMaxValue() {
        Calculator sut = new Calculator();
        sut.setState(Integer.MAX_VALUE);
        sut.div(Integer.MAX_VALUE);
        assertEquals("Integer.MAX_VALUE / Integer.MAX_VALUE = 1", 1, sut.getState());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivByZero() {
        Calculator sut = new Calculator();
        sut.div(0);
    }
//testy dla operacji z pamieci
    @Test
    public void testSaveToMemory() {
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.saveToMemory();
        assertEquals("Memory should be 5", 5, sut.getMemory());
    }

    @Test
    public void testReadFromMemory() {
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.saveToMemory();
        sut.setState(0);
        sut.readFromMemory();
        assertEquals("State should be 5", 5, sut.getState());
    }

    @Test
    public void testClearMemory() {
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.saveToMemory();
        sut.clearMemory();
        assertEquals("Memory should be 0", 0, sut.getMemory());
    }

    @Test
    public void testMemoryPersistsAfterOperations() {
        Calculator sut = new Calculator();
        sut.setState(8);
        sut.saveToMemory();
        sut.add(10);
        sut.setState(0);
        sut.readFromMemory();
        assertEquals("Memory retains value 8", 8, sut.getState());
    }

    @Test
    public void testMemoryIndependentFromState() {
        Calculator sut = new Calculator();
        sut.setState(20);
        sut.saveToMemory();
        sut.add(5);
        assertEquals("Memory should still be 20 after state change", 20, sut.getMemory());
    }

    @Test
    public void testAddFromMemory() {
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.saveToMemory();
        sut.setState(3);
        sut.addFromMemory();
        assertEquals("3 + 5 = 8", 8, sut.getState());
    }

    @Test
    public void testSubFromMemory() {
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.saveToMemory();
        sut.setState(3);
        sut.subFromMemory();
        assertEquals("3 - 5 = -2", -2, sut.getState());
    }

    @Test
    public void testMultByMemory() {
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.saveToMemory();
        sut.setState(3);
        sut.multByMemory();
        assertEquals("3 * 5 = 15", 15, sut.getState());
    }

    @Test
    public void testDivByMemory() {
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.saveToMemory();
        sut.setState(15);
        sut.divByMemory();
        assertEquals("15 / 5 = 3", 3, sut.getState());
    }
}
