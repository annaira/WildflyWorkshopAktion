package time;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("cdi_clock")
@ApplicationScoped
public class TimeCDIBean {

    @Inject
    private TimeEJB time;

    public String getTime() {
        return "TimeCDIBean " + time.getTime();
    }
}
