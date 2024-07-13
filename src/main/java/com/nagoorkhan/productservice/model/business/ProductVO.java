package com.nagoorkhan.productservice.model.business;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductVO {
    @Id
    private String pid;
    private String productName;
    private Long price;
    private String description;

}
