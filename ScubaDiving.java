import java.util.Scanner;	// Needed for the Scanner class

/************************************************************************
*
*	This program intended to verify the appropriate mixture of oxygen   
*	and nitrogen in the gas used by scuba divers.						
*																		*
************************************************************************/

public class ScubaDiving
{
	public static void main(String[] args)
	{
		int depthOfDive,								//Depth of dive in feet
			oxygenPercentage; 							//The percentage of oxygen in the gas
			
		final int FEET_PER_ATMOSPHERE = 33;				//Constant feet per atmosphere
			
		double	ambientPressure,						//Ambient pressure
				partialPressureOfOxygen,				//Partial pressure of oxygen for the dive
				maximalPartialPressureOfOxygen = 1.4,	//Maximal partial pressure of oxygen
				contingencyMax = 1.6;					//Contingency maximal partial pressure of oxygen
				
		
		char	oxygenGroup;							//Oxygen pressure group
		
		boolean	exceedsMaxOxygenPressure = false,		//Exceeds max oxygen pressure
				exceedsContingency = false;				//Exceeds contingency
				
				
		//Create a Scanner object to read input.
		Scanner keyboard = new Scanner (System.in);
		
		//Prompt the user for the depth of the dive in feet and the percentage of oxygen in the gas.
		System.out.print("Enter depth and percentage O2\t: ");
		
		//Input depthOfDive and oxygenPercentage
		depthOfDive = keyboard.nextInt();
		oxygenPercentage = keyboard.nextInt();
		
		
		
		//Calculate the variables.
		
		//Compute the ambient pressure
		ambientPressure = depthOfDive / FEET_PER_ATMOSPHERE + 1;
		
		//Compute the partial pressure of oxygen
		partialPressureOfOxygen = (double)oxygenPercentage / 100;
		partialPressureOfOxygen = ambientPressure * partialPressureOfOxygen;
		
		//Calculate the oxygen group
		oxygenGroup = (char)((partialPressureOfOxygen * 10) + 'A' );
		
		
		//The recommended maximal partial pressure of oxygen is 1.4, the contingency maximal partial pressure of oxygen is 1.6.
		
		if (partialPressureOfOxygen > maximalPartialPressureOfOxygen)
		{
			exceedsMaxOxygenPressure = true;
		}
		
		if (partialPressureOfOxygen > contingencyMax)
		{
			exceedsContingency = true;
		}
		
		

		
		//Display output messages.
		//Display ambient pressure
		System.out.println("Ambient pressure\t\t: " + ambientPressure);
		
		//Display partial pressure of oxygen
		System.out.println("O2 pressure\t\t\t: " + partialPressureOfOxygen);
		
		//Display O2 group
		System.out.println("O2 group\t\t\t: " + oxygenGroup);
		
		//Skip a line
		System.out.println();
		
		//Display exceeds maximal & contingency O2 pressures
		System.out.println("Exceeds maximal O2 pressure\t: " + exceedsMaxOxygenPressure);
		System.out.println("Exceeds contingency O2 pressure\t: " + exceedsContingency);
	}
}
