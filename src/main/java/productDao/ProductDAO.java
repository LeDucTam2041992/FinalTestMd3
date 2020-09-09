package productDao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{

    private String jdbcURL = "jdbc:mysql://localhost:3306/finaltest?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "11111";

    private static final String INSERT_PRODUCT_SQL = "INSERT INTO products" + "  (name, color, description, category, price, quantity) VALUES " +
            " (?,?,?,?,?,?);";
    private static final String SELECT_ALL_PRODUCTS = "select products.id, products.name, products.color, products.description, products.price, products.quantity, category.category from products join category on products.category = category.id ";
    private static final String SELECT_PRODUCT_BY_ID = "select products.id, products.name, products.color, products.description, products.price, products.quantity, category.category from products join category on products.category = category.id  where products.id = ?;";
    private static final String FIND_PRODUCT_BY_NAME = "select products.id, products.name, products.color, products.description, products.price, products.quantity, category.category from products join category on products.category = category.id where products.name = ?;";
    private static final String DELETE_PRODUCTS_SQL = "delete from products where id = ?;";
    private static final String UPDATE_PRODUCTS_SQL = "update products set name = ?, color= ?, description = ?, category = ?, price = ?, quantity = ? where id = ?;";

    public ProductDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> selectAllProduct() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String category = rs.getString("category");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                products.add(new Product(name,color,description,category,id,price,quantity));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    @Override
    public Product selectProductById(int id) {
        Product product = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String category = rs.getString("category");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                product = new Product(name,color,description,category,id,price,quantity);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }


    @Override
    public void insertProduct(Product product) throws SQLException {

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getColor());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getCategory());
            preparedStatement.setInt(5, product.getPrice());
            preparedStatement.setInt(6, product.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<Product> findProductByName(String nameFind) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCT_BY_NAME);) {
            preparedStatement.setString(1,nameFind);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String category = rs.getString("category");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                products.add(new Product(name,color,description,category,id,price,quantity));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    @Override
    public boolean deleteProduct(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL);) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_SQL);) {
            int category = 0;
            if(product.getCategory().equals("phone")){
                category = 1;
            }
            if(product.getCategory().equals("tivi")){
                category = 2;
            }
            if(product.getCategory().equals("tulanh")){
                category = 3;
            }
            statement.setString(1, product.getName());
            statement.setString(2, product.getColor());
            statement.setString(3, product.getDescription());
            statement.setInt(4, category);
            statement.setInt(5, product.getPrice());
            statement.setInt(6, product.getQuantity());
            statement.setInt(7, product.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException e) {
    }
}
