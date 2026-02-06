package id.cs.ui.ac.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter @Setter
public class product {
    private UUID productId;
    private String productName;
    private int productQuantity;
}
