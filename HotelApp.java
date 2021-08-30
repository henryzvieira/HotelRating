/*
 *HotelApp.java
 *@author Henrique Oliveira
 *
*/

import javax.swing.JOptionPane;
import java.util.Arrays;


public class HotelApp{

	public static void main (String args[]){

		//Display Application Info
		JOptionPane.showMessageDialog(null,"Hello," + "\nIn this application you are going to provide information for"
									 + "\nItem type: l1 - Hotel" + "\nMaximum number of Items: 3" + "\nMaximum number of Ratings: 4");


		//Declare variables
		int menuFunction;//show the menu functions of the menu
		int ratingFirst[] = new int [4];//Array for rating of the 1st item
		int ratingSecond[] = new int [4];//Array for rating of the 2nd item
		int ratingThird[] = new int [4];//Array for rating of the 3rd item
		String items [] = new String [3];//Array for items
		double sum [] = new double [3];//Array for storing the sums
		double avg [] = new double [3];//Array for storing the averages
		double min = 0.0;//minimum value for the rating average
		String itemEntered;// identify if it matches with items[]
		String repeatAction;//repeat action


		//Declare Objects
		Hotel myH = new Hotel();


		//Input
		//do while to set the app to work when it is not 7
		do{

		//input menu
		menuFunction = Integer.parseInt(JOptionPane.showInputDialog(null,"Application Menu for Item Type: Hotel" +"\n1 - Add an item" +
																"\n2 - Display all the items"+ "\n3 - Add a rating for a given item"
																+ "\n4 - Display all the ratings for a given item" +
																"\n5 - Calculate and display the average rating for each item" +
																"\n6 - Display the worst item based on the average rating" +
																"\n7 - Exit application" + "\nEnter your choice: "));
		//Process
		myH.setMenuFunction(menuFunction);

		//Getters
		items = myH.getItems();
		ratingFirst = myH.getRatingFirst();
		ratingSecond = myH.getRatingSecond();
		ratingThird = myH.getRatingThird();
		sum = myH.getSum();
		avg = myH.getAvg();
		min = myH.getMin();

			//Add an item
			if (menuFunction == 1){
				myH.computeItem();
			}

			//Display all the items
			else if (menuFunction == 2){

				//if and else used to show message when items were not added
				//it was used items[0] != null in if because if the user entered an item, the first one would be mandatory
				if (items[0] != null){
					JOptionPane.showMessageDialog(null, "The Hotels entered were:" + "\n Hotel 1 - " + items[0] +
												  "\n Hotel 2 - " + items[1] + "\n Hotel 3 - " + items[2]);
				}

				else {JOptionPane.showMessageDialog(null, "No Hotels were entered");}
			}

			//Add a rating for a given item
			else if (menuFunction == 3){
				myH.computeRatings();
			}


			//Display all the ratings for a given item
			else if (menuFunction == 4){

				//if and else used to show message when items were not added
				//it was used items[0] != null in if because if the user entered an item, the first one would be mandatory
				if(items[0] != null){

					//Do and while used to give the option of checking the rating of more than one item
					do{
						//ask user to input item for checking the rating
						itemEntered = JOptionPane.showInputDialog(null,"Please insert a Hotel to see its rating." + "\nThe Hotels availabe are: "
													+ Arrays.toString(items));

						//if used to identify that itemEntered is the same as items[0]
						if (itemEntered.equalsIgnoreCase(items[0])){

							//If and else used to show rating and message if there is no rating for the item
							if(ratingFirst[0] != 0){
								JOptionPane.showMessageDialog(null, "Item: " + items[0] + " - Ratings: " + Arrays.toString(ratingFirst));
							}

							else{JOptionPane.showMessageDialog(null, "No rating was given to this item");}

							repeatAction = JOptionPane.showInputDialog(null, "Would you like to check another Hotel? yes or no");
						}

						//else if used to identify that itemEntered is the same as items[1]
						else if (itemEntered.equalsIgnoreCase(items[1])){

							//If and else used to show rating and message if there is no rating for the item
							if(ratingSecond[0] != 0){
								JOptionPane.showMessageDialog(null, "Item: " + items[1] + " - Ratings: " + Arrays.toString(ratingSecond));
							}

							else{JOptionPane.showMessageDialog(null, "No rating was given to this item");}

							repeatAction = JOptionPane.showInputDialog(null, "Would you like to check another Hotel? yes or no");
						}

						//else if used to identify that itemEntered is the same as items[2]
						else if (itemEntered.equalsIgnoreCase(items[2])){

							//If and else used to show rating and message if there is no rating for the item
							if(ratingThird[0] != 0){
								JOptionPane.showMessageDialog(null, "Item: " + items[2] + " - Ratings: " + Arrays.toString(ratingThird));
							}

							else{JOptionPane.showMessageDialog(null, "No rating was given to this item");}

							repeatAction = JOptionPane.showInputDialog(null, "Would you like to check another Hotel? yes or no");
						}

						//else to show message when itemEntered is invalid
						else {JOptionPane.showMessageDialog(null, "Please enter a valid Hotel" + "\nThe Hotels availabe are: "
															+ Arrays.toString(items));
							repeatAction = JOptionPane.showInputDialog(null, "Would you like to check another Hotel? yes or no");
						}
					}

					while(repeatAction.equalsIgnoreCase("yes"));

				}

				else{JOptionPane.showMessageDialog(null, "No Hotels were entered");}

			}

			//Calculate and display the average rating for each item
			else if (menuFunction == 5){
				myH.computeAvg();

				//Display averages and items
				JOptionPane.showMessageDialog(null, items[0] + " - average rating: " + avg[0]
											+ "\n" + items[1] + " - average rating: " + avg[1]
											+ "\n" + items[2] + " - average rating: " + avg[2]
											+ "\n \n* 0.0 means that the Hotel was not rated");
			}


			//Display the worst item based on the average rating
			else if (menuFunction == 6){

				//if and else to show the worst item only if all of the rates were input
				if (avg[0] != 0 && avg[1] != 0 && avg[2] != 0){

				myH.computeMin();

				//if to compare if the min = avg position to display only the worst item
				if(min == avg[0]) {JOptionPane.showMessageDialog(null, "The worst Hotel based on average is: " + items[0] + ", Average: " + min);}
				if(min == avg[1]) {JOptionPane.showMessageDialog(null, "The worst Hotel based on average is: " + items[1] + ", Average: " + min);}
				if(min == avg[2]) {JOptionPane.showMessageDialog(null, "The worst Hotel based on average is: " + items[2] + ", Average: " + min);}
				}

				else {JOptionPane.showMessageDialog(null, "Please insert rating for all of the Hotels entered " + Arrays.toString(items));}
			}

			//Exit application
			else if (menuFunction == 7){

				//Message before finishes the application
				JOptionPane.showMessageDialog(null, "Thank you.");
			}

			//Message error for when input an invalid menuFunction
			else{
				JOptionPane.showMessageDialog(null, "Not a valid function");
			}

		}

		while(menuFunction != 7);

	}//main
}//class