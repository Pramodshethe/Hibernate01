package com.pramod.controller;

import com.pramod.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Control {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    Scanner scanner = new Scanner(System.in);

    public void saveEmployee(){
        session.beginTransaction();
        Employee employee = new Employee();
        System.out.println("Enter Name: ");
        String fname = scanner.next();
        employee.setName(fname);
        session.save(employee);
        session.getTransaction().commit();
        System.out.println(fname + " Is added Successfully");
        session.close();
    }

    public void deleteEmployee(){
        session.beginTransaction();
        System.out.println("Enter the id to delete");
        int num = scanner.nextInt();
        Employee employee1 = (Employee) session.load(Employee.class, num);
        session.delete(employee1);
        session.getTransaction().commit();
        System.out.println("Successfully deleted");
        session.close();
    }

    public Employee displayEmployee(){
        Transaction transaction;
        transaction = session.beginTransaction();
        List employee2 = session.createQuery("from Employee").list();
        System.out.println("_________________");
        System.out.println("ID "+" NAME");

        for (Iterator itr = employee2.iterator(); itr.hasNext();){
            Employee employee3 = (Employee) itr.next();
            return employee3;

        }

        System.out.println("_________________");
        transaction.commit();
        session.close();

        return null;
    }

    public void updateEmployee(){
        session.beginTransaction();
        System.out.println("Enter the ID to UPDATE : ");
        int iid=scanner.nextInt();
        Employee employee3= (Employee) session.get(Employee.class,iid);
        employee3.setName("PRAMOD S");
        session.getTransaction().commit();
        session.close();
    }

}
