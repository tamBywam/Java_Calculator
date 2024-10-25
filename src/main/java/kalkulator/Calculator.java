package kalkulator;

public class Calculator {
	private int state = 0;

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
            throw new IllegalArgumentException("Dzielenie przez 0 nie jest dozwolone.");
        }
        state /= value;
    }
}
