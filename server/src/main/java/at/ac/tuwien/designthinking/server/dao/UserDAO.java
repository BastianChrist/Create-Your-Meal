package at.ac.tuwien.designthinking.server.dao;

import at.ac.tuwien.designthinking.server.dao.interfaces.IUserDAO;
import at.ac.tuwien.designthinking.server.dto.UserAccount;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository("userdao")
@Transactional
public class UserDAO extends GenericDAO<UserAccount,Integer> implements IUserDAO {

    @Override
    public UserAccount findUserbyUsername(String username) {
        try {
            TypedQuery<UserAccount> q = this.getEntityManager()
                    .createQuery("SELECT o FROM UserAccount o WHERE o.firstName = (:username)", UserAccount.class);
            q.setParameter("username", username);

            return q.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public UserAccount findUserById(Integer id) {
        try {
            TypedQuery<UserAccount> q = this.getEntityManager().createQuery("SELECT o FROM UserAccount o WHERE o.id = (:id)", UserAccount.class);
            q.setParameter("id", id);

            return q.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<UserAccount> findAll() {
        try {
            TypedQuery<UserAccount> q = this.getEntityManager()
                    .createQuery("SELECT o FROM UserAccount o",UserAccount.class);

            return q.getResultList();
        } catch (Exception ex) {
            return null;
        }    }
}
