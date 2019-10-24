
public class Prescription {
@Override
	public String toString() {
		return "Prescription [name=" + name + ", Description=" + Description + "]";
	}
String name;
String Description;


public Prescription(String name, String description) {
	super();
	this.name = name;
	Description = description;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}


}
