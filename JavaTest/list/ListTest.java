package JavaTest.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	
	public static void print(List<Integer> paraList) {
		for(Integer i : paraList) {
			System.out.println(i);
		}
		System.out.println("---------");
	}

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		print(myList);
		myList.remove(2);
		print(myList);
		
		String[] data = {
				"Kira",
				"ikaa",
				"Keri",
				"keeK"
		};
		for(int i = 0; i < data.length; i++) {
			if(data[i].indexOf("M") >= 0) {
				System.out.println(data[i]);
			}
		}
	}
}
