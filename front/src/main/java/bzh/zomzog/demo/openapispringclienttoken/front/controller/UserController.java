package bzh.zomzog.demo.openapispringclienttoken.front.controller;

import bzh.zomzog.demo.openapispringclienttoken.front.service.UserService;
import bzh.zomzog.demo.openapispringclienttoken.front.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> listUser() {
        return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return "success";
    }

}