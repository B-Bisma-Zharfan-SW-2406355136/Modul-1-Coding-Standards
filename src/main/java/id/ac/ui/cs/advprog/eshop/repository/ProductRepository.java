package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product){
        product.setProductId(UUID.randomUUID());
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(UUID targetId){
        for(Product product : productData){
            if(product.getProductId().equals(targetId)){
                return product;
            }
        }
        return null;
    }

    public void update(Product newProduct){
        for(Product product : productData){
            if(product.getProductId().equals(newProduct.getProductId())){
                product.setProductName(newProduct.getProductName());
                product.setProductQuantity(newProduct.getProductQuantity());
                break;
            }
        }
    }
}
