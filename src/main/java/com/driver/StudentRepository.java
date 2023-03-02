package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student>studentMap = new HashMap<>();
    HashMap<String,Teacher>teacherMap = new HashMap<>();
    HashMap<String, List<String>>studentTeacherMap = new HashMap<>();

    public StudentRepository(HashMap<String, Student> studentMap, HashMap<String, Teacher> teacherMap, HashMap< String,List<String>> studentTeacherMap) {
        this.studentMap = studentMap;
        this.teacherMap = teacherMap;
        this.studentTeacherMap = studentTeacherMap;
    }
    public void addStudent(Student student)
    {
        studentMap.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher)
    {
        teacherMap.put(teacher.getName(),teacher);
    }
    public void addStudentTeacherPair(String studentName,String teacherName)
    {
        if (studentTeacherMap.containsKey(teacherName))
        {
            studentTeacherMap.get(teacherName).add(studentName);
        }
        else
        {
            List<String>list = new ArrayList<>();
            list.add(studentName);
            studentTeacherMap.put(teacherName,list);
        }
    }
    public Student getStudent(String studentName)
    {
        return studentMap.get(studentName);
    }
    public Teacher getTeacher(String teacherName)
    {
        return teacherMap.get(teacherName);
    }
    public List<String> StudentsByTeacherName(String name)
    {
        return studentTeacherMap.get(name);
    }
    public List<String>findAllStudents()
    {
        List<String>studentList = new ArrayList<>();
        for(String s:studentMap.keySet())
        {
            studentList.add(s);
        }
        return studentList;
    }
    public void deleteTeacherByName(String teacherName)
    {
         List<String>list = studentTeacherMap.get(teacherName);

         for (String t:list)
         {
             studentMap.remove(t);
         }
         teacherMap.remove(teacherName);
         studentTeacherMap.remove(teacherName);

    }
    public void deleteAllTeachers()
    {
        for (String teacher:studentTeacherMap.keySet())
        {
            deleteTeacherByName(teacher);
        }
    }




}
