package Com.MrFever.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Medicine {
    private final SimpleStringProperty dateOfGiving;
    private final SimpleStringProperty timeOfGiving;
    private final SimpleStringProperty typeOfMedicine;
    private final SimpleStringProperty formOfMedicine;
    private final SimpleStringProperty doseOfMedicine;
    
    public Medicine(String dateOfGiving, String timeOfGiving, String typeOfMedicine, String formOfMedicine, String doseOfMedicine) {
    	this.dateOfGiving = new SimpleStringProperty(dateOfGiving);
    	this.timeOfGiving = new SimpleStringProperty(timeOfGiving);
    	this.typeOfMedicine = new SimpleStringProperty(typeOfMedicine);
    	this.formOfMedicine = new SimpleStringProperty(formOfMedicine);
    	this.doseOfMedicine = new SimpleStringProperty(doseOfMedicine);
    }

	public String getDateOfGiving() {
		return dateOfGiving.get();
	}

	public void SetDateOfGiving(String value) {
		dateOfGiving.setValue(value);
	}
	
	public String getTimeOfGiving() {
		return timeOfGiving.get();
	}
	
	public void SetTimeOfGiving(String value) {
		timeOfGiving.setValue(value);
	}

	public String getTypeOfMedicine() {
		return typeOfMedicine.get();
	}

	public void SetTypeOfMedicine(String value) {
		typeOfMedicine.setValue(value);
	}
	
	public String getFormOfMedicine() {
		return formOfMedicine.get();
	}
	
	public void SetFormOfMedicine(String value) {
		formOfMedicine.setValue(value);
	}

	public String getDoseOfMedicine() {
		return doseOfMedicine.get();
	}
	
	public void SetDoseOfMedicine(String value) {
		doseOfMedicine.setValue(value);
	}
	
	public StringProperty dateMProperty() {
		return dateOfGiving;
	}
	
	public StringProperty timeMProperty() {
		return timeOfGiving;
	}
	
	public StringProperty typeProperty() {
		return typeOfMedicine;
	}
	
	public StringProperty formProperty() {
		return formOfMedicine;
	}
	
	public StringProperty doseProperty() {
		return doseOfMedicine;
	}

	@Override
	public String toString() {
		return dateOfGiving + " " + timeOfGiving + " " + typeOfMedicine + " " + formOfMedicine + " " + doseOfMedicine;
	}
	

    
}
