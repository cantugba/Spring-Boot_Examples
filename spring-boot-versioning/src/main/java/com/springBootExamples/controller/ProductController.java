package com.springBootExamples.controller;

import com.springBootExamples.dto.ProductV1;
import com.springBootExamples.dto.ProductV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    //URI Versioning

   @GetMapping("/v1/product")
   public ResponseEntity<ProductV1> pathVersionV1() {
       return ResponseEntity.of(Optional.of(new ProductV1("Hp laptop")));
   }

    @GetMapping("/v2/product")
    public ResponseEntity<ProductV2> pathVersionV2() {
        return ResponseEntity.of(Optional.of(new ProductV2("Hp laptop", BigDecimal.TEN)));
    }

    //param Versioning

    @GetMapping(value = "/param/product", params = "apiVersion=1")
    public ResponseEntity<ProductV1> paramVersionV1() {
        return ResponseEntity.of(Optional.of(new ProductV1("Hp laptop")));
    }

    @GetMapping(value = "/param/product", params = "apiVersion=2")
    public ResponseEntity<ProductV2> paramVersionV2() {
        return ResponseEntity.of(Optional.of(new ProductV2("Hp laptop", BigDecimal.TEN)));
    }

    //header Versioning

    @GetMapping(value = "/header/product", headers = "X-API-VERSION=1")
    public ResponseEntity<ProductV1> headerVersionV1() {
        return ResponseEntity.of(Optional.of(new ProductV1("Hp laptop")));
    }

    @GetMapping(value = "/header/product", headers = "X-API-VERSION=2")
    public ResponseEntity<ProductV2> headerVersionV2() {
        return ResponseEntity.of(Optional.of(new ProductV2("Hp laptop", BigDecimal.TEN)));
    }

}
