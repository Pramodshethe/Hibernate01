import com.pramod.entity.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        Employee e = new Employee();

        e.setName("Shethe");
        EntityManagerFactory et = Persistence.createEntityManagerFactory("abc");
        EntityManager em = et.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();


    }
}
