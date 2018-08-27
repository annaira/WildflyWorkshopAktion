package time;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "Time Servlet", urlPatterns = {"/TimeServlet"})
public class TimeServlet extends HttpServlet {

	private static final long serialVersionUID = -4192601306923754501L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<HTML><HEAD><TITLE>Actual Time</TITLE></HEAD>");
        out.println("<BODY><H1>TimeServlet " + new Date() + "</H1></BODY></HTML>");
        out.close();
    }
}
