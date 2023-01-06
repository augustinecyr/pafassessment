package vttp2022.paf.assessment.eshop.respositories;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



import vttp2022.paf.assessment.eshop.models.LineItem;
import vttp2022.paf.assessment.eshop.models.Order;


import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

import java.util.List;


@Repository
public class OrderRepository {

	// TODO: Task 3
	@Autowired
	private JdbcTemplate template;

	public boolean insertOrder(Order ord) {

		return template.update(SQL_INSERT_ORDER,
				ord.getOrderId(),ord.getDeliveryId(),ord.getName(),ord.getAddress(),ord.getEmail(),ord.getStatus(),ord.getOrderDate()) > 0;
	}

	public void addLineItems(Order order) {
        addLineItems(order.getLineItems(), order.getOrderId());
    }

	public void addLineItems(List<LineItem> lineItems, String orderId) {
        List<Object[]> data = lineItems.stream()
                .map(li -> {
                    Object[] l = new Object[3];
                    l[0] = li.getItem();
                    l[1] = li.getQuantity();
                    l[2] = orderId;
                    return l;
                })
                .toList();

        template.batchUpdate(SQL_INSERT_LINEITEM, data);
    }

    public Order getOrderId(Long orderId) {
        
        return null;
    }


	

}
