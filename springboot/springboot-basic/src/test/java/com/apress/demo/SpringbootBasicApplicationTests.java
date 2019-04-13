package com.apress.demo;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringbootBasicApplication.class)
public class SpringbootBasicApplicationTests {

	//@Autowired
	//Calculator calculator;

//	@MockBean
//	private Calculator calculator;
//
//	@MockBean(name = "division")
//	private Operation mockOperation2;
//
//	@MockBean(name = "addition") // This would replace the regular Addition bean with a mocked instance.
//	private Operation mockOperation;

//	@Rule
//	public OutputCapture capture = new OutputCapture();
//
//	@Test(expected = IllegalArgumentException.class)
//	public void doingDivisionShouldFail() {
//		calculator.calculate(12, 13, '/');
//		capture.expect(Matchers.containsString("12 * 13 = 156"));
//	}
//
//	@Test
//	public void calculatorShouldHave3Operations() {
//		Object operations = ReflectionTestUtils.getField(calculator, "operations");
//		System.out.println(operations); //It does not work, Please do a research
//	//	assertThat((Collection) operations).hasSize(3);
//	}
}
