//import packages
import java.util.Scanner;
import java.util.Locale;

//public class BMICalculator
public class BMICalculator{

//main method
public static void main(String[] args){
	//creating Scanner Object
	Scanner sc = new Scanner(System.in);
	Scanner.useLocale(Locale.US);
	
	char repeat = 0;

	do{
		int unitChoice = getUnitChoice(sc);

		double weight = (unitChoice == 1)? getValidInput(sc, "Enter your weight in kilograms: ", 10, 600)
		            : getValidInput(sc, "Enter your weight in pounds: ", 22, 1300);
		
		double height = (unitChoice == 1)? getValidInput(sc, "Enter your height in meters: ", 0.5, 2.5)
		            : getValidInput(sc, "Enter your height in inches: ", 20, 100);
		
		double bmi = calculateBMI(unitChoice, weight, height);

	//repeat = askToRepeat(sc);
	System.out.print();

	} while(repeat == 'Y' || repeat == 'y');
}

}