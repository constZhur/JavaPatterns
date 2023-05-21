package project.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private String orderDate;

    public Order(String orderDate) {
        this.orderDate = orderDate;
    }
}
