package project.model;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    private String name;
    private String creationDate;
    private Integer price;

}
