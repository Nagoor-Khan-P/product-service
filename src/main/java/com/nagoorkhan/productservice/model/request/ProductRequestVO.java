package com.nagoorkhan.productservice.model.request;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestVO {
    private String productName;
    private Long price;
    private String description;

}
