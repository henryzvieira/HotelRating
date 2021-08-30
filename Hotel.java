/*
 *Hotel.java
 *@author Henrique Oliveira
 *
*/

import javax.swing.JOptionPane;
import java.util.Arrays;

public class Hotel{

	//Data member
	private int menuFunction;//menu
	private final int ratingFirst[];//Array for rating of the 1st item
	private final int ratingSecond[];//Array for rating of the 2nd item
	private final int ratingThird[];//Array for rating of the 3rd item
	private final String items [];//Array for items
	private double sum [];//Array for storing the sums
	private double avg [];//Array for storing the averages
	private double min;//minimum value for the rating average
	private String itemEntered;// identify if it matches with items[]
	private String repeatAction;//repeat action

	//Constructor
	public Hotel(){

		menuFunction = 0;
		ratingFirst = new int [4];//Max number of ratings is 4
		ratingSecond = new int [4];//Max number of ratings is 4
		ratingThird = new int [4];//Max number of ratings is 4
		sum = new double [3];//one sum for each item
		avg = new double [3];//one avg for each item
		min = 0.0;
		items = new String [3];//Max items is 3
		itemEntered = "";
		repeatAction= "";
	}

	//Compute methods
	//Compute Item
	public void computeItem(){

		//for used to let the user input items using the max length of items (5)
		for (int i = 0; i < items.length; i++){
			items[i] = (JOptionPane.showInputDialog(null, "Please enter new Hotel " + "(" + (i+1) + "):"));

		//while used to not let empty items
		while (items[i].equals("")){
			JOptionPane.showMessageDialog(null, "Item can not be empty");
			items[i] = (JOptionPane.showInputDialog(null, "Please enter new Hotel " + "(" + (i+1) + "):"));
		}
		}

		JOptionPane.showMessageDialog(null, "Maximum number of Hotels entered");
	}

	//Compute Ratings
	public void computeRatings(){

		//if and else used to show message when items were not added
		//it was used items[0] != null in if because if the user entered an item, the first one would be mandatory
		if(items[0] != null){

			//Do and while used to give the option of rating more than one item
			do{

				//ask user to input item for rating
				itemEntered = JOptionPane.showInputDialog(null,"Please insert Hotel for rating." + "\nThe Hotels availabe for rating are: "
														+ Arrays.toString(items));

				//if used to identify that itemEntered is the same as items[0]
				if (itemEntered.equalsIgnoreCase(items[0])){

					//for used to let the user input ratings using the max length of items (5)
					for (int i = 0; i < ratingFirst.length; i++){
						ratingFirst[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter rating " + "(" + (i+1) + "):"));

					//while used for invalid rating
					while (ratingFirst[i] != 1 && ratingFirst[i] != 2 && ratingFirst[i] != 3 && ratingFirst[i] != 4 && ratingFirst[i] != 5){
						JOptionPane.showMessageDialog(null, "Invalid rating inserted. \nPlease enter a rating from 1 to 5 (lower to higher)");
						ratingFirst[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter rating " + "(" + (i+1) + "):"));
					}
					}

					JOptionPane.showMessageDialog(null, "Maximum number of ratings for this Hotel entered");

					//repeatAction used to ask if the user wants to rate another item
					repeatAction = JOptionPane.showInputDialog(null, "Would you like to rate another Hotel? yes or no");
				}

				//else if used to identify that itemEntered is the same as items[1]
				else if (itemEntered.equalsIgnoreCase(items[1])){

					//for used to let the user input ratings using the max length of items (5)
					for (int i = 0; i < ratingSecond.length; i++){
						ratingSecond[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter rating " + "(" + (i+1) + "):"));

					//while used for invalid rating
					while (ratingSecond[i] != 1 && ratingSecond[i] != 2 && ratingSecond[i] != 3 && ratingSecond[i] != 4 && ratingSecond[i] != 5){
						JOptionPane.showMessageDialog(null, "Invalid rating inserted. \nPlease enter a rating from 1 to 5 (lower to higher)");
						ratingSecond[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter rating " + "(" + (i+1) + "):"));
					}
					}

					JOptionPane.showMessageDialog(null, "Maximum number of ratings for this Hotel entered");

					//repeatAction used to ask if the user wants to rate another item
					repeatAction = JOptionPane.showInputDialog(null, "Would you like to rate another Hotel? yes or no");

				}

				//else if used to identify that itemEntered is the same as items[2]
				else if (itemEntered.equalsIgnoreCase(items[2])){

					//for used to let the user input ratings using the max length of items (5)
					for (int i = 0; i < ratingThird.length; i++){
						ratingThird[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter rating " + "(" + (i+1) + "):"));

					//while used for invalid rating
					while (ratingThird[i] != 1 && ratingThird[i] != 2 && ratingThird[i] != 3 && ratingThird[i] != 4 && ratingThird[i] != 5){
						JOptionPane.showMessageDialog(null, "Invalid rating inserted. \nPlease enter a rating from 1 to 5 (lower to higher)");
						ratingThird[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter rating " + "(" + (i+1) + "):"));
					}
					}

					JOptionPane.showMessageDialog(null, "Maximum number of ratings for this Hotel entered");

					//repeatAction used to ask if the user wants to rate another item
					repeatAction = JOptionPane.showInputDialog(null, "Would you like to rate another Hotel? yes or no");

				}

				//else to show message when itemEntered is invalid
				else {repeatAction = JOptionPane.showInputDialog(null, "Invalid Hotel. \nWould you like to try it again? Yes or No");}
			}

			while(repeatAction.equalsIgnoreCase("yes"));
		}

		else{JOptionPane.showMessageDialog(null, "No Hotels were entered");}


	}

	//Compute Average
	public void computeAvg(){

		//set calculation for arrays of sum for each positon
		sum[0] = ratingFirst[0] + ratingFirst[1] + ratingFirst[2] + ratingFirst[3];
		sum[1] = ratingSecond[0] + ratingSecond[1] + ratingSecond[2] + ratingSecond[3];
		sum[2] = ratingThird[0] + ratingThird[1] + ratingThird[2] + ratingThird[3];

		//set calculation for arrays of avg for each positon
		avg[0] = sum[0] / ratingFirst.length;
		avg[1] = sum[1] / ratingSecond.length;
		avg[2] = sum[2] / ratingThird.length;

	}

	//Compute Minimum Avg
	public void computeMin(){

		//min is going to be compared to avg[0] and if avg[i] is < min, the min turns into avg[i]
		min = avg[0];
		for(int i = 1; i < avg.length; i++){
			if(avg[i] < min){
				min = avg[i];
			}
		}
	}

	//Setters
	public void setMenuFunction(int menuFunction){
		this.menuFunction = menuFunction;
	}

	//Getters
	public String [] getItems(){
		return items;
	}

	public int [] getRatingFirst(){
			return ratingFirst;
	}

	public int [] getRatingSecond(){
				return ratingSecond;
	}

	public int [] getRatingThird(){
				return ratingThird;
	}

	public double [] getAvg(){
				return avg;
	}

	public double [] getSum(){
				return sum;
	}

	public double getMin(){
				return min;
	}


}//class
