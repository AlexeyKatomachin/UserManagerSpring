package akatomakhin.apps.usermanager.main;

import akatomakhin.apps.usermanager.controller.UserManagerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
@EnableAutoConfiguration
public class Main {
    public static void main(String []args){
        SpringApplication.run(UserManagerController.class,args);
    }
}
