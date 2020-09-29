package ru.spbstu.iamm.telematics.parprog.lecture2;

public class Baz {

	private int id;
	private String name;
	private final String address;

	public Baz(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.address = "Politechnicheskaya, 29";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	void someMethod() {
		//address = "new ";
	}

}
