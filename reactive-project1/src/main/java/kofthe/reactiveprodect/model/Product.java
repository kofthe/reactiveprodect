package kofthe.reactiveprodect.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data

public class Product {

    @Id
    private int id;
    private String name;

}
