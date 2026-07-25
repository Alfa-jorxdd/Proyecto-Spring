package com.alfajorxd.web.product.aplication.command.delete;

import com.alfajorxd.web.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDeleteRequest implements Request<Void> {
    private Long id;
}
