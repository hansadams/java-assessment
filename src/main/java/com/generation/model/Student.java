package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student
        extends Person
        implements Evaluation {
    private double average;

    private final List<Course> courses = new ArrayList<>();

    private final Map<String, Course> approvedCourses = new HashMap<>();

    private final Map<String, Double> courseGrades = new HashMap<>();

    private final List<Course> passedCourses = new ArrayList<>();

    public Student( String id, String name, String email, Date birthDate ) {
        super( id, name, email, birthDate );
    }

    public void enrollToCourse( Course course ) {
        //TODO implement this method
        //TODO 1. 'put' the course to student's approvedCourses aka HashMap<code, course> via registerApprovedCourse
        this.registerApprovedCourse(course);
        //TODO 2. ALSO, 'add' the course in the students' courses aka List<course>
        courses.add(course);

    }

    public void registerApprovedCourse( Course course ) {
        approvedCourses.put( course.getCode(), course );
        courseGrades.put( course.getCode(), (double) 0);
    }

    public boolean isCourseApproved( String courseCode ) {
        //TODO implement this method
        //TODO 1. HINT: does the students approvedCourses aka HashMap<code, course> 'contains the key' to courseCode?
        //TODO if so, what do you return? Otherwise, what else do you return?
        return approvedCourses.containsKey(courseCode);
    }

    // CHALLENGE IMPLEMENTATION: Read README.md to find instructions on how to solve.
    public List<Course> findPassedCourses( Course course ) {
        //TODO implement this method
        String courseId = course.getCode();

        if (this.getCourseGrades().get(courseId) >= 1d) {
            passedCourses.add(course);
        } else {
            passedCourses.remove(course);
        }

        return passedCourses;
    }

    public boolean isAttendingCourse( String courseCode ) {
        //TODO implement this method
        //TODO 1. HINT: does the students approvedCourses aka HashMap<code, course> 'contains the key' to courseCode?
        //TODO if so, what do you return? Otherwise, what else do you return?
        return approvedCourses.containsKey(courseCode);
    }

    @Override
    public double getAverage() {

        Double total = 0d;
        for(Map.Entry<String, Double> entry : courseGrades.entrySet()) {
            Double value = entry.getValue();

            total += value;
            average = total / courseGrades.size();
        }
        return average;
    }

    @Override
    public List<Course> getApprovedCourses() {
        //TODO implement this method
        //TODO 1. Hint, where do the list of courses come from?
        return courses;
    }

    public Map<String, Double> getCourseGrades() {
        //TODO implement this method
        //TODO 1. Hint, where do the list of courses come from?
        return courseGrades;
    }

    public void printGrades() {

        for(Map.Entry<String, Double> entry : courseGrades.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();

            System.out.println("Course{" + "code=" + key + ", grade=" + value + '}');
        }
    }

    @Override
    public String toString() {
        return "Student {" + super.toString() + ", gradeavg=" +average+ "}";
    }

}
