import java.util.ArrayList;
public class Barcode implements Comparable<Barcode> {
    // instance variables
    private String _zip;
    private int _checkDigit;

    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public Barcode(String zip){
	if (zip.length() != 5) {
	    throw new IllegalArgumentException("The zip code can only have 5 digits.");
	}
	for (int position = 0; position < zip.length(); position ++) {
	    if ((int)zip.charAt(position) > 57 ||
		(int)zip.charAt(position) < 48) { // 48 is 0, 57 is 9
		throw new IllegalArgumentException("The zip code can only have 5 digits.");
	    }
	}

	_zip = zip;
	_checkDigit = checkSum(_zip);
    }
    
    // postcondition: Creates a copy of a bar code.
    public Barcode clone() {
	return new Barcode(_zip);
    }
    
    
    // postcondition: computes and returns the check sum for _zip
    public static int checkSum(String zip) {
	int sum = 0;
	for (int position = 0; position < zip.length(); position ++) {
	    sum += (int)zip.charAt(position) - 48; // 48 is 0
	}
	return sum % 10;
    }
    
    //postcondition: format zip + check digit + Barcode
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"
    public String toString() {
	String finalString = _zip.substring(0) + _checkDigit + "  " + toCode(_zip + _checkDigit);
	return finalString;
    }
    
    
    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other) {
	return _zip.compareTo(other._zip);        
    }

    public static String toCode(String zip) {
        if (zip.length() != 5 && zip.length() != 6) {
	    throw new IllegalArgumentException("The zip code can only have 5 digits and a check sum.");
	}
	for (int position = 0; position < zip.length(); position ++) {
	    if ((int)zip.charAt(position) > 57 ||
		(int)zip.charAt(position) < 48) { // 48 is 0, 57 is 9
		throw new IllegalArgumentException("The zip code can only have numbers.");
	    }
	}
	if (zip.length() == 6 && checkSum(zip.substring(0, 5)) != zip.charAt(5)- 48) {
	    throw new IllegalArgumentException("Invalid check sum");
	}
	
	if (zip.length() == 5) {
	    zip += checkSum(zip);
	}

	String finalString = "";
	String[] converter = {"||:::", ":::||", "::|:|", "::||:", ":|::|",
			    ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
	for (int position = 0; position < zip.length(); position ++) {
	    finalString += converter[zip.charAt(position) - 48];
	}
	System.out.println(finalString.length());
	return "|" + finalString + "|";
    }

    public static String toZip(String code) {
	if (code.length() != 32) {
	    throw new IllegalArgumentException("Invalid length. The code must be 32 characters long.");
	}
	if (code.charAt(0) != '|' || code.charAt(31) != '|') {
	    throw new IllegalArgumentException("Invalid zipcode (no preceding/closing bar).");
	}
	for (int position = 0; position < code.length(); position ++) {
	    if (code.charAt(position) != ':' && code.charAt(position) != '|') {
		System.out.println(code.charAt(position));
		throw new IllegalArgumentException("Invalid zipcode (non-colon and/or non-bar characters).");
	    }
	}
	
	String temp = "";
	String finalString = "";
	ArrayList<String> converter = new ArrayList<String>();
	converter.add("||:::");
	converter.add(":::||");
	converter.add("::|:|");
	converter.add("::||:");
	converter.add(":|::|");
	converter.add(":|:|:");
	converter.add(":||::");
	converter.add("|:::|");
	converter.add("|::|:");
	converter.add("|:|::");
	for (int group = 0; group < 5; group ++) {
	    temp = code.substring(1 + group*5, 6 + group*5);
	    if (converter.indexOf(temp) < 0) {
		throw new IllegalArgumentException("Invalid zipcode (invalid pattern of bars/colons).");
	    }
	    finalString += converter.indexOf(temp);
	}
	return finalString;
    }
}
