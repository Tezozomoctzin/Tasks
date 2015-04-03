import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Runner {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("in");
		Enumeration<String> keys = rb.getKeys();
		String key;
		String operatingValue;
		String orderNumber;
		double sum = 0;
		int errorLines = 0;
		while (keys.hasMoreElements()){
			key = keys.nextElement();
			if(indexKeyCheck(key) && isNumber(rb.getString(key))){
				orderNumber = getOrderNumber(key, rb.getString(key));
				operatingValue = getValueByKey(orderNumber);
				if(operatingValue != null && isNumber(operatingValue)){
					sum += Double.parseDouble(operatingValue);
				} else{
					errorLines++;
				}
			}else if(indexKeyCheck(key) && !(isNumber(rb.getString(key)))){
				errorLines++;
			}
		}
		System.out.println("sum = " + sum);
		System.out.println("error-lines = " + errorLines);
	}

	static boolean indexKeyCheck(String key){
		Pattern indexPattern = Pattern.compile("(index)([0-9]+)");
		Matcher indexMatcher = indexPattern.matcher(key);
		return indexMatcher.lookingAt();
	}	

	static boolean valueKeyCheck(String key){
		Pattern valuePattern = Pattern.compile("(value)([0-9]+)");
		Matcher valueMatcher = valuePattern.matcher(key);
		return valueMatcher.lookingAt();
	}	
	
	static String getValueByKey(String orderNumber){
		Pattern valueIndex = Pattern.compile(orderNumber);
		ResourceBundle bundle = ResourceBundle.getBundle("in");
		Enumeration<String> bundleKeys = bundle.getKeys();
		try{
			String value = bundle.getString(orderNumber).trim();
			if(isNumber(value)){
				return value;
			}else{
			return null;
			}
		}catch (MissingResourceException e){
			return null;
		}
	}
	
	static boolean isNumber(String check){
		Pattern intPattern = Pattern.compile("[0-9]+");
		Pattern doublePattern = Pattern.compile("-?[0-9]{1,5}(\\.[0-9]*)");
		Matcher isNumberMatcher = intPattern.matcher(check);
		if(isNumberMatcher.matches()){
			return true;
		}else{ 
			isNumberMatcher = doublePattern.matcher(check);
			if(isNumberMatcher.matches()){
				return true;
			}else{
				return false;
			}
		}
	}
	
	static String getOrderNumber(String key, String value){
		Pattern digitPattern = Pattern.compile("(index)([0-9]+)");
		Matcher iValueMatch = digitPattern.matcher(key + value);
		if(iValueMatch.matches()){
			return  "value" + iValueMatch.group(2);
		}else{
			return null;
		}
	}
		
}