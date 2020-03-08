package bzh.zomzog.demo.openapispringclienttoken.front.dao;

import bzh.zomzog.demo.openapispringclienttoken.front.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}