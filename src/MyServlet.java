import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        JSONObject jsonObj = requestParamsToJSON(req);
        ItemDAO.save(getItem(jsonObj));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject jsonObj = requestParamsToJSON(req);
        ItemDAO.update(getItem(jsonObj));
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


    /****************************************************************************************************************/

    public JSONObject requestParamsToJSON(ServletRequest req) {
        JSONObject jsonObj = new JSONObject();
        Map<String, String[]> params = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : params.entrySet()) {
            String v[] = entry.getValue();
            Object o = (v.length == 1) ? v[0] : v;
            jsonObj.put(entry.getKey(), o);
        }
        return jsonObj;
    }

    private Item getItem(JSONObject jsonObj) throws IOException {
        Item item = new ObjectMapper().readValue(jsonObj.toString(), Item.class);

//        //String id = req.getParameter("id");
//        String name = req.getParameter("name");
//        String dateCreated = req.getParameter("dateCreated");
//        String lastUpdatedDate = req.getParameter("lastUpdatedDate");
//        String description = req.getParameter("description");
//
//        Item item = new Item();
//        //item.setId(Long.parseLong(id));
//        item.setName(name);
//        try {
//            item.setDateCreated(new SimpleDateFormat("dd/MM/yyyy").parse(dateCreated));
//            item.setLastUpdatedDate(new SimpleDateFormat("dd/MM/yyyy").parse(lastUpdatedDate));
//        } catch (ParseException e) {
//            System.out.println("Parse ERROR");
//        }
//        item.setDescription(description);

        return item;
    }
}
