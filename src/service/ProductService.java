package service;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    ConnectDB connectDB = new ConnectDB();
    Connection connection = connectDB.getConnection();
    private static final String SELECT_ALL_PRODUCT = "select * from product";
    private static final String SEARCH_PRODUCT_BY_NAME = "select *\n" +
            "from product\n" +
            "where pName = ?;";
    private static final String SELECT_ALL_CATEGORY = "select cName from category";
    private static final String SELECT_PRODUCT_BY_ID = "select *\n" +
            "from product\n" +
            "where pId = ?;";
    private static final String INSERT_PRODUCT = "insert into product(pName, price, quantity, color, description,cName) values (?,?,?,?,?,?) ";
    private static final String UPDATE_PRODUCT = "update product set pName = ?,price = ?, quantity = ?,color = ?, description = ? where pId = ?";
    private static final String DELETE_PRODUCT = "delete from product where pId = ?";

    @Override
    public List<Product> selectAllProduct() throws SQLException {
        List<Product> list = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PRODUCT);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("pId");
            String pName = resultSet.getNString("pName");
            float price = resultSet.getFloat("price");
            int quantity = resultSet.getInt("quantity");
            String color = resultSet.getString("color");
            String description = resultSet.getNString("description");
            String cName = resultSet.getString("cName");
            list.add(new Product(id,pName,price,quantity,color,description,cName));
        }
        return list;

    }

    @Override
    public List<Product> searchProductByName(String pName) throws SQLException{
        List<Product> list = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SEARCH_PRODUCT_BY_NAME);
        ps.setString(1,pName);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("pId");
            String name = resultSet.getNString("pName");
            float price = resultSet.getFloat("price");
            int quantity = resultSet.getInt("quantity");
            String color = resultSet.getString("color");
            String description = resultSet.getNString("description");
            String cName = resultSet.getString("cName");
            list.add(new Product(id,name,price,quantity,color,description,cName));
        }
        return list;

    }

    @Override
    public Product selectProductById(int pId) throws SQLException{
        Product product;
        PreparedStatement ps = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
        ps.setInt(1,pId);
        ResultSet resultSet = ps.executeQuery();
        int id = resultSet.getInt("pId");
        String pName = resultSet.getNString("pName");
        float price = resultSet.getFloat("price");
        int quantity = resultSet.getInt("quantity");
        String color = resultSet.getString("color");
        String description = resultSet.getNString("description");
        String cName = resultSet.getString("cName");
        product = new Product(id,pName,price,quantity,color,description,cName);
        return product;

    }

    @Override
    public void addProduct(Product product) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(INSERT_PRODUCT);
        ps.setNString(1,product.getpName());
        ps.setFloat(2,product.getPrice());
        ps.setInt(3,product.getQuantity());
        ps.setString(4,product.getColor());
        ps.setNString(5,product.getDescription());
        ps.setString(6,product.getCategory());
        ps.executeUpdate();
    }

    @Override
    public void updateProduct(Product product,int pId) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(UPDATE_PRODUCT);
        ps.setNString(1,product.getpName());
        ps.setFloat(2,product.getPrice());
        ps.setInt(3,product.getQuantity());
        ps.setString(4,product.getColor());
        ps.setNString(5,product.getDescription());
        ps.setInt(6,pId);
        ps.executeUpdate();
    }

    @Override
    public void deleteProduct(int pId) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(DELETE_PRODUCT);
        ps.setInt(1,pId);
        ps.executeUpdate();
    }
    @Override
    public List<String> selectAllCategory() throws SQLException{
        List<String> list = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_CATEGORY);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            list.add(resultSet.getString("cName"));
        }
        return list;
    }
}
