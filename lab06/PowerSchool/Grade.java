package lab06.PowerSchool;

//Kate and Daun

public class Grade {
    private int grade;
    private boolean audit;
    private boolean honors;
    private Course course;

    /* Grades must be between 0 and 1000 (which represents a score of 100%.
    A grade of 957*  would represent a score of 95.7%) (inclusive) */

    public Grade(boolean honors, boolean audited, int grade, Course course) {
        this.honors = honors;
        this.audit = audited;
        this.course = course;
        this.grade = grade;
    }

    public int gradeValue() {
        if (grade < 0)
            grade = 0;

        else if (grade > 1000)
            grade = 1000;

        if (grade > 1000)
            grade = 1000;

        else if (grade < 0)
            grade = 0;

        if (honors) {
            return (int)(grade * 1.05);
        }
        return (int) grade;
    }

    public boolean honors() {
        return honors;
    }

    public boolean audited() {
        return audit;
    }
}