public class FootballMatch {

	private String localTeam;
	private String visitorTeam;
	private int goalsLocal;
	private int goalsVisitor;

	public String getLocalTeam() {
		return this.localTeam;
	}

	public void setLocalTeam(String LocalTeam) {
		this.localTeam=LocalTeam;
	}

	public String getVisitorTeam() {
		return visitorTeam;
	}

	public void setVisitorTeam(String visitorTeam) {
		this.visitorTeam=visitorTeam;
	}

	public int getGoalsLocal() {
		return goalsLocal;
	}

	public void setGoalsLocal(int goalsLocal) {
		this.goalsLocal=goalsLocal;
	}

	public int getGoalsVisitor() {
		return goalsVisitor;
	}

	public void setGoalsVisitor(int goalsVisitor) {
		this.goalsVisitor=goalsVisitor;
	}
}