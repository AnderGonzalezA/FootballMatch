import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ListIterator;
public class TeamArrayListOfArrayLists {
	public static void main(String[] args) {
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
				FileArray[i]=new File("C:\\Users\\ik013043z1\\eclipse-workspace\\FootballMatch\\src\\" + args[i] + "Matches.txt");
				try {
					// We create a scanner object with the previously created file object
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
							// We create a file object with a previously created text file
							File FileArrayTeam = new File("C:\\Users\\ik013043z1\\eclipse-workspace\\FootballMatch\\src\\Teams.txt");
							try {
								// We create a scanner object with the previously created file object
								Scanner localTeamScanner = new Scanner(FileArrayTeam);
								boolean localTeamFound=false;
								String localTeamName=it.next().getLocalTeam();
								while (localTeamScanner.hasNext() && localTeamFound==false) {
									// We create a string object with the next line
									String localTeamInformation = localTeamScanner.nextLine();
									// We create an array with the values of each part of the line, separated by "::"
									String[] localTeamArray = localTeamInformation.split("::");
									if (localTeamArray[0].equals(localTeamName)) {
										Team localTeam = new Team();
										localTeam.setTeamName(localTeamArray[0]);
										localTeam.setCoach(localTeamArray[1]);
										System.out.print(localTeam.getTeamName() + "  " + localTeam.getCoach() + "  ");
										localTeamFound=true;
									}
								}
								localTeamScanner.close();
								Scanner visitorTeamScanner = new Scanner(FileArrayTeam);
								boolean visitorTeamFound=false;
								String visitorTeamName=it.previous().getVisitorTeam();
								while (visitorTeamScanner.hasNext() && visitorTeamFound==false) {
									// We create a string object with the next line
									String visitorTeamInformation = visitorTeamScanner.nextLine();
									// We create an array with the values of each part of the line, separated by "::"
									String[] visitorTeamArray = visitorTeamInformation.split("::");
									if (visitorTeamArray[0].equals(visitorTeamName)) {
										Team visitorTeam = new Team();
										visitorTeam.setTeamName(visitorTeamArray[0]);
										visitorTeam.setCoach(visitorTeamArray[1]);
										System.out.print(visitorTeam.getTeamName() + "  " + visitorTeam.getCoach() + "  ");
										visitorTeamFound=true;
									}
								}
								visitorTeamScanner.close();
								System.out.print(it.next().getGoalsLocal() +  "  " + it.previous().getGoalsVisitor());
								System.out.println();
								// We go to the next match
								it.next();
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						// Otherwise we will increment the draw counter and remove the match from the ArrayList
						else {
							drawCounter++;
							it.remove();
						}
					}
					// We print how many matches have been printed and how many draws were
					System.out.println(LeagueArrayList.get(i).size() + " matches have been displayed on the screen because " + drawCounter + " draws were omitted");
					System.out.println();
			}
		// If the user has not entered any argument we ask him for it
		}
		else {
			System.out.println("Please try again, you didn't enter any competition");
		}
	}

}