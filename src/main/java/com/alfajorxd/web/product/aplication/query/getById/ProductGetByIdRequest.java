package com.alfajorxd.web.product.aplication.query.getById;

import com.alfajorxd.web.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductGetByIdRequest implements Request<ProductGetByIdResponse> {
    private Long id;
}
