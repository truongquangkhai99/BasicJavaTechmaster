/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
Các hàm getter, setter là gì?.
Ví dụ về lấy giá trị các trường có kiểu private
=> data hiding hay Encapsulation(tính đóng gói)
 */
package com.company;

class Student {
    //Cho hết các thuộc tính thành "private", hay "ẩn đi"
    private int studentId;
    private String firstName;
    private String lastName;
    //studentId chỉ nên set giá trị ở hàm constructor
    Student(int studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Muốn thay đổi giá trị trường private ? => dùng hàm setternly
    /*
    void setStudentId(int studentId) {//Nếu ko có setter, thuộc tính này là "read-o"
        this.studentId = studentId;
    }
    */
    void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }
    //Tương tự với lastname
    void setLastName(String newLastName) {
        lastName = newLastName;
    }
    //Để xem giá trị các trường private, sử dụng getternly
    String getLastName() {
        return lastName;
    }
    String getFirstName() {
        return firstName.toLowerCase();//Có thể thay đổi giá trị khi hiển thị ra
    }
    int getStudentId() {
        return studentId;
    }
}
public class Main {
    public static void main(String[] args) {
        Student student = new Student(12345, "nguyễn", "đức");
        //student.studentId = 12345;//ok, nhưng ko đảm bảo tính bao gói()
        //student.setFirstName("Nguyen");
        //student.setStudentId(12345);
        student.setFirstName("Nguyễn");
        student.setLastName("Đức Hoàng");
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(student.getStudentId());

    }
}
