package patterns.practicies.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private String date;
    //Lazy по умолчанию
    @OneToMany(mappedBy = "owner", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    private List<Item> items;

    public Order(String orderDate) {
        this.date = orderDate;
    }

    public void addItem(Item item){
        if (this.items == null)
            this.items =  new ArrayList<>();
        this.items.add(item);
        item.setOwner(this);
    }

    @SneakyThrows
    @Override
    public String toString(){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public Order(Integer id, String orderDate) {
        this.id = id;
        this.date = orderDate;
    }
}
