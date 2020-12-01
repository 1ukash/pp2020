package ru.spbstu.iamm.telematics.parprog.lecture10;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcHM {
	
	public static void main(String[] args) {
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
		HashMap<Integer, String> simpleMap = new HashMap<>();
		Map<Integer, String> synchMap = Collections.synchronizedMap(simpleMap);
		
		// not thread safe
		simpleMap.put(1, "X");
		String val = simpleMap.get(1);
		
		// thread safe but not efficient
		synchMap.put(1, "X");
		val = synchMap.get(1);
		
		//thread safe and efficient from any thread without locks:
		map.put(1, "X");
		val = map.get(1);
	}
}
