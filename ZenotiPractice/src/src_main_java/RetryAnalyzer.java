package src_main_java;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int count=0, max_execution_count=2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		count++;
		if(count==max_execution_count){
		 return false;
		}
		else
		
		return true;
		
	}

}
