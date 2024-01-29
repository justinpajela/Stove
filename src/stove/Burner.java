/*
 * 
 * Authors: Justin Pajela and Brody Perlick
 * Date:January 29, 2024
 * Collaborators: None
 * Outside Sources: None
 */
package stove;


public class Burner {
	public enum Temperature {
        FIRE("VERY HOT"),HOT("CAREFUL"), COLD("COLD"), WARM("WARM");

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
	public final static int duration = 2;
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
		if (timer > 0){
			timer --; 
			if (timer == 0) {
				if (getTemperature() == Temperature.COLD) {
					if (setting == Setting.LOW) {
						temp = Temperature.WARM;
					} else if (setting == Setting.MEDIUM || setting == Setting.HIGH) { 
						temp = Temperature.WARM;
						timer = duration;
					}
				} else if (getTemperature() == Temperature.WARM) {
					if (setting == Setting.MEDIUM) {
						temp = Temperature.HOT;
					} else if (setting == Setting.HIGH) {
						temp = Temperature.HOT;
						timer = duration;
					} else if (setting == Setting.OFF) {
						temp = Temperature.COLD;
					}
				} else if (getTemperature() == Temperature.HOT) {
					if (setting == Setting.HIGH) {
						temp = Temperature.FIRE;
					}
					else if (setting == Setting.LOW) {
						temp = Temperature.WARM;
						timer = duration;
					} else if (setting == Setting.OFF) {
						temp = Temperature.COLD;
					}
				} else if (getTemperature() == Temperature.FIRE) {
					if (setting != Setting.HIGH) {
						temp = Temperature.HOT;
						timer = duration;
					}
				}
			}
		}
	}
	
	public String display() {
		return setting.toString(); 
	
	}
	public Temperature getTemperature() {
		
		return temp;
	}
}
	


