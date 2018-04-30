import com.pramod.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try{
            Employee employee = new Employee("PramodShethe");

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            System.out.println("Done...");


        }finally {
            sessionFactory.close();
        }
    }
}
