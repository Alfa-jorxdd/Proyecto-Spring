package com.alfajorxd.web.product.aplication.command.update;

import com.alfajorxd.web.common.mediator.Request;
import lombok.Data;

@Data
public class ProductUpdateRequest implements Request<Void> {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;

}
