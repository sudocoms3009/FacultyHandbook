package com.example.facultyhandbook;


public class Schools {

    String schoolName;
    String schoolDescriptions;
    String numCourses;


    public Schools(String schoolName, String schoolDescriptions,  String numCourses) {
        this.schoolName = schoolName;
        this.schoolDescriptions = schoolDescriptions;
        this.numCourses = numCourses;
    }

    public String getschoolName() {
        return schoolName;
    }

    public void setschoolName(String title) {
        this.schoolName = schoolName;
    }

    public String getschoolDescriptions() {
        return schoolDescriptions;
    }

    public void setschoolDescriptions(String schoolDescriptions) {
        this.schoolDescriptions = schoolDescriptions;
    }

    public String getnumCourses() {
        return numCourses;
    }

    public void setnumCourses(String numCourses) {
        this.numCourses = numCourses;
    }
}
