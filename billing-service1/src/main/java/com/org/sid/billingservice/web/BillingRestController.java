package com.org.sid.billingservice.web;

import com.org.sid.billingservice.entities.Bill;
import com.org.sid.billingservice.entities.ProductItem;
import com.org.sid.billingservice.model.Customer;
import com.org.sid.billingservice.model.Product;
import com.org.sid.billingservice.repository.BillRepository;
import com.org.sid.billingservice.repository.ProductItemRepository;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.Random;

@RestController
public class BillingRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private KeycloakRestTemplate keycloakRestTemplate;
    public BillingRestController(
            BillRepository billRepository, ProductItemRepository productItemRepository,
            KeycloakRestTemplate keycloakRestTemplate) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.keycloakRestTemplate = keycloakRestTemplate;
    }
    @GetMapping(path = "/fullBill/{id}")
    Bill getBill(@PathVariable Long id) {
        Bill bill = billRepository.findById(id).get();
        Customer customer = keycloakRestTemplate.
                getForObject("http://localhost:8092/CUSTOMER-SERVICE/customers/1", Customer.class);
        bill.setCustomer(customer);
        bill.getProductItems().forEach(p -> {
            Product product = keycloakRestTemplate.
                    getForObject("http://localhost:8092/INVENTORY-SERVICE/produits/" + p.getId(), Product.class);
            p.setProduct(product);
        });
        return bill;
    }

    @PostMapping(path = "/test")
    Bill test() {
        Customer customer = keycloakRestTemplate.getForObject("http://localhost:8092/CUSTOMER-SERVICE/customers/1", Customer.class);
        // Customer customer = customerRestClient.getCustomer(1L);
        System.out.println(customer.toString());
        // Product product=productRestClient.getProductById(1L);
        //System.out.println(product.toString());
        Bill bill = billRepository.save(new Bill(null, new Date(), null, customer.getId(), null));
        //PagedModel<Product> products = productRestClient.pageProducts();
        // Collection<ProductItem> productItems=new ArrayList<>();
        PagedModel<Product> products = keycloakRestTemplate.getForObject("http://localhost:8092/INVENTORY-SERVICE/produits/", PagedModel.class);
        assert products != null;
        products.forEach(p -> {
                    ProductItem productItem = new ProductItem();
                    productItem.setPrice(p.getPrice());
                    productItem.setQuantity(1 + new Random().nextInt(100));
                    productItem.setProductId(p.getId());
                    productItem.setBill(bill);
                    productItemRepository.save(productItem);
                }
        );
        return billRepository.save(bill);

    }

}
