package lab06.PowerSchool;

//Kate and Daun

public class Student implements Comparable<Student> {
    private int gradYear;
    private String Name;
    private School Academy;
    protected Course[] schedule = new Course[10]; // has no more than ten courses
    private int size = 0;

    public Student(String name, int gradYear, School Academy) {
        Name = name;
        this.gradYear = gradYear;
        this.Academy = Academy;
        schedule = new Course[10];
    }

    public String getName() {
        return Name;
    }

    public int getGradYear() {
        return gradYear;
    }

    public School getAcademy() {
        return Academy;
    }

    public double getGPA() {   
    	double total = 0;
		int length = 0;
		
		for(int i = 0; i < schedule.length; i++) {
			if(schedule[i] != null && !schedule[i].gradeOf(this).audited()) {
					total += schedule[i].gradeOf(this).gradeValue();
					length++;
			}
		}
		return total/length;
    }

    public int compareTo(Student someOtherKid) {
        Double myGPA = this.getGPA();
        Double hisGPA = someOtherKid.getGPA();

        return myGPA.compareTo(hisGPA);
    }

    public boolean addCourse(Course someCourse) {
    	int index = -1;
		for(int i = 0; i < 10; i++) {
			if(schedule[i] == null) {
				index = i;	
			}
			
			if(schedule[i] == someCourse) {
				return false;
			}
		}
		if(index == -1){
			return false;
		}
		schedule[index] = someCourse;
		size++;
		return true;
    }

    public boolean dropCourse(Course someCourse) {
    	for(int i = 0; i < 10; i++) {
			if(schedule[i] == someCourse) {
				schedule[i] = null;
				size--;
				return true;
			}
		}
    	
		return false;
    }
}