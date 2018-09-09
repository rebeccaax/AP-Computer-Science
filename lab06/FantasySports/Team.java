package lab06.FantasySports;

public class Team {

	private Player[] players;
	private Coach coach;
	private String teamName;
	private double teamStrength;
	
	public Team(Coach coach, Player[] players, String teamName) {
		this.coach = coach;
		this.players = players;
		this.teamName = teamName;
	}
	
	public double overallStrength() {
		double playerStrength, coachStrength;
		double totalPlayerStr = 0;
		
		for(int i = 0; i < players.length; i++) {
			playerStrength = players[i].strength();
			totalPlayerStr += playerStrength;
		}

		coachStrength = coach.strength();
		
		teamStrength = (totalPlayerStr + coachStrength)/(players.length + 1); //basically an average
		return teamStrength;
	}

	public String getName() {
		return teamName;
	}
	
	
	public Team playGame(Team OppTeam) {
		double oppTeamStrength = 0, homeTeamStrength = 0;
		
		double random = (Math.random())*20;
		
		oppTeamStrength = OppTeam.overallStrength();
		homeTeamStrength = this.overallStrength();
		
		oppTeamStrength += random;
		homeTeamStrength += random;
		
		if(oppTeamStrength > homeTeamStrength) {
			return OppTeam;
		} else if(oppTeamStrength < homeTeamStrength) {
			return this;
		} else {
			double temp = Math.random();
			
			if(temp >= 0.5) {
				return OppTeam;
			} else if (temp < 0.5) {
				return this;
			}
		}
		return null;
	}
	
	
	

}
