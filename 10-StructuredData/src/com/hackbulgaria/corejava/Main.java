package com.hackbulgaria.corejava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamWriter;

import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;

public class Main {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        
        List<Student> students = new LinkedList<>();
        students.add(new Student(1, "Ivan"));
        students.add(new Student(13, "Pesho"));
        students.add(new Student(5, "Kiro"));
        
        CoreJavaCourse obj = new CoreJavaCourse(students, 2, "Core Java");
        Path path = Paths.get("C:\\Users\\RUSHI\\Desktop\\x.txt");
        
        JAXBContext jaxbContext = JAXBContext.newInstance(CoreJavaCourse.class);
        Marshaller marshal = jaxbContext.createMarshaller();
        marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshal.marshal(obj, path.toFile());
        
        Unmarshaller unmarshal = jaxbContext.createUnmarshaller();
        unmarshal.unmarshal(path.toFile());
        
        MappedNamespaceConvention mnc = new MappedNamespaceConvention();
        XMLStreamWriter streamWriter = new MappedXMLStreamWriter(mnc, new PrintWriter(new FileOutputStream(new File("C:\\Users\\RUSHI\\Desktop\\y.txt"))));
        marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshal.marshal(obj, streamWriter);       
    }

}
