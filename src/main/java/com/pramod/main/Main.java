package com.pramod.main;

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

        do {
            System.out.println("1:Save " + " 2:Delete"+" 3:Retrive "+" 4:Update ");
            System.out.println("Choose the Operation");
            Scanner scan = new Scanner(System.in);
            int operation = scan.nextInt();

            switch (operation) {

                case (1):
                    session.beginTransaction();
                    Employee employee = new Employee();
                    System.out.println("Enter Name: ");
                    String name = scan.next();
                    employee.setName(name);
                    session.save(employee);
                    session.getTransaction().commit();
                    System.out.println(name + " Is added Successfully");
                    session.close();
                    break;

                case (2):
                    session.beginTransaction();
                    System.out.println("Enter the id to delete");
                    int num = scan.nextInt();
                    Employee employee1 = (Employee) session.load(Employee.class, num);
                    session.delete(employee1);
                    session.getTransaction().commit();
                    System.out.println("Successfully deleted");
                    session.close();
                    break;

                case(3):
                    Transaction transaction;
                       transaction = session.beginTransaction();
                    List employee2 = session.createQuery("from Employee").list();
                    System.out.println("_________________");
                    System.out.println("ID "+" NAME");

                        for (Iterator itr =employee2.iterator();itr.hasNext();){
                            Employee employee3 = (Employee) itr.next();
                            System.out.print(employee3.getId()+"  "+ employee3.getName()+"\n");
                        }

                    System.out.println("_________________");
                        transaction.commit();
                        session.close();

                case(4): session.beginTransaction();
                         System.out.println("Enter the ID to UPDATE : ");
                         int iid=scan.nextInt();
                         Employee employee3= (Employee) session.get(Employee.class,iid);
                         employee3.setName("NEWPRAMOD");
                         session.getTransaction().commit();
                         session.close();
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }while (true);
    }
}
