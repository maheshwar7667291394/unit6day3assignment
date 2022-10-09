package com.masai.entities;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {
	
	public static void main(String[] args) {
	EntityManagerFactory emp=Persistence.createEntityManagerFactory("empUnit");
	EntityManager em=emp.createEntityManager();
	
	System.out.println("want to see student details Enter 1");
	System.out.println("Want insert student data Enter 2");
	System.out.println("if want to delete student data Enter 3");
	System.out.println("if want to update student data enter 4");
	Scanner input=new Scanner(System.in);
	int sc=input.nextInt();
	
	switch(sc) {
	
	case 1:
		System.out.println("Enter roll number");
		int roll=input.nextInt();
		
	    Student s=em.find(Student.class,roll);
	       
	    if(s!=null) {
	    	System.out.println(s);
	    }
	    else
	    	System.out.println("student not found");
	    
	    em.close();
	    break;
	case 2:
		
		System.out.println("enter studnt roll");
		int rol=input.nextInt();
		
		System.out.println("enter name");
		String name=input.next();
		
		System.out.println("enter marks");
		int marks=input.nextInt();
		
		Student student=new Student(rol, name, marks);
		
	  
	  EntityTransaction et= em.getTransaction();
	  et.begin();
	     em.persist(student);
	  et.commit();
	  em.close();
	  System.out.println("student record saved");
	  break;
	  
	case 3:
		System.out.println("enter the roll of student which you want ot delate");
		int roll2=input.nextInt();
		Student s3=em.find(Student.class,roll2);
		if(s3==null) {
			System.out.println("Student record not int the table");
		}
		else {
			em.getTransaction().begin();
			em.remove(s3);
			em.getTransaction().commit();
		}
		em.close();
		System.out.println("Student deleted");
		break;
	case 4:
		System.out.println("enter roll ");
		int roll3=input.nextInt();
		
		Student s4=em.find(Student.class,roll3);
		if(s4==null)
			System.out.println("student not found");
		else
		{
			em.getTransaction().begin();
			s4.setMarks(s4.getMarks()+50);
			em.getTransaction().commit();
		}
		em.close();
		System.out.println("student update sucuss full");
		break;
		
	default:
		System.out.println("no any operation performed");
	
	}
	
    
	}

}
