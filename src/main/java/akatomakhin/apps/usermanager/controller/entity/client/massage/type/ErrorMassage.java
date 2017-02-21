package akatomakhin.apps.usermanager.controller.entity.client.massage.type;

import akatomakhin.apps.usermanager.controller.entity.client.massage.UserMassage;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
public class ErrorMassage {
    private UserMassage error = null;

    public void setError(UserMassage userMassage)
    {
        error = userMassage;
    }

    public UserMassage getError(){
        return error;
    }

}
