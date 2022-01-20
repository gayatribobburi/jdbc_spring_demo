package com.dxc;

import java.sql.SQLException;
import java.util.List;
import com.dxc.dao.StudentDao;
import com.dxc.dao.TeacherDao;
import com.dxc.model.Student;
import com.dxc.model.Teacher;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        findAllStudents();
    }

    static void findAllStudents(){
        
        StudentDao dao = new studentDao();
        try {
            List<Students> Students = dao.findAll();
            if (Students.size() == 0) {
                System.out.println("No Students found");
                return;
            }
            Students.forEach(bk -> System.out.println(bk));
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }

    static void createStudents() {
        Student student = new student("rani", "math", "978-0");
       

        List<Student> students = List.of("rani");
        StudentDao studentDao = new StudentDao();

        student.forEach(sk -> {
            try {
                int rows = studentDao.save(sk);
                System.out.println("Rows affected: " + rows);
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
            public static void main(String[] args) {
                findAllStudents();
            }
        
            public static void findAllTeacher(){
                
                TeacherDao dao = new Teacher();
                try {
                    List<Teacher> Teachers = dao.findAll();
                    if (Teachers.size() == 0) {
                        System.out.println("No Teachers found");
                        return;
                    }
                    Teachers.forEach(tk -> System.out.println(tk));
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println(e.getMessage());
                }
        
            }
        
            static void createTeachers() {
                Teacher teacher = new teacher("radha", "science", "999-0");
               
        
                List<Teacher> sTeachers = List.of("radha");
                TeachertDao teacherDao = new TeacherDao();
        
                teacher.forEach(tk -> {
                    try {
                        int rows = tTeacherDao.save(tk);
                        System.out.println("Rows affected: " + rows);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.err.println(e.getMessage());
                    }
        });
    }
}