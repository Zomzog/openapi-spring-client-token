package bzh.zomzog.demo.openapispringclienttoken.front.service;

import bzh.zomzog.demo.openapispringclienttoken.front.dao.UserDao;
import bzh.zomzog.demo.openapispringclienttoken.front.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserDao userDao;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userDao.findByUsername(userId);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public void delete(long id) {
        userDao.deleteById(id);
    }

    public User save(User user) {
        return userDao.save(user);
    }
}