package lab06.PowerSchool;

//Camellia and Rebecca

public class SchoolRunner {

	public static void main(String[] args) {

		int testing = 0;
		boolean tempbool;

		School school = new School("Bergen County Academies");

		
/**SCHOOL TESTER_________________________________________________________________________________________________**/		
		System.out.println("SCHOOL TESTER");		
		
		school.createClass("Dr. Penev", "Adv. Analysis II", false); //0
		school.createClass("Ms. Feuss", "Intro Chemistry", true); //1
		school.createClass("Mr. Isecke", "AP CompSci", true); //2
		school.createClass("Ms. Kim", "World History II", false); //3
		school.createClass("Mr. Respass", "C Data Structures", false); //4
		school.createClass("Mr. Marmora", "Gym", false); //5
		school.createClass("Dr. Heitzman", "AP Calculus AB", true); //6
		school.createClass("Ms. Kaba", "American Lit I", false); //7
		school.createClass("Ms. Berwick", "American Lit II", true); //8
		school.createClass("Mr. Demeter", "World History I", false); //9
		school.createClass("Mr. Pinyan", "Discrete", true); //10

		Course[] courses = school.getCourses();
		
		
		int i = 2;
		String courseTitle = "{";
		
		while(courses[i-2] != null) {
			
			courseTitle += (courses[i-2].courseTitle());
			
			if(courses[i-1] != null) {
				courseTitle += ", ";
			} else {
				courseTitle += "}";
			}
			
			i++;
		}
		
		System.out.println("Course Array: " + courseTitle);
		System.out.println("");
		
		
		i = 2;
		String courseTeacher = "{";
		
		while(courses[i-2] != null) {
			
			courseTeacher += (courses[i-2].courseTeacher());
			
			if(courses[i-1] != null) {
				courseTeacher += ", ";
			} else {
				courseTeacher += "}";
			}
			
			i++;
		}
		
		System.out.println("Teacher Array: " + courseTeacher);
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

/**STUDENT TESTER_________________________________________________________________________________________________**/		

		System.out.println("STUDENT TESTERS");

// STUDENT 1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		Student s1 = new Student("Camellia Guan", 2021, school);
		System.out.println("STUDENT ONE");
		if (s1.getName().equals("Camellia Guan")) {
			System.out.println("Student 1's name is Camellia Guan. The returned value is correct.");
			testing++;
		} else {
			System.out.println("!!!Student 1's name should have been Camellia Guan. The method returned: " + s1.getName());
		}
		
		if (s1.getGradYear() == 2021) {
			System.out.println("Student 1's grad year is 2021 (just a test year). The returned value is correct.");
			testing++;
		} else {
			System.out.println("!!!Student 1's grad year should be 2021. The method returned: " + s1.getGradYear());
		}
		
		if (s1.getAcademy().getName().equals("Bergen County Academies")) {
			System.out.println("Student 1's school is Bergen County Academies. The returned value is correct.");
			testing++;
		} else {
			System.out.println("!!!Student 1's school should be Bergen County Academies. The method returned: " + s1.getAcademy().getName());
		}

		System.out.println("");
		System.out.println("*~*~*~*");

	
// STUDENT 2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		Student s2 = new Student("Rebecca Xu", 2020, school);
		System.out.println("STUDENT ONE");
		if (s2.getName().equals("Rebecca Xu")) {
			System.out.println("Student 2's name is Rebecca Xu. The returned value is correct.");
			testing++;
		} else {
			System.out.println("!!!Student 2's name should have been Rebecca Xu. The method returned: " + s2.getName());
		}
		
		if (s2.getGradYear() == 2020) {
			System.out.println("Student 2's grad year is 2020. The returned value is correct.");
			testing++;
		} else {
			System.out.println("!!!Student 2's grad year should be 2020. The method returned: " + s2.getGradYear());
		}

		if (s2.getAcademy().getName().equals("Bergen County Academies")) {
			System.out.println("Student 2's school is Bergen County Academies. The returned value is correct.");
			testing++;
		} else {
			System.out.println("!!!Student 2's school should be Bergen County Academies. The method returned: " + s2.getAcademy().getName());
		}
		
		System.out.println("");		
		System.out.println("Percent Correct: " + (testing*1000/6/10.0) + " %");
		testing = 0;
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		
/**GRADE TESTERS_________________________________________________________________________________________________**/		

// MATH GRADE TESTER~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		System.out.println("MATH GRADE TESTER");
		
		Grade gmath = new Grade(false, true, 800, courses[0]); // not honors, audit

		System.out.println("Your math grade is: " + gmath.gradeValue() + ". This should display 800.");

		if (gmath.gradeValue() == 800) { // tests to see if the grade is within range
			testing++;
		}


		tempbool = gmath.audited();
		if (tempbool) {
			System.out.println("Audit class: " + gmath.audited() + ". Correctly displays 'true'.");
			testing++;

		} else {
			System.out.println("!!!Something is not right. Audited should be true.");
		}

		tempbool = gmath.honors();
		if (tempbool) {
			System.out.println("!!!Something is not right. Honors should be false.");

		} else {
			System.out.println("Honors class: " + gmath.honors() + ". Correctly displays 'false'.");
			testing++;
		}

		System.out.println("");
		System.out.println("Percent Correct: " + (testing*1000/3/10.0) + " %");
		testing = 0;
		
		System.out.println("");
		System.out.println("*~*~*~*");


// SCIENCE GRADE TESTER~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		System.out.println("SCIENCE GRADE TESTER");
		Grade gsci = new Grade(true, false, 1049, courses[1]); // honors, no audit
		
		System.out.println("Your science grade is: " + gsci.gradeValue() + ". This should display 1050.");

		if (gsci.gradeValue() == 1050) { // tests to see if the grade is within range
			testing++;
		}

		tempbool = gsci.audited();
		if (tempbool) {
			System.out.println("!!!Something is not right. Audited should be false.");

		} else {
			System.out.println("Audit class: " + gsci.audited() + ". Correctly displays 'false'.");
			testing++;
		}

		tempbool = gsci.honors();
		if (tempbool) {
			System.out.println("Honors class: " + gsci.honors() + ". Correctly displays 'true'.");
			testing++;

		} else {
			System.out.println("!!!Something is not right. Honors should be true.");

		}
		System.out.println("");		
		System.out.println("Percent Correct: " + (testing*1000/3/10.0) + " %");
		testing = 0;
		
		System.out.println("");
		System.out.println("*~*~*~*");


// COMPSCI GRADE TESTER~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		System.out.println("COMPSCI GRADE TESTER");
		Grade gcompsci = new Grade(true, true, 950, courses[2]); // honors, audit

		System.out.println("Your compsci grade is: " + gcompsci.gradeValue() + ". This should display 997.");

		if (gcompsci.gradeValue() == (int)(950*1.05)) { // tests to see if the grade is within range
			testing++;
		}


		tempbool = gcompsci.audited();
		if (tempbool) {
			System.out.println("Audit class: " + gcompsci.audited() + ". Correctly displays 'true'.");
			testing++;

		} else {
			System.out.println("!!!Something is not right. Audited should be true.");
		}

		tempbool = gcompsci.honors();
		if (tempbool) {
			System.out.println("Honors class: " + gcompsci.honors() + ". Correctly displays 'true'.");
			testing++;

		} else {
			System.out.println("!!!Something is not right. Honors should be true.");

		}
		
		System.out.println("");		
		System.out.println("Percent Correct: " + (testing*1000/3/10.0) + " %");
		testing = 0;
		
		System.out.println("");
		System.out.println("*~*~*~*");


// HISTORY GRADE TESTER~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		System.out.println("HISTORY GRADE TESTER");
		Grade ghistory = new Grade(false, false, -10, courses[3]); // no honors, no audit

		System.out.println("Your history grade is: " + ghistory.gradeValue() + ". This should display 0.");

		if (ghistory.gradeValue() == 0) { // tests to see if the grade is within range
			testing++;
		}


		tempbool = ghistory.audited();
		if (tempbool) {
			System.out.println("!!!Something is not right. Audited should be false.");

		} else {
			System.out.println("Audit class: " + ghistory.audited() + ". Correctly displays 'false'.");
			testing++;
		}

		tempbool = ghistory.honors();
		if (tempbool) {
			System.out.println("!!!Something is not right. Honors should be false.");

		} else {
			System.out.println("Honors class: " + ghistory.honors() + ". Correctly displays 'false'.");
			testing++;
		}

		System.out.println("");		
		System.out.println("Percent Correct: " + (testing*1000/3/10.0) + " %");
		testing = 0;
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


/**COURSE TESTERS_________________________________________________________________________________________________**/		
		
// MATH COURSE TESTER~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		System.out.println("MATH COURSE TESTER");
		System.out.println("- This course is taught by " + courses[0].courseTeacher() + ", and the course is " + courses[0].courseTitle() + ".");
		
		if(courses[0].courseTeacher().equals("Dr. Penev") && courses[0].courseTitle().equals("Adv. Analysis II")) {
			testing++;
		}

		//ENROLL AND SETGRADE
		school.enroll(s1, courses[0], true);
		courses[0].setGrade(s1, 82);
		
		school.enroll(s2, courses[0], true);
		courses[0].setGrade(s2, 91);

		System.out.println("- Number of students in math: " + courses[0].numberEnrolled());
		
		if(courses[0].numberEnrolled() == 2) {
			testing++;
		}
		

		System.out.println("");		
		System.out.println("Percent Correct: " + (testing*1000/2/10.0) + " %");
		testing = 0;

		System.out.println("");
		System.out.println("*~*~*~*");

		
// SCIENCE COURSE TESTER~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		System.out.println("SCIENCE COURSE TESTER");
		System.out.println("- This course is taught by " + courses[1].courseTeacher() + ", and the course is " + courses[1].courseTitle() + ".");
		
		if(courses[1].courseTeacher().equals("Ms. Feuss") && courses[1].courseTitle().equals("Intro Chemistry")) {
			testing++;
		}
		
		//ENROLL AND SETGRADE
		school.enroll(s1, courses[1], false); //82
		courses[1].setGrade(s1, 82);
		
		school.enroll(s2, courses[1], false); //78
		courses[1].setGrade(s2, 78);

		System.out.println("- Number of students in science: " + courses[1].numberEnrolled());
		
		if(courses[1].numberEnrolled() == 2) {
			testing++;
		}
		
		
		System.out.println("");		
		System.out.println("Percent Correct: " + (testing*1000/2/10.0) + " %");
		testing = 0;

		System.out.println("");
		System.out.println("*~*~*~*");

		
		
// COMPSCI COURSE TESTER~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		System.out.println("COMPSCI COURSE TESTER");
		System.out.println("- This course is taught by " + courses[2].courseTeacher() + ", and the course is " + courses[2].courseTitle() + ".");
		
		if(courses[2].courseTeacher().equals("Mr. Isecke") && courses[2].courseTitle().equals("AP CompSci")) {
			testing++;
		}
		
		//ENROLL AND SETGRADE
		school.enroll(s1, courses[2], true);
		courses[2].setGrade(s1, 92);
		
		school.enroll(s2, courses[2], true);		
		courses[2].setGrade(s2, 97);
		System.out.println("- Number of students in compsci: " + courses[2].numberEnrolled());

		if(courses[2].numberEnrolled() == 2) {
			testing++;
		}
		
		courses[2].unenroll(s1);
		tempbool = s1.dropCourse(courses[2]);
		
		if(tempbool) {
			System.out.println("\n- Course successfully dropped.");
			testing++;
		}
		
		System.out.println("- Number of students in compsci: " + courses[2].numberEnrolled());
		
		school.enroll(s1, courses[2], true);
		courses[2].setGrade(s1, 92);
		
		if(courses[2].numberEnrolled() == 2) {
			System.out.println("\n- " + s1.getName() + " was reenrolled.");
			testing++;
		}
		
		System.out.println("- Number of students in compsci: " + courses[2].numberEnrolled());
		
		
		System.out.println("");		
		System.out.println("Percent Correct: " + (testing*1000/4/10.0) + " %");
		testing = 0;

		System.out.println("");
		System.out.println("*~*~*~*");

		
// HISTORY COURSE TESTER~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		System.out.println("HISTORY COURSE TESTER");
		System.out.println("- This course is taught by " + courses[3].courseTeacher() + ", and the course is " + courses[3].courseTitle() + ".");
		
		if(courses[3].courseTeacher().equals("Ms. Kim") && courses[3].courseTitle().equals("World History II")) {
			testing++;
		}
		
		//ENROLL AND SETGRADE
		school.enroll(s1, courses[3], false);
		courses[3].setGrade(s1, 84);
		
		school.enroll(s2, courses[3], false);
		courses[3].setGrade(s2, 74);
		
		System.out.println("- Number of students in history: " + courses[3].numberEnrolled());

		if(courses[3].numberEnrolled() == 2) {
			testing++;
		}
		

		System.out.println("");		
		System.out.println("Percent Correct: " + (testing*1000/2/10.0) + " %");
		testing = 0;
		
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

/**GPA TESTERS_________________________________________________________________________________________________**/		
	
		System.out.println("GPA TESTER");
		System.out.println("Student 1's GPA (average): " + s1.getGPA()); //should be 83.0
		System.out.println("Student 2's GPA (average): " + s2.getGPA()); //SHOULD BE 76.0
		
		System.out.println("\nThe top student in math is: " + courses[0].topStudent().getName());
		System.out.println("The top student in science is: " + courses[1].topStudent().getName());
		System.out.println("The top student in compsci is: " + courses[2].topStudent().getName());
		System.out.println("The top student in history is: " + courses[3].topStudent().getName() + "\n");

		
		if (s1.getGPA() == 83.0) { //average
			testing++;
		}
		
		if (s2.getGPA() == 76.0) { //average
			testing++;
		}
		
		if (s1.compareTo(s2) > 0) {
			System.out.println("compareTo check is successful.");
			testing++;
			
		} else {
			System.out.println("compareTo check is unsuccessful.");
		}
		
		System.out.println("\nPercent Correct: " + (testing*1000/3/10.0) + " %"); //only thing wrong
		testing = 0;
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
/**LIMIT TESTERS_________________________________________________________________________________________________**/
		System.out.println("LIMIT TESTERS");
		
		
		int schoolSize = 300;
		int totalCourses = 300;
		int studentCourseNum = 10;
		int courseSize = 20;
		
		courses[0].unenroll(s1);
		courses[1].unenroll(s1);
		courses[2].unenroll(s1);
		courses[3].unenroll(s1);

		
		for(int j = 0; j < studentCourseNum; j++) { //courseSize for student limit
			school.enroll(s1, courses[j], true);		
			courses[j].setGrade(s1, 97);			
		}
		
		if(!school.enroll(s1, courses[10], true)) {
			testing++;
			System.out.println("- Correct. Student is unable to enroll in more than 10 classes.");
		} else {
			System.out.println("!!!Student cannot have more than 10 classes, but has enrolled in more.");
		}
		
		
		
		
		courses[1].enroll(new Student("Hi", 2020, school), true);
		
		for(int j = 0; j < 20; j++) {
			courses[1].enroll(new Student("Hi", 2020, school), true);
		}
		
		if(!courses[1].enroll(new Student("Hi", 2020, school), true)) {
			testing++;
			System.out.println("- Correct. Course is unable to enroll in more than 20 students.");
		} else {
			System.out.println("!!!Course cannot have more than 20 students, but has enrolled in more.");
		}

		
		
		for(int j = 0; j < schoolSize; j++) {
			school.addStudent(new Student("No", 2020, school));
		}
		
		if(!school.addStudent(new Student("Hi", 2020, school))) {
			testing++;
			System.out.println("- Correct. School is unable to enroll in more than 300 students.");
		} else {
			System.out.println("!!!School cannot have more than 300 students, but has enrolled in more.");
		}
		
		for(int j = 0; j < totalCourses; j++) {
			String add = "1";
			String className = "Ha";
			
			school.createClass("No", className, true);
			
			className += add;
			
		}
		
		if(!school.createClass("No", "Ha", true)) {
			testing++;
			System.out.println("- Correct. School is unable to create more than 300 classes.");
		} else {
			System.out.println("!!!School cannot have more than 300 classes, but has created more.");
		}
		
				
		System.out.println("\nPercent Correct: " + (testing*1000/4/10.0) + " %"); //only thing wrong

		
		
		
	}	

}
