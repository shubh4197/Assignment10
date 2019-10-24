import java.util.*;

public class Patient {
	private String name;
	String age;
	String address;
	List<Prescription> Prescribe;

	public Patient(String name, String age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.Prescribe = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", age=" + age + ", address=" + address + ", k=" + Prescribe + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
