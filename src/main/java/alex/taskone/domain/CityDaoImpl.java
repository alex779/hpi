package alex.taskone.domain;

import alex.taskone.config.HibernateUtil;
import alex.taskone.exception.ValidationException;
import java.util.List;
import javafx.util.Pair;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CityDaoImpl implements CityDao {

    private static CityDaoImpl cityDao = new CityDaoImpl();

    @Override
    public void addCity(String name, Integer location) throws Exception {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        City city = new City(name, location);

        try {
            trns = session.beginTransaction();
            if (getCityByLocation(city.getLocation()) == null) {
                session.save(city);
            } else {
                throw new ValidationException("Wrong location");
            }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    @Override
    public void removeCity(Integer id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            City city = (City) session.load(City.class, id);
            session.delete(city);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    @Override
    public City getCity(Integer id) {
        City city = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            city = (City) session.createCriteria(City.class)
                    .add(Restrictions.eq("id", id)).uniqueResult();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return city;
    }

    @Override
    public City getCityByLocation(Integer location) {
        City city = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            city = (City) session.createCriteria(City.class)
                    .add(Restrictions.eq("location", location)).uniqueResult();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return city;
    }

    public Pair<List<Road>, List<Road>> getRoadList(Integer id) {

        return new Pair<>(cityDao.getCity(id).getRoadList(), cityDao.getCity(id).getRoadList1());

    }
}
