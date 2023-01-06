package vttp2022.paf.assessment.eshop.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.models.OrderStatus;
import vttp2022.paf.assessment.eshop.respositories.CustomerRepository;
import vttp2022.paf.assessment.eshop.respositories.OrderRepository;
import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

@Service
public class WarehouseService {

	// You cannot change the method's signature
	// You may add one or more checked exceptions

	@Autowired
	private OrderRepository ordRepo;
	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	JdbcTemplate template;

	@RequestMapping("/status")
	public List<OrderStatus> dispatch(Order order) {

		List<OrderStatus> status = template.query(SQL_ORDERSTATUS, new RowMapper<OrderStatus>() {
			@Override
			public OrderStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderStatus os = new OrderStatus();
				os.setOrderId(rs.getString("order_id"));
				os.setDeliveryId(rs.getString("delivery_id"));
				os.setStatus(rs.getString("status"));
				
				return os;
			}
		});
		for (OrderStatus os : status) {
			System.out.println(os);
		}
		return status;
	}

	// TODO: Task 4

	@PostMapping("http://paf.chuklee.com/dispatch/{orderId}")
	public ResponseEntity<Object> dispatchOrder(@PathVariable Long orderId) {
		Order order = ordRepo.getOrderId(orderId);
		if (order == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}