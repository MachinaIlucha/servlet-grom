import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/test")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String prId = req.getParameter("id");
        long id = Integer.parseInt(prId);

        Item item = ItemDAO.getItemById(id);

        resp.getWriter().println(item.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // JSONObject jsonObj = requestParamsToJSON(req);
        ObjectMapper objectMapper = new ObjectMapper();
        Item item = objectMapper.readValue((JsonParser) req, Item.class);
        ItemDAO.save(item);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ItemDAO.update(objectMapper.readValue(req.toString(), Item.class));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String prId = req.getParameter("id");
        long id = Long.parseLong(prId);
        ItemDAO.delete(ItemDAO.getItemById(id));
    }

    //servlet registration - init()
    //servlet works with service method
    //to close servlet with its resources - destroy()


    //HTTP REQUESTS
    // GET - get some info
    // POST - save some info
    // PUT - update
    // DELETE - delete info

    //CRUD
}
