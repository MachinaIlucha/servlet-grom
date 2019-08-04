
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ItemDAO {

    private static SessionFactory sessionFactory;

    public static void save(Item item) {
        //create session/tr
        try (Session session = createSession().openSession()) {

            session.getTransaction().begin();
            session.save(item);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static Item update(Item item) {
        //create session/tr
        try (Session session = createSession().openSession()) {

            //action
            session.getTransaction().begin();
            session.update(item);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            System.err.println("Update is failed");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return item;
    }

    public static Item delete(Item item) {
        //create session/tr
        try (Session session = createSession().openSession()) {

            //action
            session.getTransaction().begin();
            session.delete(item);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return item;
    }

    public static Item getItemById(Long id) {
        //create session/tr
        Transaction tr = null;
        Item item = null;
        try (Session session = createSession().openSession()) {
            tr = session.getTransaction();
            tr.begin();

            //action
            Query query = session.createQuery("FROM Item WHERE id = :id");
            query.setParameter("id", id);
            item = (Item) query.getSingleResult();


            //close session/tr
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Find method is failed");
            System.err.println(e.getMessage());
            e.printStackTrace();

            if (tr != null)
                tr.rollback();
        }
        return item;
    }

    public static SessionFactory createSession() {
        //singleton pattern
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
