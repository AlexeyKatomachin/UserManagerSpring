package akatomakhin.apps.usermanager.dao.mysql.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
@Component
public class MySQLConnectionData {
        @Value("jdbc:mysql://localhost:3366/userdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false")
        private String url;

        @Value("root")
        private String user;

        @Value("alex1996")
        private String password;

        public String getUrl(){
                return url;
        }

        public String getUser() {
                return user;
        }

        public String getPassword() {
                return password;
        }

}
