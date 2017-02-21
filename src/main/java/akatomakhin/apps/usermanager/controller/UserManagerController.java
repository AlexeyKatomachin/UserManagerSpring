package akatomakhin.apps.usermanager.controller;

import akatomakhin.apps.usermanager.controller.entity.client.massage.type.ErrorMassage;
import akatomakhin.apps.usermanager.entity.User;
import akatomakhin.apps.usermanager.facade.UserManager;
import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
@Controller
@SpringBootApplication
@RequestMapping("/user")
public class UserManagerController {

    /* get user*/
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @JsonView(User.class)
    public ArrayList<User> doGet() {
        return new UserManager().getAllUsers();
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @JsonView(User.class)
    public User doGet(@PathVariable("id") int id) {
        return new UserManager().getUser(id);
    }


    /* create user*/
    @RequestMapping(method = RequestMethod.POST)
    public void doPost(@RequestBody User user)  {
        new UserManager().createUser(user);
    }

    /* delete user*/
    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
    public void doDelete(@PathVariable ("id") int id) {
        new UserManager().deleteUser(id);
    }

    /* update user*/
    @RequestMapping(path = "/{id}" ,method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @JsonView (ErrorMassage.class)
    public ErrorMassage doPut(@RequestBody User user,@PathVariable ("id") int id) throws IOException {
        user.setId(id);
        if (new UserManager().updateUser(user).getMassage() != null){
            ErrorMassage error = new ErrorMassage();
            error.setError(new UserManager().updateUser(user));
            return error;
        }
        return null;
    }
}
