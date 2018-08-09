package time;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.Date;

@Stateless
@LocalBean
public class TimeEJB {
    public String getTime() {
        return "TimeEJB " + new Date().toString();
    }
}
