package th.go.rd.atm.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import th.go.rd.atm.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepository implements JdbcRepository{

    private JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> findAll(){
        String sql = "SELECT * FROM customer";
        return jdbcTemplate.query(sql,new CustomerMapper());
//        List<Customer> customers =
//                jdbcTemplate.query(query, new CustomerMapper());
//        return customers;


    }

    @Override
    public Customer findById(int id) {

            String sql = "SELECT * FROM customer WHERE id=" + id;

        return jdbcTemplate.queryForObject(sql,new CustomerMapper());
//        Customer customer =
//                jdbcTemplate.queryForObject(query, new CustomerMapper());
//        return customer;

    }

    @Override
    public void save(Customer customer) {
        String sql ="INSERT INTO customer (id,name,pin) VALUES(?,?,?)";
        Object[] data = new Object[]{customer.getId(),customer.getName(),customer.getPin()};
        jdbcTemplate.update(sql,data);
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public void deleteById(int id) {

    }

    class CustomerMapper implements RowMapper<Customer>{

        @Override
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String pin = resultSet.getString("pin");

            Customer customer = new Customer(id, name, pin);
            return customer;

        }
    }
}
