package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class StudentService {
   @Autowired
    StudentRepository studentRepository;
   public void addStudent(Student student)
   {
       studentRepository.addStudent(student);
   }
   public void addTeacher(Teacher teacher)
   {
       studentRepository.addTeacher(teacher);
   }
   public void studentTeacherPair(String studentName,String teacherName)
   {
       studentRepository.addStudentTeacherPair(studentName,teacherName);
   }
   public Student studentByStudentName(String Sname)
   {
      return studentRepository.getStudent(Sname);
   }
   public Teacher teacherByTeacherName(String Tname)
   {
       return studentRepository.getTeacher(Tname);
   }
   public List<String> getStudentByTeacherName(String TeacherName)
   {
       //List<String>StudentList = new ArrayList<>();
       return studentRepository.StudentsByTeacherName(TeacherName);
   }
   public List<String> findAllStudent()
   {
       return studentRepository.findAllStudents();
   }
   public void deleteTeacherByName(String name)
   {
       studentRepository.deleteTeacherByName(name);
   }
   public void deleteAllTeacher()
   {
       studentRepository.deleteAllTeachers();
   }



}
