package kofthe.reactiveprodect.service;

import kofthe.reactiveprodect.model.Product;
import kofthe.reactiveprodect.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<Product> getProducts() { //whole method 15 seconds to execute.
        return productRepository.findAll()
                .delayElements(Duration.ofSeconds(5)); //for any element add sleep duration
    }

}
