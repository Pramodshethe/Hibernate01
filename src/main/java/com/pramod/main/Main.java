package com.pramod.main;

import com.pramod.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        System.out.println("1:Save"+"2:break");
        System.out.println("Enter the number");
        Scanner scan = new Scanner(System.in);
        int cat = scan.nextInt();

        switch (cat) {

            case(1):session.beginTransaction();
                    Employee employee = new Employee();
                    employee.setName("Diago");
                    session.save(employee);
                    session.getTransaction().commit();
                System.out.println("Done");
                    session.close();
                    break;
            default:
                System.out.println("invalid");
                break;
        }
    }

}
