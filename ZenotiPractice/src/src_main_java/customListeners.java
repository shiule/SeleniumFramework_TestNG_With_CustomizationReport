package src_main_java;

import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class customListeners implements ITestListener {
	public static final String ANSI_RED = "\u001B[31m";

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+"Test Started ---");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test '"+result.getName()+"' is PASSED");
		log(result.getTestClass());
		System.out.println("Priority of the test case....."+result.getMethod().getPriority());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	  //  System.out.println("\033[31;1mHello\033[0m, \033[32;1;2mworld!\033[0m");

		System.out.println(customListeners.ANSI_RED +" Test " + result.getName() + "[31m' FAILED");
		System.out.println("Priority of this method is " + result.getMethod().getPriority());
		System.out.println(".....");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	private void log(IClass testClass){
		System.out.println(testClass);
	}

}
