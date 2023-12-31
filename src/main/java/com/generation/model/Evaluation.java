package com.generation.model;

import java.util.List;
import java.util.Map;

public interface Evaluation {
    double getAverage();

    List<Course> getApprovedCourses();

    Map<String, Double> getCourseGrades();

}
