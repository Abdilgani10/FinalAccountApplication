package com.qa.test;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.qa.domain.Account;
import com.qa.domain.JSONUtil;
import com.qa.domain.Service;

public class AccountManagementSystemTest {
	 
	Service service;
	
	@Before
	public void setUp() {
		service = new Service();
		
	}
	

	@Test
	public void addAccountTest() {
		Account Gani = new Account("Gani","Abdallah",1);
		service.addAccount(Gani);
		Integer expected=1;
		Integer actual=service.getAccountMap().size();
		assertEquals(expected,actual);
	}
	
	@Test
	public void removeAccountTest() {
		Account Gani = new Account("Gani","Abdallah",1);
		Account Hazard = new Account("Godwin","Adeleke",2);
		service.addAccount(Gani);
		service.addAccount(Hazard);
		service.removeAccount(Hazard);
		Integer expected=1;
		Integer actual=service.getAccountMap().size();
		assertEquals(expected,actual);
		assertFalse(service.getAccountMap().containsValue(Hazard));

		
		
	}
	
	@Test
	public void getAccountTest() {
		Account Gani = new Account("Gani","Abdallah",1);
		Account Godwin = new Account("Godwin","Adeleke",2);
		service.addAccount(Gani);
		service.addAccount(Godwin);
		Account expected = Gani;
		Account actual = service.getAccount(1);
		assertEquals(expected,actual);
		
		
	}
	@Test
	public void JSONconversionTest() {
		Account Gani = new Account("Gani","Abdallah",1);
		service.addAccount(Gani);
		JSONUtil ju=new JSONUtil();
		String expected="{\"1\":{\"firstName\":\"Gani\",\"lastName\":\"Abdallah\",\"accountNumber\":1}}";
		String actual=ju.getJSONForObject(service.getAccountMap());
		System.out.println(ju.getJSONForObject(service.getAccountMap()));
		assertEquals(expected,actual);
	}
	
}
