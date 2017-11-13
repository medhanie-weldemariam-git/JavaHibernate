package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.student.model.Student;
import com.student.util.StudentUtil;

public class StudentDao 
{

	public void addStudent(Student student) 
	{
        Transaction transaction = null;
        Session session = StudentUtil.getSessionFactory().openSession();
        try {
        	transaction = session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
            	transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
	
	
	
	public void deleteStudent(Student student2) 
	{
        Transaction transaction = null;
        Session session = StudentUtil.getSessionFactory().openSession();
        try {
        	transaction = session.beginTransaction();
            //Student student = (Student) session.load(Student.class, student2);
            session.delete(student2);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
            	transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
	
	
	
	
	public void updateStudent(Student student) 
	{
        Transaction transaction = null;
        Session session = StudentUtil.getSessionFactory().openSession();
        try {
        	transaction = session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
            	transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
	
	
	

    public List<Student> getAllStudents() 
    {
        List<Student> studentList = new ArrayList<Student>();
        Transaction transaction = null;
        Session session = StudentUtil.getSessionFactory().openSession();
        try {
        	transaction = session.beginTransaction();
            studentList = session.createQuery("from Student").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return studentList;
    }
    
    
    

    public Student getStudentById(int studentId) 
    {
    	Student student = null;
        Transaction trns = null;
        Session session = StudentUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Student where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", studentId);
            student = (Student) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return student;
    }
	
	

	
	
	
}
