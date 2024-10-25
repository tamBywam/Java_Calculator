package kalkulator;

public class Calculator {
	private int state = 0;
	private int memory = 0;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void add(int value){
		state += value;
	}

	public void mult(int value){
		state *= value;
	}

    public void sub(int value) {
        state -= value;
    }

    public void div(int value) {
        if (value == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        state /= value;
    }
//zapisywanie i odczytywanie z pamieci
	public void saveToMemory() {
		memory = state;
	}

	public void readFromMemory() {
		state = memory;
	}

	public void clearMemory() {
		memory = 0;
	}

	public int getMemory() {
		return memory;
	}
//przykladowe dzialania
	public void addFromMemory() {
		state += memory;
	}

	public void subFromMemory() {
		state -= memory;
	}

	public void multByMemory() {
		state *= memory;
	}

	public void divByMemory() {
		if (memory == 0) {
			throw new IllegalArgumentException("Division by zero is not allowed.");
		}
		state /= memory;
	}
}
