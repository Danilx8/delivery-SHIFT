package ru.cft.shift.intensive.template.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import ru.cft.shift.intensive.template.dto.CartDto;
import ru.cft.shift.intensive.template.dto.DeliveryDto;
import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.exception.ResourceNotFoundException;
import ru.cft.shift.intensive.template.repository.ProductRepository;
import ru.cft.shift.intensive.template.repository.entity.*;
import ru.cft.shift.intensive.template.service.PutMappingService;
import ru.cft.shift.intensive.template.utils.Mocks;

import java.util.List;

import static org.springframework.http.MediaType.*;

@Validated
@RestController
@RequestMapping(value = "store/", produces = APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Operation(summary = "api.store.products.products.operation.find-by-name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "api.store.products.by-name.api.response.200.find"),
            @ApiResponse(responseCode = "404", description = "api.store.products.by-name.api.response.404.name", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "400", description = "api.store.products.by-name.api.response.404.name", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "api.store.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))})
    })
    @GetMapping(value = "products/{name}")
    public ResponseEntity<ProductDto> product() {
        return ResponseEntity.ok(Mocks.products());
    }


    @Operation(summary = "api.store.products.products.operation.find-id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "api.store.products.by-name.api.response.200.find"),
            @ApiResponse(responseCode = "404", description = "api.store.products.by-name.api.response.404.description", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "api.store.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))})
    })
    @GetMapping(value = "products/{id}")
    public ResponseEntity<ProductDto> productDescription() {
        return ResponseEntity.ok(Mocks.productsDescription());
    }

//    @Operation(summary = "api.store.products.products.operation.cart.added")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "api.store.products.products.operation.cart.add"),
//            @ApiResponse(responseCode = "404", description = "api.store.products.by-name.api.response.404.description", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))}),
//            @ApiResponse(responseCode = "500", description = "api.store.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))})
//    })
//    @PutMapping("cart/{id}",
//        consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
//    public ResponseEntity<CartDto> addProduct(@PathVariable String id, @RequestBody CartDto cartDto) {
//        CartDto returnValue = new CartDto();
//        BeanUtils.copyProperties(cartDto, );
//        CartDto updatedUserDetails = productRepository.addProduct(cartDto.getId(), );
//        BeanUtils.copyProperties(updatedUserDetails, returnValue);
//        return ResponseEntity.ok(returnValue);
//    }


    @Operation(summary = "api.store.products.products.operation.cart.delete")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "api.store.products.by-name.api.response.200.find"),
            @ApiResponse(responseCode = "404", description = "api.store.products.by-name.api.response.404.description", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "api.store.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))})
    })
    @DeleteMapping(value = "cart/{name}")
    public ResponseEntity<Void> delete(@PathVariable String name) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "api.store.products.products.operation.cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "api.store.products.by-name.api.response.200.find"),
            @ApiResponse(responseCode = "500", description = "api.store.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))})
    })
    @GetMapping(value = "cart")
    public ResponseEntity<List<CartDto>> cartProducts() {
        return ResponseEntity.ok(Mocks.cartProducts());
    }

    //    @Operation(summary = "api.store.products.products.operation.cart.added")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "api.store.products.products.operation.cart.add"),
//            @ApiResponse(responseCode = "404", description = "api.store.products.by-name.api.response.404.description", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))}),
//            @ApiResponse(responseCode = "500", description = "api.store.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))})
//    })
//    @PutMapping("cart/{id}")
//    public ResponseEntity<CartDto> addProduct(@PathVariable long id, @RequestBody CartDto cartDto) {
//        CartDto addProduct = productRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));
//        addProduct.setCategory_id(productRepository.getCategory_id());
//        productRepository.save(addProduct);
//        return ResponseEntity.ok(addProduct);
//    }


    @Operation(summary = "api.store.products.products.operation.delivery.time")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "api.store.products.by-name.api.response.200.find"),
            @ApiResponse(responseCode = "404", description = "api.store.products.by-name.api.response.404.description", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "api.store.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))})
    })
    @GetMapping(value = "delivery")
    public ResponseEntity<DeliveryDto> timeDelivery() {
        return ResponseEntity.ok(Mocks.timeDelivery());
    }


    @Operation(summary = "api.store.products.products.operation.order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "api.store.products.by-name.api.response.200.order"),
            @ApiResponse(responseCode = "500", description = "api.store.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))})
    })
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DeliveryDto>> create(@Valid @RequestBody DeliveryDto order) {
        return ResponseEntity.ok(Mocks.deliveryDto(order));
    }
}
