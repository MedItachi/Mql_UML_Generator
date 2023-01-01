import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.ArrayList;

public class Main {
	 public static void main(String[] args) {
	        // Get the Class object representing the enumeration
	        Class<?> cls = VerifyError.class;

	        // Get the constants of the enumeration as an array
	        Enum[] constants = (Enum[]) cls.getEnumConstants();

	        // Convert the array to a List
	        List<Enum> constantsList = Arrays.asList(constants);

	        // Create a new List to store the constants
	        List<Enum> enums = null;

	        // Add all the elements of the constantsList to the enums List
	        enums.addAll(constantsList);

	        // Iterate through the enums List and print the constants
	        for (Enum constant : enums) {
	            System.out.println(constant);
	        }
	    }
}
