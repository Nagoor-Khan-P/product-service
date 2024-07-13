package com.nagoorkhan.productservice.model.response;

import com.nagoorkhan.productservice.model.business.ProductVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponseVO {
    @Id
    private String pid;
    private String productName;
    private Long price;
    private String description;
}
