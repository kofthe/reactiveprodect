package kofthe.reactiveproject2.config;

import kofthe.reactiveproject2.model.Product;
import kofthe.reactiveproject2.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RoutesConfig {

    private final ProductService productService;

    public RoutesConfig(ProductService productService) {
        this.productService = productService;
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return route()
                .GET("/products", req -> ok().body(productService.getAll(), Product.class))
                .build();
    }

}
