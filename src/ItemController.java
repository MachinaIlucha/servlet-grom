import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ItemController {

    private ItemService itemService;

    protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        itemService.save(req, resp);
    }

    protected void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        itemService.get(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        itemService.update(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        itemService.delete(req, resp);
    }
}
