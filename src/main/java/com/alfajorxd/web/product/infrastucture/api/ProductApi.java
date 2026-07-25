package com.alfajorxd.web.product.infrastucture.api;

import com.alfajorxd.web.product.infrastucture.api.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductApi {

    ResponseEntity<List<ProductDTO>> getAllProducts(@RequestParam(required = false) String pageSize);
    ResponseEntity<ProductDTO> getProductById(@PathVariable Long id);
    ResponseEntity<Void> saveProduct(@RequestBody ProductDTO product);
    ResponseEntity<Void> updateProduct(@RequestBody ProductDTO product);
    ResponseEntity<Void> deleteProduct(@PathVariable Long id);

}
