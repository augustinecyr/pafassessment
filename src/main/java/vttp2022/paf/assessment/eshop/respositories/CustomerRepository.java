package vttp2022.paf.assessment.eshop.respositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.Customer;

import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

@Repository
public class CustomerRepository {
	@Autowired
	JdbcTemplate template;

	// You cannot change the method's signature
	public List<Customer> findCustomerByName(String name) {
		// TODO: Task 3

		List<Customer> customers = template.query(SQL_FIND_CUSTOMER_BY_NAME, new RowMapper<Customer>() {
			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer cs = new Customer();
				cs.setName(rs.getString("name"));
				cs.setAddress(rs.getString("address"));
				cs.setEmail(rs.getString("email"));

				return cs;
			}
		});
		for (Customer cs : customers) {
			System.out.println(cs);
		}
		return customers;
	}

}
