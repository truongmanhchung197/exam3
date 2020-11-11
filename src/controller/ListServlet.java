package controller;

import model.Product;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ListServlet", urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    ProductService service = new ProductService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "add":
                    insertProduct(request,response);
                    break;
                case "edit":
                    break;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "add":
                    showAddProduct(request,response);
                    break;
                case "delete":
                    deleteProduct(request,response);
                    break;
                case "edit":
                    break;

                default:
                    showList(request,response);
                    showCategory(request,response);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request,response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        String name = request.getParameter("name");
        Float price = Float.parseFloat(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        Product product = new Product(name,price,quantity,color,description,category);
        service.addProduct(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request,response);



    }

    private void showAddProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("addproduct.jsp");
        dispatcher.forward(request,response);
    }


    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException, SQLException {
            List<Product> list = service.selectAllProduct();
            request.setAttribute("listProduct",list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
            dispatcher.forward(request,response);

    }
    private void showCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        try {
            List<String> list = service.selectAllCategory();
            request.setAttribute("listCategory",list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
