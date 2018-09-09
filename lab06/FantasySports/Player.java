package lab06.FantasySports;

public class Player implements SportProfessional{
	
	private String playerName; 
	private int age, seniority, ranking, speed;
	private double strength;
	
	//age should be above or equal to 20, 
	//seniority can be 0, 
	//ranking can be anything above 0, 
	//speed can be anything above 0 and below 50
	public Player(String name) { //sets default values for coach
		playerName = name;
		age = 20;
		seniority = 0;
		ranking = 0;
		speed = 10;
		strength = 25.0; //default
	}
	
	public Player(String name, int age, int seniority, int ranking, int speed) {
		playerName = name;
		this.age = age; // >=20
		this.seniority = seniority; // >=0
		this.ranking = ranking; // >0
		this.speed = speed; // >=10 & <=50
		strength = 25.0; //default
	}
	
	public void passYear() { //alters stats per year
		age++;
		seniority++;
		
		if(age > 35) ranking--;
		else ranking++;
		
		if(age > 40) speed -= 2;
		else if(age <= 40 && age > 30) speed--;
		else speed++;
	}
	
	public void playerStats() {
		//if player age goes above 35, team Strength is decreased. If seniority goes up to 5 years, 10 yrs, x+5 yeats, strength is increased.

		if (age > 35) strength--;
		else if (age <= 35 && seniority % 5 == 0) strength = strength + (seniority/5);

		if (ranking < 100) strength++;
		else if (ranking > 150) strength--;
	}

	public double strength() { //returns Strength
		return strength;
	}

	public int getAge() {
		return age;
	}
	
	public int getSeniority() {
		return seniority;
	}
	
	public int getRanking() {
		return ranking;
	}
	
	public int getSpeed() {
		return speed;
	}

}
