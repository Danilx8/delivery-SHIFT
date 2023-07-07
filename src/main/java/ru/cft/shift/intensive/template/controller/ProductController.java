package ru.cft.shift.intensive.template.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.OverridesAttribute;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
//import ru.cft.shift.intensive.template.dto.CartDto;
//import ru.cft.shift.intensive.template.dto.ProductDescriptionDto;
import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.dto.ProductIdDto;
import ru.cft.shift.intensive.template.exception.ProductNotFoundException;
import ru.cft.shift.intensive.template.utils.Mocks;

import java.util.List;

import static org.springframework.http.MediaType.*;

@Validated
@RestController
@RequestMapping(value = "store/cart", produces = APPLICATION_JSON_VALUE)
public class ProductController {

    // Создать товар
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductIdDto> create(@Valid @RequestBody ProductDto product) {
        return ResponseEntity.ok(Mocks.productIdDto(product));
    }

    // Удалить товар
    @DeleteMapping(value = "{name}")
    public ResponseEntity<Void> delete(@PathVariable @Size(min = 3, max = 255) String name) {
        return ResponseEntity.ok().build();
    }

    // Получить все товары
    @GetMapping
    public ResponseEntity<List<ProductDto>> list(){
        return ResponseEntity.ok(Mocks.product());
    }

    @GetMapping(value = "{name}")
    public  ResponseEntity<ProductDto> productByName(@PathVariable @Size(min = 3, max = 255) String name){
        throw  new ProductNotFoundException();
    }

//    @Operation(summary = "api.store.products.products.operation.find-by-name")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "api.store.products.by-name.api.response.200.find"),
//            @ApiResponse(responseCode = "404", description = "api.store.products.by-name.api.response.404.name", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))}),
//            @ApiResponse(responseCode = "400", description = "api.store.products.by-name.api.response.404.name", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))}),
//            @ApiResponse(responseCode = "500", description = "api.store.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))})
//    })
//    @GetMapping(value = "products/{name}")
//    public ResponseEntity<ProductDto> product() {
//        return ResponseEntity.ok(Mocks.products());
//    }


//    @Operation(summary = "api.store.products.products.operation.find-id")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "api.store.products.by-name.api.response.200.find"),
//            @ApiResponse(responseCode = "404", description = "api.store.products.by-name.api.response.404.description", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))}),
//            @ApiResponse(responseCode = "500", description = "api.store.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))})
//    })
//    @GetMapping(value = "products/id")
//    public ResponseEntity<ProductDescriptionDto> productDescription() {
//        return ResponseEntity.ok(Mocks.productsDescription());
//    }
}
