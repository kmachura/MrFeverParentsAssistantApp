package Com.MrFever.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MedicinesDetail {
	private final SimpleStringProperty formOfMedicine;
	private final SimpleStringProperty description;

	public MedicinesDetail(String formOfMedicine, String description) {
		this.formOfMedicine = new SimpleStringProperty(formOfMedicine);
		this.description = new SimpleStringProperty(description);
	}

	public String getFormOfMedicine() {
		return formOfMedicine.get();
	}

	public void SetFormOfMedicine(String value) {
		formOfMedicine.setValue(value);
	}

	public String getDescription() {
		return description.get();
	}

	public StringProperty formProperty() {
		return formOfMedicine;
	}

	public StringProperty descriptionProperty() {
		return description;
	}

	@Override
	public String toString() {
		return formOfMedicine + " " + description;
	}

}
