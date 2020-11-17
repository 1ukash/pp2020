package ru.spbstu.iamm.telematics.parprog.lecture5;

import java.io.InputStream;
import java.io.Serializable;

public class ContainerObject implements Serializable, Cloneable {
	
	private int id = 6;
	private double val = 0.1;
	private ContainerObject parent;
	
	private transient InputStream is;
	
	public ContainerObject(int id, double val, ContainerObject parent) {
		super();
		this.id = id;
		this.val = val;
		this.parent = parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getVal() {
		return val;
	}

	public void setVal(double val) {
		this.val = val;
	}

	public ContainerObject getParent() {
		return parent;
	}

	public void setParent(ContainerObject parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		
		return super.toString() + "{id=" + id +", val=" + val + ", parent=" + 
		((parent != null) ? parent.toString(): "null") + "}";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
}
