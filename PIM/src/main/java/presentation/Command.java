package presentation;


import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.CategoryMapper;
import persistence.CategoryMapperInterface;
import persistence.DBFacade;


public abstract class Command{
    DBFacade db = new DBFacade();
    CategoryMapper category = new CategoryMapper();

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("gotoUploadFile", new GoToUploadFileCommand());
        commands.put("addCategory", new GoToAddCategoryCommand());
        commands.put("addMainCategory", new AddMainCategoryCommand());
        commands.put("addMinorCategory", new AddMinorCategoryCommand());
        commands.put("gotoDeleteMainCategory", new GoToDeleteCategoryCommand());
        commands.put("deleteMainCategory", new DeleteMainCategoryCommand());
        commands.put("deleteMinorCategory", new DeleteMinorCategoryCommand());
        commands.put("editCategory", new GoToEditCategoryCommand());
        commands.put("editMainCategory", new EditMainCategoryCommand());
        commands.put("editMinorCategory", new EditMinorCategoryCommand());
        commands.put("gotoAddProduct", new GoToAddProductCommand());
        commands.put("addProduct", new AddProductCommand());
        commands.put("gotoSearchProducts", new GoToSearchProductsCommand());
        commands.put("searchResults", new SearchProductsCommand());
         commands.put("gotoDeleteProduct", new GotoDeleteProductCommand());
        commands.put("deleteProduct", new DeleteProductCommand());
        commands.put("gotoEditProduct", new GotoEditProductCommand());
        commands.put("editProduct", new EditProductCommand());
//        commands.put("deleteProduct", new DeleteProductCommand());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("cmd");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException;
}
