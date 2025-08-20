package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void addUser(User user) {
      entityManager.persist(user);
   }

   @Override
   public void updateUser(User user) {
      entityManager.merge(user);
   }

   @Override
   public List<User> listUsers() {
      return entityManager.createQuery("from User", User.class).getResultList();
   }


   @Override
   public User findUserByCar(String model, int series) {
      TypedQuery<User> query = entityManager.createQuery(
              "from User u where u.car.model = :model and u.car.series = :series", User.class);
      query.setParameter("model", model);
      query.setParameter("series", series);
      List<User> result = query.getResultList();
      return result.isEmpty() ? null : result.get(0);
   }

}