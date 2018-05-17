package com.pramod.main;

import com.pramod.controller.Control;
import com.pramod.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Control col = new Control();
        Employee emp = new Employee();
        do {
            System.out.println("1:Save " + " 2:Delete"+" 3:Retrive "+" 4:Update ");
            System.out.println("Choose the Operation");
            Scanner scan = new Scanner(System.in);
            int operation = scan.nextInt();

            switch (operation) {

                case (1):
                    col.saveEmployee();
                    break;

                case (2):
                    col.deleteEmployee();
                    break;

                case(3):
                    col.displayEmployee();
                    break;

                case(4):
                    col.updateEmployee();
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }while (true);
    }
}
