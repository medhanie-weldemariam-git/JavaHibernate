package com.student;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//import org.hibernate.tutorial.domain.Event;

import com.student.dao.StudentDao;
import com.student.model.Student;
import com.student.util.StudentUtil;

public class App 
{

	public static void main(String[] args) 
	{
		StudentDao studentDao = new StudentDao();
		Student student = new Student();
		final Scanner scan = new Scanner(System.in);
		int menu=0;
		while(menu !=5)
		{
		
		System.out.println("Enter the number of your choosing......\n 1 To AddNew Student, \n 2 To Update an Exisiting Student, \n 3 TO Display All Records \n 4 To Delete a Record and \n 5 To Exist the Program!");
		menu = scan.nextInt();

	      switch(menu) 
	      {
	         case 1 :
	        	// Add new Student
	         	String choise= "no";
	         	
	         	do
	         	{
	         		System.out.println("Enter student Name:");
	         		student.setName(scan.nextLine());
	         		
	         		System.out.println("Enter student Email:");
	         		student.setEmail(scan.nextLine());
	         		
	         		System.out.println("Enter student Address:");
	         		student.setAddress(scan.nextLine());
	         		
	         		System.out.println("Enter student Telephone:");
	         		student.setTelephone(scan.nextLine());
	         		
	         		studentDao.addStudent(student);
	         		System.out.println("One new student record has been inserted successfuly. Do you want to insert new student? (y/n)");
	         		choise=scan.next();
	         	}while(choise.equalsIgnoreCase("yes") | choise.equalsIgnoreCase("y")); 
	            break;
	         case 2 :
	        	 
	        	//Update student record
	         	System.out.println("Enter Student ID to update a record:");
	         	student= (Student) studentDao.getStudentById(scan.nextInt());
	         	
	         	if(student!=null)
	         	{
	         		System.out.println("Enter student Name:");
	         		student.setName(scan.nextLine());
	         		
	         		System.out.println("Enter student Email:");
	         		student.setEmail(scan.nextLine());
	         		
	         		System.out.println("Enter student Address:");
	         		student.setAddress(scan.nextLine());
	         		
	         		System.out.println("Enter student Telephone:");
	         		student.setTelephone(scan.nextLine());
	         		
	         		studentDao.updateStudent(student);
	         		System.out.println("Student has been updated successfully!");
	         	}
	         	else
	         	{
	         		System.out.println("Student Id has not been found, please enter correct ID!");
	         	}
	         	break;
	        	 
	         case 3 :
	        	// Get all students
	             System.out.println("Listing all students:");
	             System.out.println("Id   Name          Email                Address   Telephone");
	         	System.out.println("---------------------------------------------------------");
	             for (Student studentIterator : studentDao.getAllStudents()) 
	             {
	                 System.out.println(studentIterator.getId()+ "  " + studentIterator.getName() + "    " +studentIterator.getEmail() + "  " + 
	             	studentIterator.getAddress() + " " +studentIterator.getTelephone());
	             }
	            break;
	         case 4 :
	        	//Delete specific student record
	         	System.out.println("Enter Student ID to delete a record:");
	         	student= (Student) studentDao.getStudentById(scan.nextInt());
	         	
	         	if(student!=null)
	         	{
	         		studentDao.deleteStudent(student);
	         		System.out.println("Student has been deleted successfully!");
	         	}
	         	else
	         	{
	         		System.out.println("Student Id has not been found, please enter correct ID!");
	         	}
	         	break;
	         case 5:
	        	 System.out.println("Exiting program...\nGoodbye and see you later!!!");
	        	 break;
	         default :
	            System.out.println("Invalid menu choise");
	      }
		}

	}

}
