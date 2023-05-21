package project.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "items")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Item {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String creationDate;

    @Column(name = "price")
    private Integer price;

    public Item(String name, String  creationDate, Integer price){
        this.name = name;
        this.creationDate = creationDate;
        this.price = price;
    }
}
