package src_main_java;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
  
	@BeforeSuite
	public void setRetryAlanalyzer(ITestContext context){
		ITestNGMethod[] methods=context.getAllTestMethods();
		for(ITestNGMethod iTestNGMethod: methods){
			iTestNGMethod.setRetryAnalyzer(new RetryAnalyzer());
		}
	}
}
