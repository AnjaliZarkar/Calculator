package com.devops.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.devops.src.Calculator;
@RunWith(JUnit4.class)
public class CalculatorTest {
	//always return void,
	//meaningful method name
	//should not pass any parameter to test Method
	//always work with fresh obj-to maintain StateFul
	Calculator cal= null;
	
	@Before
	public  void init(){
		System.out.println("Init");
		cal=  new Calculator();
	}
	@After
	public  void clean(){
		System.out.println("clean");
		cal=  new Calculator();
	}
	
	@Test
	public void addTwoPositiveNumbers(){
	//	Calculator cal= new Calculator();
		int result= cal.sum(10,5);
		Assert.assertEquals(15, result);
		
	}
	
	@Test
	public void addTwoPositiveNegativeNumbers(){
		Calculator cal= new Calculator();
		int result= cal.sum(15,-5);
		Assert.assertEquals(10, result);
		
	}
	
	//Testing for Exception
	@Test(expected=AssertionError.class)
	public void addTwoBigPositiveNumbersForBoundry(){
		
			Calculator cal= new Calculator();
			int result= cal.sum(15555555,123456789);
			Assert.assertTrue("Sum is beyond boundry", Integer.MAX_VALUE<=result);
				
	}
	
	@Test(expected=ArithmeticException.class)
	public void divideByZeroForException(){
		
			Calculator cal= new Calculator();
			cal.divide(15, 0);
				
	}
	
	//Testing for SLA -test performance
	@Test(timeout=1)
	public void addTwoPositiveNumbersForSLA(){
	//	Calculator cal= new Calculator();
		cal.sum(10,5);		
		
	}
	

}
