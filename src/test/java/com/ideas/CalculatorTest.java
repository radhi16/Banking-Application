package com.ideas;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("Spring-AutoScan.xml"))

public class CalculatorTest {

		@Qualifier("NonArithmeticCalculator")
	    @Autowired
		Calculator calculator;
		
		@Test
		public void testAddition(){
			int total = calculator.add(2,5);
			System.out.println("Total is " +total);
			assertTrue(total ==7);
		}
		
}
