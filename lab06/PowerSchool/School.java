package lab06.PowerSchool;

//Tara

import java.util.Arrays;

public class School {
    private final String name;
    private Student[] enrolledStudents = new Student[300];
    private int studentSize = 0;
    private Course[] schoolCourses = new Course[300];
    private int courseSize = 0;

    public School (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int enrolledStudents() {
        return studentSize;
    }

    public Course[] getCourses() {
        Course[] deepCopy = new Course[schoolCourses.length];

        for (int i = 0; i < schoolCourses.length; i++) {
            deepCopy[i] = schoolCourses[i];
        }

        return deepCopy;
    }

    public Student kidWithClassRank (int rank) {
        Arrays.sort(enrolledStudents);

        return enrolledStudents[rank];
    }

    public boolean addStudent (Student someKid) {

        if (enrolledStudents.length >= 300)
            return false;

        // appends student to end of the list
        int i = 0;
        while (enrolledStudents[i] != null) {
            // if there is already a student enrolled
            if (enrolledStudents[i].equals(someKid)) {
                return false;
            }
            i++;
        }

        enrolledStudents[i] = someKid;
        studentSize++;
        return true;
    }

    public void unenrollStudent (Student someKid) {
        int pos = 0;

        while (enrolledStudents[pos] != someKid)
            pos++;

        for (int i = pos; i < enrolledStudents.length; i++) {
            enrolledStudents[i] = enrolledStudents[i+1];
        }

        for (int j = 0; j < someKid.schedule.length; j++) {
            someKid.schedule[j].unenroll(someKid);
        }
        studentSize--;
    }

    public boolean createClass (String teacher, String title, boolean honors) {

        Course newCourse = new Course(teacher, title, honors);

        int i = 0;
        while (i < 300 && schoolCourses[i] != null) {
            // checks if there are no same courses
            if (schoolCourses[i].equals(newCourse)) {
                return false;
            }
            i++;
        }
        
        if(i >= 300) {
        	return false;
        	
        } else {
        	schoolCourses[i] = newCourse;
        	courseSize++;
            return true;
        }
    }

    public boolean enroll (Student kid, Course someCourse, boolean audited) {

        // checks if the course does exist in school
        boolean exists = false;

        for (int i = 0; i < courseSize; i++) {
            if (schoolCourses[i] != null && schoolCourses[i].equals(someCourse))
                exists = true;
        }

        if (exists) {
            return someCourse.enroll(kid, audited);
        }
        else
            return false;
    }

    public boolean unenroll (Student kid, Course someCourse) {

        // checks if course does exist in school
        boolean exists = false;

        for (int i = 0; i < schoolCourses.length; i++) {
            if (schoolCourses[i].equals(someCourse))
                exists = true;
        }

        if (exists) {
            // checks if the course exists in the student's schedule
            for (int j = 0; j < kid.schedule.length; j++) {
                if (kid.schedule[j].equals(someCourse)) {
                    someCourse.unenroll(kid);
                    return true;
                }
            }
        }

        return false;
    }
}