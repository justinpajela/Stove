package stove;

public class Burner {
	public enum Temperature {
        HOT("VERY HOT"), COLD("COLD"), WARM("WARM");

        private String description;

        Temperature(String description) {
            this.description = description;
        }
        public String getDescription() {
    	return description;
        }
	}
	Setting setting;
	Temperature temp;
	private int timer;
	private final int duration = 2;
	public Burner() {
		this.temp = Temperature.COLD;
		this.setting = Setting.OFF;
		this.timer = duration;
	}
	public void plusButton() {
		switch (setting) {
        case OFF:
            setting = Setting.LOW;
            break;
        case LOW:
            setting = Setting.MEDIUM;
            break;
        case MEDIUM:
            setting = Setting.HIGH;
            break;
        case HIGH:
            break;
    }
    timer = duration;
	}

	public void minusButton() {
		switch (setting) {
        case OFF:
            break;
        case LOW:
            setting = Setting.OFF;
            break;
        case MEDIUM:
            setting = Setting.LOW;
            break;
        case HIGH:
            setting = Setting.MEDIUM;
            break;
    }
    timer = duration;
	}

	public void updateTemperature() {
		if (timer > 0) {
            timer = timer - 1;
        }

        if (timer == 0) {
            switch (setting) {
                case OFF:
                    temp = Temperature.COLD;
                    break;
                case LOW:
                    temp = Temperature.WARM;
                    break;
                case MEDIUM: //
                    temp = Temperature.HOT; 
                    break;
                case HIGH:
                    temp = Temperature.HOT;
                    break;
            }
        }
    }
}
	


