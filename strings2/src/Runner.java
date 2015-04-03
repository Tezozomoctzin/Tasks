import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.transform.ErrorListener;

public class Runner {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("in");
		Enumeration<String> keys = rb.getKeys();
		String key;
		String operatingValue;
		String orderNumber;
		double sum = 0;
		int errorLines = 0;
		while (keys.hasMoreElements()) {
			operatingValue = null;
			key = keys.nextElement();
			double getValidValue = fullCheck(key, rb);
			if (getValidValue != 0) {
				sum += getValidValue;
			} else if (key.startsWith("index")) {
				errorLines++;
			}
		}
		System.out.println("sum = " + sum);
		System.out.println("error-lines = " + errorLines);
	}

	static boolean indexKeyCheck(String key) {
		Pattern indexPattern = Pattern.compile("(index)([1-9])([0-9]+)?");
		Matcher indexMatcher = indexPattern.matcher(key);
		return indexMatcher.lookingAt();
	}

	static boolean valueKeyCheck(String key) {
		Pattern valuePattern = Pattern.compile("(value)([0-9]+)");
		Matcher valueMatcher = valuePattern.matcher(key);
		return valueMatcher.lookingAt();
	}

	static boolean indexZeroCheck(String check) {
		Pattern zeroPattern = Pattern.compile("(index)(0{1,})");
		Matcher zeroMatcher = zeroPattern.matcher(check);
		return zeroMatcher.lookingAt();
	}

	static boolean valueZeroCheck(String check) {
		Pattern zeroPattern = Pattern.compile("(0{1,})([0-9])");
		Matcher zeroMatcher = zeroPattern.matcher(check);
		return zeroMatcher.lookingAt();
	}

	static String getValueByKey(String orderNumber, ResourceBundle rb) {
		try {
			String value = rb.getString(orderNumber).trim();
			if (isNumber(value)) {
				return value;
			} else {
				return null;
			}
		} catch (MissingResourceException e) {
			return null;
		}
	}

	static boolean isNumber(String check) {
		Pattern intPattern = Pattern.compile("[0-9]+");
		Pattern doublePattern = Pattern.compile("-?[0-9]{1,5}?(\\.[0-9]*)");
		Matcher isNumberMatcher = intPattern.matcher(check);
		if (isNumberMatcher.matches()) {
			return true;
		} else {
			isNumberMatcher = doublePattern.matcher(check);
			if (isNumberMatcher.matches()) {
				return true;
			} else {
				return false;
			}
		}
	}

	static String getOrderNumber(String key, String value) {
		Pattern digitPattern = Pattern.compile("(index)([0-9]+)");
		Matcher iValueMatch = digitPattern.matcher(key + value);
		if (iValueMatch.matches()) {
			return "value" + iValueMatch.group(2);
		} else {
			return null;
		}
	}

	static double fullCheck(String key, ResourceBundle rb) {
		if (indexKeyCheck(key) && !(indexZeroCheck(key))
				&& isNumber(rb.getString(key))
				&& !valueZeroCheck(rb.getString(key))) {
			String orderNumber = getOrderNumber(key, rb.getString(key));
			if (orderNumber != null) {
				String operatingValue = getValueByKey(orderNumber, rb);
				if (operatingValue != null && !(valueZeroCheck(operatingValue))
						&& isNumber(operatingValue)) {
					return Double.parseDouble(operatingValue);
				}
			}
		}
		return 0;
	}

}