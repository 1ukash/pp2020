package ru.spbstu.iamm.telematics.parprog.lecture4;

public class PojoObj {
	private int someVal;
	private String name;

	public PojoObj(int someVal, String name) {
		this.someVal = someVal;
		this.name = name;
	}

	public int getSomeVal() {
		return someVal;
	}

	public void setSomeVal(int someVal) {
		this.someVal = someVal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PojoObj) {
			PojoObj o = (PojoObj) obj;
			return this.someVal == o.someVal && this.name.equals(o.name);
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return someVal << 2 + name.hashCode();
	}
	
	@Override
	public String toString() {
		return "<" + someVal + "," + name + ">";
	}
	
}
