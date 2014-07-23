package com.hackbulgaria.corejava;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CoreJavaCourse {

    @XmlElement
    List<Student> enrolledStudents;    

    @XmlElement
    private int courseId;
    
    @XmlElement
    public String courseName;
    
    public CoreJavaCourse(List<Student> enrolledStudents, int courseId, String courseName) {
        this.enrolledStudents = enrolledStudents;
        this.courseId = courseId;
        this.courseName = courseName;
    }
    
    public CoreJavaCourse () {
        
    }
    
    @Override
    public String toString() {
        return String.format("%s %d %s", enrolledStudents.toString(), courseId, courseName);
    }
}
