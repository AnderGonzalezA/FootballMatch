import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class HistoricalResults{
	public static void main(String[] args) throws FileNotFoundException {
		File originFileToCopy=new File("C:\\Users\\ik013043Z1\\eclipse-workspace\\FootballMatch\\src\\FootballMatches.txt");
		Scanner sc = new Scanner(originFileToCopy);
		int matchCounter=0;
		while (sc.hasNext()) {
			String match = sc.nextLine();
			String[] information = match.split("::");
			ArrayList<String> PartidoFutbol = new ArrayList<String>();
			for (int i=0;i<information.length;i++) {
				PartidoFutbol.add(information[i]);
			}
			int GoalsLocal = Integer.parseInt(PartidoFutbol.get(2));
			int GoalsVisitor = Integer.parseInt(PartidoFutbol.get(3));
			FootballMatch ThisFootballMatch=new FootballMatch();
			ThisFootballMatch.setLocalTeam(PartidoFutbol.get(0));
			ThisFootballMatch.setVisitorTeam(PartidoFutbol.get(1));
			ThisFootballMatch.setGoalsLocal(GoalsLocal);
			ThisFootballMatch.setGoalsVisitor(GoalsVisitor);
			System.out.println(ThisFootballMatch.getLocalTeam() + "  " + ThisFootballMatch.getVisitorTeam() +  "  " + ThisFootballMatch.getGoalsLocal() +  "  " + ThisFootballMatch.getGoalsVisitor());
			matchCounter++;
		}
		System.out.println(matchCounter + " matches have been displayed on the screen.");
		sc.close();
	}
}