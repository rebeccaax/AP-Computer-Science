package lab06.FantasySports;

public class Coach implements SportProfessional{
	
	private String coachName; 
	private int age, seniority, experience, leadership;
	private double strength;

	public Coach(String name) { //sets default values for coach
		coachName = name;
		age = 30;
		seniority = 0;
		experience = 0;
		leadership = 20;
		strength = 10.0;
	}
	
	public Coach(String name, int age, int seniority, int experience, int leadership) {
		coachName = name;
		this.age = age; // >=30
		this.seniority = seniority; // >=0
		this.experience = experience; // >=0
		this.leadership = leadership; // >=20
		strength = 10.0;
	}
	
	public void passYear() { //alters stats per year
		age++;
		seniority++;
		experience++;
		leadership++;
	}
	
	public void coachStats() { 
		
		if(experience > 10) strength += 2;
		
		if(seniority > 5) strength++;
		
		if(leadership > 25) strength++;
		
		if(age >= 50) strength--;		
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
	
	public int getExperience() {
		return experience;
	}
	
	public int getLeadership() {
		return leadership;
	}

}
