package Com.MrFever.Model;

public class Temperature {
    private double temperatureLevel;
    private String bodyPart;

    public double getTemperatureLevel() {
        return temperatureLevel;
    }

    public void setTemperatureLevel(double temperatureLevel) {
        this.temperatureLevel = temperatureLevel;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    Temperature() {}

    Temperature(double temperatureLevel, String bodyPart) {
        this.setTemperatureLevel(temperatureLevel);
        this.setBodyPart(bodyPart);
    }
}
