package ru.spbstu.iamm.telematics.parprog.lecture4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.NumberOfInterveningJobs;

public class FooCollections {

	public static void main(String[] args) {
		PojoObj o1, o2, o3, o4;
		o1 = new PojoObj(1, "X");
		o2 = new PojoObj(2, "Y");
		o3 = o1;
		o4 = new PojoObj(2, "Y");
		
		List<PojoObj> l = generateList(o1, o2, o3, o4);
		// l.add(new Object()); not compiles
		// l.add(o1); runtime exception
		System.out.println(l);
		
		Set<PojoObj> s = new HashSet<PojoObj>();
		s.add(o1);
		s.add(o2);
		s.add(o3);
		s.add(o4);
		s.add(o2);
		
		System.out.println(s);
		
		for (PojoObj o: l) {
			System.out.println(o);
		}
		
		// OLD STYLE
		ArrayList badOne = new ArrayList();
		badOne.add(o1);
		badOne.add(o2);
		badOne.add(o3);
		badOne.add(o4);
		badOne.add(o2);
		badOne.add(new Object()); // causes exception later

		Collection<PojoObj> withType = Collections.checkedCollection(badOne, PojoObj.class);
		
		for (Object o: badOne) {
			PojoObj po = (PojoObj) o;
			System.out.println(po);
		}
		
		Iterator<PojoObj> it = l.iterator();
		while (it.hasNext()) {
			PojoObj o = it.next();
			// do smth with o
		}
		
		MyCollection<String> strs = new MyCollection<String>();
		for (String str: strs) {
			// do something with s
		}
	}

	private static List<PojoObj> generateList(PojoObj o1, PojoObj o2, PojoObj o3, PojoObj o4) {
		List<PojoObj> l = new ArrayList<>();
		Collections.addAll(l, o1, o2, o3, o4);
		return Collections.unmodifiableList(l);
	}
	
}
