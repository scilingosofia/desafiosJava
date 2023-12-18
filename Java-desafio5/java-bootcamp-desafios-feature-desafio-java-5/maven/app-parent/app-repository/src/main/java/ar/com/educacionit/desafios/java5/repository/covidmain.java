package ar.com.educacionit.desafios.java5.repository;

import ar.com.educacionit.desafios.java5.domain.Entity;

public class covidmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CovidRecordRepositoryImpl repo = new CovidRecordRepositoryImpl();
		
		System.out.println(repo.getById(20200429L)); 
		
			
		Entity covidRecord = new Entity("{\"date\":20200428}");
		
//		System.out.println(covidRecord);
		repo.save(covidRecord);
	
	}

}
