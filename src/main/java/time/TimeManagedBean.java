package time;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.Date;

@ManagedBean(name = "clock")
@ApplicationScoped
public class TimeManagedBean {
    public String getTime() {
        return "TimeManagedBean " + new Date().toString();
    }
}
