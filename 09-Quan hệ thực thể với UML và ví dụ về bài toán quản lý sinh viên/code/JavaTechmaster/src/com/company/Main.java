/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
 */
package com.company;

import java.util.ArrayList;
import java.util.List;

class Student {
    Integer id;
    private String name;
    private String email;
    private Integer age;
    private  List<Course>courses = new ArrayList<Course>();
    void addCourse(Course course) {
        courses.add(course);
    }
    void removeCourse(String name) {
        courses.removeIf((Course c) -> c.name == name);
    }
    //Constructor = "hàm khởi tạo"
    Student(Integer id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public void showInfo() {
        System.out.println("Id ="+id+" Name:"+name+" Email: "+email+" Age:"+age);
    }
}
class Course {
    String name;
    private List<Student> students = new ArrayList<Student>();
    void addStudent(Student student) {
        this.students.add(student);
    }
    void removeStudent(Integer studentId) {
        students.removeIf((Student s) -> s.id == studentId);
        //Param truyền vào removeIf là 1 "anonymous function" = hàm ko tên C
                                                              // = "khối lệnh" trong
    }
    Course(String name) {
        this.name = name;
    }
    void printAllStudents() {
        this.students.forEach(student -> {
            student.showInfo();
        });
    }
}

public class Main {
    public static void main(String[] args) {
        //Giờ chúng ta tạo ra 3 sinh viên, rồi cho vào 1 khoá học
        Student student1 = new Student(1, "Nguyễn Văn A", "email1@gmail.com", 18);
        Student student2 = new Student(2, "Nguyễn Văn B", "email2@gmail.com", 19);
        Student student3 = new Student(3,"Nguyễn Văn C", "email3@gmail.com", 20);
        //"Tạo ra" khoá học
        Course course1 = new Course("Lập trình Python ứng dụng thực tế");
        course1.addStudent(student1);
        course1.addStudent(student2);
        course1.addStudent(student3);
        //Làm sao để in ra 3 sinh viên trong khoá học này(để kiểm tra)
        System.out.println("Students of the course: "+course1.name+" is : ");
        course1.removeStudent(2);
        course1.printAllStudents();
        //Thêm nhiều khoá học mới
        Course course2 = new Course("Khoá học React Native qua bài tập");
        Course course3 = new Course("Lập trình ios với Swift 4");
        student1.addCourse(course1);
        student1.addCourse(course2);
        student1.addCourse(course3);

    }
}
