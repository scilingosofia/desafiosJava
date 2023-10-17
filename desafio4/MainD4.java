package ar.com.educacionit.desafios.desafio4;


public class MainD4 {

	public static void main(String[] args) {
		MyCustomList<String> my = new MyCustomList<>();
		
		String one = "test";
		String two = "test1";
		String three = "test2";
		String four = "test3";
		String five = "some test to insert first";
		
		my.add(one);
		my.add(two);
		my.add(three);
		my.add(four);
		
		my.addFirst(five);
		System.out.println(my.remove(five));
		
		MyCustomList<String>someOtherList = new MyCustomList<>();
		someOtherList.add(one);
		
		someOtherList.remove(one);
		System.out.println(someOtherList.size());		

	}

}
