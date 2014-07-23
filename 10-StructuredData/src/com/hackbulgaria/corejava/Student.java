package com.hackbulgaria.corejava;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {

    @XmlElement
    private int studentId;
    
    @XmlElement
    private String name;
    
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }
    
   public Student() {
       
   }
   
   @Override
    public String toString() {
        return String.format("%d %s", studentId, name);
    }
}
