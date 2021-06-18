package collections;

import java.util.Calendar;
import java.util.Objects;

public class Student extends Human {
    private String facultyName;

    public Student(String name, String surname, String middleName, Calendar dateOfBirth, String facultyName) {
        super(name, surname, middleName, dateOfBirth);
        this.facultyName = facultyName;
    }

    public Student(Human per, String facultyName) {
        super(per);
        this.facultyName = facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(facultyName, student.facultyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), facultyName);
    }

    @Override
    public String toString() {
        return "collections.Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", facultyName='" + facultyName + '\'' +
                '}';
    }
}