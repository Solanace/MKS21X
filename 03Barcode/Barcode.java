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
	_checkDigit = checkSum();
    }
    
    // postcondition: Creates a copy of a bar code.
    public Barcode clone() {
	return new Barcode(_zip);
    }
    
    
    // postcondition: computes and returns the check sum for _zip
    private int checkSum() {
	int sum = 0;
	for (int position = 0; position < _zip.length(); position ++) {
	    sum += (int)_zip.charAt(position) - 48; // 48 is 0
	}
	return sum % 10;
    }
    
    //postcondition: format zip + check digit + Barcode
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"
    public String toString() {
	String finalString = _zip.substring(0) + _checkDigit + "  ";
	for (int position = 0; position < _zip.length(); position ++) {
	    switch ((int)_zip.charAt(position) - 48) {
	    case 1: finalString += ":::||";
		break;
	    case 2: finalString += "::|:|";
		break;
	    case 3: finalString += "::||:";
		break;
	    case 4: finalString += ":|::|";
		break;
	    case 5: finalString += ":|:|:";
		break;
	    case 6: finalString += ":||::";
		break;
	    case 7: finalString += "|:::|";
		break;
	    case 8: finalString += "|::|:";
		break;
	    case 9: finalString += "|:|::";
		break;
	    case 0: finalString += "||:::";
		break;
	    }
	}
	return finalString;
    }
    
    
    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other) {
	return _zip.compareTo(other._zip);        
    }    
}
