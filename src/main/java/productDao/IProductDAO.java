package productDao;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public List<Product> selectAllProduct();
    public Product selectProductById(int id);
    public void insertProduct(Product product) throws SQLException;
    public List<Product> findProductByName(String productName);
    public boolean deleteProduct(String id) throws SQLException;
    public boolean updateProduct(Product user) throws SQLException;
}
