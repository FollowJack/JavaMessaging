package entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Deniel on 30.09.2014.
 */
public class OrderDTO implements Serializable{

    private Long orderId;
    private Date creationDate;
    private String customerName;
    private Float totalAmount;

    public OrderDTO(long id, Date date, String name, Float totalAmountOfMoney) {
        orderId = id;
        creationDate = date;
        customerName = name;
        totalAmount = totalAmountOfMoney;
    }


    public Long getOrderId() {
        return orderId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("OrderDTO");
        sb.append("{orderId=").append(orderId);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", customerName='").append(customerName).append('\'');
        sb.append(", totalAmount=").append(totalAmount);
        sb.append('}');
        return sb.toString();
    }
}
