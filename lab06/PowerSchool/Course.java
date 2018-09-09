package lab06.PowerSchool;

//Tara

public class Course {
    private String courseTitle;
    private String teacher;
    private Student[] enrolledStudents = new Student[20];
    private Grade[] grades = new Grade[20];
    private int size = 0;
    private boolean honors;

    public Course(String teacher, String title, boolean honors) {
        this.teacher = teacher;
        courseTitle = title;
        this.honors = honors;
    }

    public String courseTitle() {
        return courseTitle;
    }

    public String courseTeacher() {
        return teacher;
    }

    public Grade gradeOf(Student someStudent) {
        int indexofStudent = 0;

        for (int i = 0; i < size; i++) {
            if (enrolledStudents[i].equals(someStudent)) {
                indexofStudent = i;
            }
        }

        return grades[indexofStudent];
    }

    public int numberEnrolled() {
        return size;
    }

    public Student[] enrolledStudents() {
        Student[] deepCopy = new Student[enrolledStudents.length];

        for (int i = 0; i < enrolledStudents.length; i++) {
            deepCopy[i] = enrolledStudents[i];
        }

        return deepCopy;
    }

    public Student topStudent() {
    	int highestGradeIndex = 0;

    	  for (int i = 1; i < enrolledStudents.length; i++) {
              if (grades[i] != null && grades[0] != null && grades[highestGradeIndex].gradeValue() < grades[i].gradeValue())
                  highestGradeIndex = i;
          }
          return enrolledStudents[highestGradeIndex];

    }

    public void setGrade(Student someStudent, int grade) {
        int indexOfStudent = 0;

//        for (int i = 0; i < enrolledStudents.length; i++) {
//            if (enrolledStudents != null && enrolledStudents[i].equals(someStudent)) {
//                indexOfStudent = i;
//            }
//        }

        for (int i = 0; i < size; i++) {
            if (enrolledStudents[i].equals(someStudent)) {
                indexOfStudent = i;
            }
        }

        Grade previousGrade = grades[indexOfStudent];
        grades[indexOfStudent] = new Grade(honors, previousGrade.audited(), grade, this);
    }

    public boolean enroll(Student someStudent, boolean audited) {
        int size = numberEnrolled();

        if (size >= 20 || !someStudent.addCourse(this))
            return false;

        // appends student to the end of the array
        int pos = 0;
        while (enrolledStudents[pos] != null)
            pos ++;

        enrolledStudents[pos] = someStudent;

        // creates a grade for the student in the course
        // -1 = null
        grades[pos] = new Grade(honors, audited, -1, this);
        this.size++;

        return true;
    }

    public void unenroll(Student someStudent) {
        int pos = 0;

        while (enrolledStudents[pos] != someStudent)
            pos++;

        for (int i = pos; i < enrolledStudents.length-1; i++) {
            enrolledStudents[i] = enrolledStudents[i+1];
            grades[i] = grades[i+1];
        }

        size--;
    }
}
