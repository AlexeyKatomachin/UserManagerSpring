package akatomakhin.apps.usermanager.controller.entity.client.massage;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
public class UserMassage {
    private String massage = null;

    public void setMassage(String massage){
        this.massage = massage;
    }

    public String getMassage(){
        return massage;
    }

    @Override
    public String toString(){
        return "Massage: " + massage;
    }
}
