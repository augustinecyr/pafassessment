package vttp2022.paf.assessment.eshop.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import vttp2022.paf.assessment.eshop.models.Customer;


import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

@Controller
public class OrderController {
    // TODO: Task 3
    @Autowired
    JdbcTemplate template;

    @RequestMapping("/customers")
    public String displayCustomers() {

        List<Customer> customers = template.query(SQL_ALL_CUSTOMER, new RowMapper<Customer>() {
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

        return "display";
    }

    @RequestMapping("/cust")
    public String displayCustomersByName(@RequestParam String name) {
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

        return "display";
    }


}
