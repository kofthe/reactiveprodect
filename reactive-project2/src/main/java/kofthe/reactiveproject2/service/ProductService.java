package kofthe.reactiveproject2.service;

import kofthe.reactiveproject2.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service //Spring Context
public class ProductService {

    public Flux<Product>  getAll() {

        var product1 = new Product("Computer");
        var product2 = new Product("Telephone"); //from DB.


        Flux<Product> products = Flux.fromStream(List.of(product1, product2).stream())
                .delayElements(Duration.ofSeconds(3));  //simulate something happens with each product.

        return products;
    }

}
