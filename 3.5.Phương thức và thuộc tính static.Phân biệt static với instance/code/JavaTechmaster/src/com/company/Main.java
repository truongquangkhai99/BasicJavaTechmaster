/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
Phương thức và thuộc tính static.Phân biệt static với instance
 */
package com.company;

class Student {
    private String name;
    private int yearOfBirth;
    //static là thuộc tính ảnh hưởng đến tất cả các đối tượng
    public static int numberOfStudents;
    //Hàm khởi tạo - constructor = "non static" = hàm instance
    Student(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        //Có thể thay đổi giá trị thuộc tính static ở đây
        numberOfStudents++;
    }
    static int getNumberOfStudents() {
        //Đây là 1 phương thức static
        //this.name = "abb";//Bên trong phương thức static ko được gọi đến thuộc tính instance
        return numberOfStudents;//phương thức static có thể gọi "thuộc tính static"
    }
}
public class Main {
    public static void main(String[] args) {
        //Tạo ra 3 đối tượng Student
        Student student1 = new Student("Nguyễn Văn A", 1993);
        Student student2 = new Student("Nguyễn Văn B", 1994);
        Student student3 = new Student("Nguyễn Văn C", 1995);
        //Thuộc tính static thay đổi => giá trị thuộc tính ở tất cả các object thay đổi theo
        System.out.println(student1.numberOfStudents);
        System.out.println(student2.numberOfStudents);
        System.out.println(student3.numberOfStudents);
        System.out.println("Có thể gọi đến thuộc tính static từ tên class");
        System.out.println(Student.numberOfStudents);
        System.out.println("Có thể gọi đến PHƯƠNG THỨC static từ tên class");
        System.out.println(Student.getNumberOfStudents());


    }
}
