package com.example.haohoang.camera.database.classlist;

import com.example.haohoang.camera.models.Student;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Created by haohoang on 3/1/17.
 */

public class ClassItem {
    private int numberStudent;
    private String nameClass;
    private String classRoom;

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public ClassItem(int numberStudent, String nameClass, String classRoom) {
        this.numberStudent = numberStudent;
        this.nameClass = nameClass;
        this.classRoom = classRoom;
        this.students = new Vector<>();
    }

    public int getNumberStudent() {
        return numberStudent;
    }

    public void setNumberStudent(int numberStudent) {
        this.numberStudent = numberStudent;
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public void removeStudent(Student student){
        students.remove(student);
    }
    public void removeStudent(String id){
        Iterator iterator=students.iterator();
        while (iterator.hasNext()){
            Student st= (Student) iterator.next();
            if (st.getId().equalsIgnoreCase(id)){
                iterator.remove();
            }
        }
    }
    public boolean isStudentInClass(String id){
        Iterator iterator=students.iterator();
        while (iterator.hasNext()){
            Student st= (Student) iterator.next();
            if (st.getId().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }
    public boolean isStudentInClass(Student student){
        Iterator iterator=students.iterator();
        while (iterator.hasNext()){
            Student st= (Student) iterator.next();
            if (st.getId().equalsIgnoreCase(student.getId())){
                return true;
            }
        }
        return false;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
