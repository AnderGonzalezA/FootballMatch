import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ListIterator;
public class LaLigaEspanolaResults{
	public static void main(String[] args) throws FileNotFoundException {
		// We create a file object with a previously created text file
		File originFileToCopy=new File("C:\\Users\\ik013043Z1\\eclipse-workspace\\FootballMatch\\src\\LaLigaEspanolaMatches.txt");
		// We create a scanner object with the previously created file object
		Scanner sc = new Scanner(originFileToCopy);
		// We create an empty ArrayList object of FootballMatch type
		ArrayList<FootballMatch> PartidoFutbol = new ArrayList<FootballMatch>();
		// We create a loop where each line of the text file will be a match
		while (sc.hasNext()) {
			// We create a string object with the next line
			String match = sc.nextLine();
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
		// We create a iterator with the ArrayList of FootballMatch type
		ListIterator<FootballMatch> it = PartidoFutbol.listIterator();
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
		//for (int i=0;i<PartidoFutbol.size();i++) {
			//System.out.println(PartidoFutbol.get(i).getLocalTeam() + "  " + PartidoFutbol.get(i).getVisitorTeam() +  "  " + PartidoFutbol.get(i).getGoalsLocal() +  "  " + PartidoFutbol.get(i).getGoalsVisitor());
		//}
		//System.out.println(PartidoFutbol.size() + " matches have been displayed on the screen.");
		// We print how many matches have been printed and how many draws were
		System.out.println(it.nextIndex()-drawCounter + " matches have been displayed on the screen because " + drawCounter + " draws were omitted");
		sc.close();
	}
}