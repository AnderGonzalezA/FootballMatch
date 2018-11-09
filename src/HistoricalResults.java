import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ListIterator;
public class HistoricalResults{
	public static void main(String[] args) throws FileNotFoundException {
		File originFileToCopy=new File("C:\\Users\\ik013043Z1\\eclipse-workspace\\FootballMatch\\src\\FootballMatches.txt");
		Scanner sc = new Scanner(originFileToCopy);
		ArrayList<FootballMatch> PartidoFutbol = new ArrayList<FootballMatch>();
		while (sc.hasNext()) {
			String match = sc.nextLine();
			String[] information = match.split("::");
			int GoalsLocal = Integer.parseInt(information[2]);
			int GoalsVisitor = Integer.parseInt(information[3]);
			FootballMatch ThisFootballMatch=new FootballMatch();
			ThisFootballMatch.setLocalTeam(information[0]);
			ThisFootballMatch.setVisitorTeam(information[1]);
			ThisFootballMatch.setGoalsLocal(GoalsLocal);
			ThisFootballMatch.setGoalsVisitor(GoalsVisitor);
			PartidoFutbol.add(ThisFootballMatch);
		}
		ListIterator<FootballMatch> it = PartidoFutbol.listIterator();
		int drawCounter=0;
		while (it.hasNext()) {
			if (it.next().getGoalsLocal()!=it.previous().getGoalsVisitor()) {
				System.out.println(it.next().getLocalTeam() + "  " + it.previous().getVisitorTeam() +  "  " + it.next().getGoalsLocal() +  "  " + it.previous().getGoalsVisitor());
			}
			else {
				drawCounter++;
			}
			it.next();
		}
		//for (int i=0;i<PartidoFutbol.size();i++) {
			//System.out.println(PartidoFutbol.get(i).getLocalTeam() + "  " + PartidoFutbol.get(i).getVisitorTeam() +  "  " + PartidoFutbol.get(i).getGoalsLocal() +  "  " + PartidoFutbol.get(i).getGoalsVisitor());
		//}
		//System.out.println(PartidoFutbol.size() + " matches have been displayed on the screen.");
		System.out.println(it.nextIndex()-drawCounter + " matches have been displayed on the screen because " + drawCounter + " draws were omitted");
		sc.close();
	}
}