import acm.program.*;

public class AddCommasToNumericString extends ConsoleProgram{
	public void run(){
		while(true){
			String digits=readLine("Enter a numeric string:");
			if(digits.length()==0){
				break;
			}
			println(addCommasToNumericString(digits));
		}
	}
	
	private String addCommasToNumericString(String digits){
		String result="";
		int count=0;
		for(int i=digits.length()-1;i>=0;i--){
			count++;
			result=digits.charAt(i)+result;
			if(count%3==0 && i>0){
				result=","+result;
			}
		}
		return result;
	}

}
