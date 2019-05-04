package Com.MrFever.Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Temperature {
    private final SimpleDoubleProperty levelOfTemperature;
    private final SimpleStringProperty placeOfMeasurement;
    private final SimpleStringProperty dateOfMeasurement;
    private final SimpleStringProperty timeOfMeasurement;
    
    public Temperature(Double levelOfTemperature, String placeOfMeasurement, String dateOfMeasurement, String timeOfMeasurement) {
    	this.levelOfTemperature = new SimpleDoubleProperty(levelOfTemperature);
    	this.placeOfMeasurement = new SimpleStringProperty(placeOfMeasurement);
    	this.dateOfMeasurement = new SimpleStringProperty(dateOfMeasurement);
    	this.timeOfMeasurement = new SimpleStringProperty(timeOfMeasurement);
    }
    
	public Double getLevelOfTemperature() {
		return levelOfTemperature.get();
	}

	public void setLevelOfTemperature(Double value) {
		levelOfTemperature.setValue(value);
	}

	public String getPlaceOfMeasurement() {
		return placeOfMeasurement.get();
	}

	public void setPlaceOfMeasurement(String value) {
		placeOfMeasurement.setValue(value);
	}

	public String getDateOfMeasurement() {
		return dateOfMeasurement.get();
	}

	public void setDateOfMeasurement(String value) {
		dateOfMeasurement.setValue(value);
	}

	public String getTimeOfMeasurement() {
		return timeOfMeasurement.get();
	}

	public void setTimeOfMeasurement(String value) {
		timeOfMeasurement.setValue(value);
	}

	public DoubleProperty levelProperty() {
		return levelOfTemperature;
	}

	public StringProperty placeProperty() {
		return placeOfMeasurement;
	}
	
	public StringProperty dateProperty() {
		return dateOfMeasurement;
	}
	
	public StringProperty timeProperty() {
		return timeOfMeasurement;
	}
	
	
	@Override
	public String toString() {
		return levelOfTemperature + " " + placeOfMeasurement + " " + dateOfMeasurement + " " + timeOfMeasurement;
	}

}
