package akatomakhin.apps.usermanager.dao.mysql.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
@Component
public class MySQLConnectionData {
        private String driver = "com.mysql.jdbc.Driver";

        @Value("jdbc:mysql://localhost:3366/userdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false")
        private String url = "jdbc:mysql://localhost:3366/userdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

        @Value("root")
        private String user = "root";

        @Value("alex1996")
        private String password = "alex1996";

        public String getUrl(){
                return url;
        }

        public String getUser() {
                return user;
        }

        public String getPassword() {
                return password;
        }

        public String getDriver() {
                return driver;
        }

}
