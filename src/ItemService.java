import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ItemService {

    private MyServlet myServlet;

    protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        myServlet.doPost(req, resp);
    }

    protected void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        myServlet.doGet(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        myServlet.doPut(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        myServlet.doDelete(req, resp);
    }

}
