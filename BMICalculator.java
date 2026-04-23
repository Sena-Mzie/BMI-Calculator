//import packages
import java.util.Scanner;
import java.util.Locale;

//public class BMICalculator
public class BMICalculator{

//main method
public static void main(String[] args){
	//creating Scanner Object
	Scanner sc = new Scanner(System.in);
	sc.useLocale(Locale.US);
	
	char repeat = 0;

	do{
		int unitChoice = getUnitChoice(sc);

		double weight = (unitChoice == 1)? getValidInput(sc, "Enter your weight in kilograms: ", 10, 600)
		            : getValidInput(sc, "Enter your weight in pounds: ", 22, 1300);
		
		double height = (unitChoice == 1)? getValidInput(sc, "Enter your height in meters: ", 0.5, 2.5)
		            : getValidInput(sc, "Enter your height in inches: ", 20, 100);
		
		double bmi = calculateBMI(unitChoice, weight, height);
		System.out.print("Your BMI is " + bmi);

	//repeat = askToRepeat(sc);
	//System.out.print();

	} while(repeat == 'Y' || repeat == 'y');

}

//method to get unit choice, Metric/Imperial
 public static int getUnitChoice(Scanner sc){
	int choice;

	//while loop for selecting unit option
	while(true){
		System.out.println("Select a preferred unit: \new"
		        + "1. Metric (kg, m)\n"
				+ "2. Imperial (lbs , in)\n"
				+ "Please select either option 1 or option 2");
		
		//nested if-statement for ensuring valid input
		if(sc.hasNextInt()){
			choice = sc.nextInt();
			if(choice == 1 || choice == 2){
				break;
			} else{
				System.out.println("Invalid choice. Please enter either 1 or 2");
			}
		} else{
			System.out.println("Invalid choice. Please enter a number(1 or 2)");
			sc.next();
		}
	}
	return choice;
 }

//method to get valid input from user
public static double getValidInput(Scanner sc, String prompt, double min, double max){
	double value; 

	//while loop for ensuring valid input from user
	while(true){
		System.out.println(prompt);
		if(sc.hasNextDouble()){
			value = sc.nextDouble();
			if(value>= min && value <= max){
				break;
			} else {
				System.out.printf("Please enter the value between %.1f and %.1f. \n", min, max);
				}
		} else{
			System.out.println("Invalid input. Please enter a value");
			sc.next();
		}
	}
	return value;
}

//method to calculate BMI
public static double calculateBMI(int unitChoice, double weight, double height){
	double totalBMI;

	if (unitChoice == 1){
		totalBMI = weight / (height * height);
	} else{
		totalBMI = (703 * weight) / (height / height);
	}
	return totalBMI;
}

//method to print BMI category
public static void printBMICategory(double bmi){
    if(bmi < 18.5){
        System.out.println(" (Underweight)");
    } else if(bmi < 25 & bmi > 18.5){
        System.out.println(" (Normal weight)");
    } else if(bmi < 30 & bmi > 25){
        System.out.println(" (Overweight)");
    } else{
        System.out.println(" (Obese)");
    }
}


}