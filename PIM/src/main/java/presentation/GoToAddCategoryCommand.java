/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Malthe
 */
public class GoToAddCategoryCommand extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        
        return "AddCategory";
    }
    
}