package service;

import model.Product;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    List<Product> selectAllProduct() throws SQLException;
    List<Product> searchProductByName(String pName) throws SQLException;
    Product selectProductById(int pId) throws SQLException;
    void addProduct(Product product) throws SQLException;
    void updateProduct(Product product, int pId) throws SQLException;
    void deleteProduct(int pId) throws SQLException;
    List<String> selectAllCategory() throws SQLException;
}
