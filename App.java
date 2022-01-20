package com.dxc;

import java.sql.SQLException;
import java.util.List;
import com.dxc.dao.StudentDao;
import com.dxc.model.Student;

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
        });
    }
}