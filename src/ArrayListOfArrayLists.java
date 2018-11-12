import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ListIterator;
public class ArrayListOfArrayLists {
	public static void main(String[] args){
		// We create an empty ArrayList object of ArrayList type (that will be of FootballMatch type)
		ArrayList<ArrayList<FootballMatch>> LeagueArrayList = new ArrayList<ArrayList <FootballMatch>>();
		// We control that the user enters an argument at least
		if (args.length!=0) {
			// We create an empty array of the type File with the length of the number of arguments the user entered
			File[] FileArray = new File[args.length];
			// We create an empty array of the type Scanner with the length of the number of arguments
			Scanner[] ScannerArray = new Scanner[args.length];
			// We open a loop for each argument
			for (int i=0;i<args.length;i++) {
				// We create a file object with a previously created text file
				FileArray[i]=new File("C:\\Users\\etxea\\eclipse-workspace\\FootballMatch\\src\\" + args[i] + "Matches.txt");
				// We create a scanner object with the previously created file object
				try {
					ScannerArray[i] = new Scanner(FileArray[i]);
				// We create an empty ArrayList object of FootballMatch type
				ArrayList<FootballMatch> PartidoFutbol = new ArrayList<FootballMatch>();
				// We create a loop where each line of the text file will be a match
				while (ScannerArray[i].hasNext()) {
					// We create a string object with the next line
					String match = ScannerArray[i].nextLine();
					// We create an array with the values of each part of the line, separated by "::"
					String[] information = match.split("::");
					// We convert the string values that represent goals to integer
					int GoalsLocal = Integer.parseInt(information[2]);
					int GoalsVisitor = Integer.parseInt(information[3]);
					// We create an empty FootballMatch object
					FootballMatch ThisFootballMatch=new FootballMatch();
					// We add the information of the match to the FootballMatch object with the previously created methods
					ThisFootballMatch.setLocalTeam(information[0]);
					ThisFootballMatch.setVisitorTeam(information[1]);
					ThisFootballMatch.setGoalsLocal(GoalsLocal);
					ThisFootballMatch.setGoalsVisitor(GoalsVisitor);
					// We add the FootballMatch object to the previously created ArrayList of FootballMatch type
					PartidoFutbol.add(ThisFootballMatch);
				}
				// We add the ArrayList object to the previously created ArrayList of ArrayList type;
				LeagueArrayList.add(PartidoFutbol);
				ScannerArray[i].close();
				}
				catch (FileNotFoundException e) {
					e.printStackTrace();
					System.out.println("The file of the competition " + args[i] + " was not found.");
				}
			}
			// We create a loop for each ArrayList of the ArrayList
			for (int i=0;i<LeagueArrayList.size();i++) {
				// We create a iterator with the ArrayList of FootballMatch type
				ListIterator<FootballMatch> it = LeagueArrayList.get(i).listIterator();
				// We create a counter that will hold how many draws were in the matches
				int drawCounter=0;
				// We create a loop where each turn the iterator will hold the values of each match
				while (it.hasNext()) {
					// If there wasn't a draw in the match, we will print the information of the match
					if (it.next().getGoalsLocal()!=it.previous().getGoalsVisitor()) {
						System.out.println(it.next().getLocalTeam() + "  " + it.previous().getVisitorTeam() +  "  " + it.next().getGoalsLocal() +  "  " + it.previous().getGoalsVisitor());
					}
					// Otherwise we will increment the draw counter
					else {
						drawCounter++;
					}
					// We go to the next match
					it.next();
				}
				// We print how many matches of the Liga Española have been printed and how many draws were
				System.out.println(it.nextIndex()-drawCounter + " matches of the " + args[i] + " have been displayed on the screen because " + drawCounter + " draws were omitted");
				System.out.println();
			}
		}
		else {
			System.out.println("Please try again, you didn't enter any competition");
		}
	}
}
