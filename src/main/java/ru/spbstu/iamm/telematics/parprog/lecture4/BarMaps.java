package ru.spbstu.iamm.telematics.parprog.lecture4;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class BarMaps {
	public static void main(String[] args) {
		PojoObj o1, o2, o3, o4;
		Map<String, PojoObj> objMap = new TreeMap<String, PojoObj>();
		o1 = new PojoObj(1, "X");
		o2 = new PojoObj(2, "Y");
		o3 = o1;
		o4 = new PojoObj(2, "Y");
		
		putToMap(new PojoObj(7, "Z"), objMap);
		putToMap(o1, objMap);
		putToMap(o2, objMap);
		putToMap(o3, objMap);
		putToMap(o4, objMap);
		putToMap(new PojoObj(5, "A"), objMap);
		
		System.out.println(objMap);
		
		PojoObj obj = objMap.get("X");
		System.out.println(obj);
		obj = objMap.get("Z");
		System.out.println(obj);
		System.out.println("Iterating");
		for(String k: objMap.keySet()) {
			System.out.println(objMap.get(k));
		}
		
		
	}

	private static void putToMap(PojoObj o, Map<String, PojoObj> objMap) {
		objMap.put(o.getName(), o);
	}
}
