package presentation;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ClausFindinge - Claus Mikkelsen Findinge
 */
public class DeleteProductCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        String returnvalue = "";
        returnvalue = db.deleteProduct(Integer.parseInt(request.getParameter("ProductId")), "/db.properties");
        request.getSession().setAttribute("returndeleteproductvalue", returnvalue);
        return "DeleteProduct";
    }

}
