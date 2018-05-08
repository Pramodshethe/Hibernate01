package com.pramod.controller;

import com.pramod.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Control {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    Scanner scanner = new Scanner(System.in);
    public void saveEmployee(String name){
        session.beginTransaction();
        Employee employee = new Employee();
        System.out.println("Enter Name: ");
        String fname = scanner.next();
        employee.setName(fname);
        session.save(employee);
        session.getTransaction().commit();
        System.out.println(name + " Is added Successfully");
        session.close();
    }
}
