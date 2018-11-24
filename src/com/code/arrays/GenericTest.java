package com.code.arrays;

/**
 * 泛型测试类
 */
public class GenericTest {


    public static void main(String[] args){
        GenericArrays<Student> studentGenericArrays = new GenericArrays<>();
        studentGenericArrays.addLast(new Student("A","20"));
        studentGenericArrays.addLast(new Student("B","40"));
        studentGenericArrays.addLast(new Student("C","60"));
        studentGenericArrays.addLast(new Student("D","66"));
        studentGenericArrays.addLast(new Student("F","68"));
        studentGenericArrays.addLast(new Student("G","70"));
        System.out.println(studentGenericArrays.toString());
    }
}

class Student{

    private String name;

    private String score;

    public Student(String name, String score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(%s,%s)",name,score);
    }
}
