package my.concurrency_collections;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class ConcurrentHashMapTest {

	@Test
	public void testPutIfAbsent() {
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		String r = map.putIfAbsent("name", "Tom");
		System.out.println(r);	// null
		r = map.putIfAbsent("name", "John");
		System.out.println(r);	// Tom
		
		r = map.putIfAbsent("name", "Cat");
		System.out.println(r);	// Tom
		
		System.out.println(map);	// {name=Tom}
	}
}
