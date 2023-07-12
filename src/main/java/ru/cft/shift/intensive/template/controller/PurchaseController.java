package ru.cft.shift.intensive.template.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ru.cft.shift.intensive.template.dto.OrderDto;
import ru.cft.shift.intensive.template.dto.ProductDto;
import ru.cft.shift.intensive.template.dto.PurchaseDto;
import ru.cft.shift.intensive.template.service.PurchaseService;
import ru.cft.shift.intensive.template.service.impl.PurchaseServiceImpl;
import ru.cft.shift.intensive.template.util.Mocks;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.validation.annotation.Validated;

@Validated
@RestController
@RequestMapping(value = "orders", produces = APPLICATION_JSON_VALUE)
@Tag(name = "api.purchase.tag.name", description = "api.purchase.tag.description")
public class PurchaseController {
    
    private final PurchaseServiceImpl service;
    
    public PurchaseController(PurchaseServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "api.purchase.create-request.summary")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "api.purchase.create-request.api-responses.200.description"),
        @ApiResponse(responseCode = "500", description = "api.server.error", 
        content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
    })
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> PurchaseCartProducts(@RequestBody @Valid OrderDto order) { //создание позиции на покупку
        service.PurchaseCartProducts(order);    
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "api.purchase.get-whole-cart.summary")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "api.purchase.get-whole-cart.api-responses.200.description"),
        @ApiResponse(responseCode = "500", description = "api.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
    })
    @GetMapping("cart")
    public ResponseEntity<List<PurchaseDto>> AllPurchases() { //получение всех заказов в корзине
        return ResponseEntity.ok(Mocks.AllPurchases());
    }

    @Operation(summary = "api.purchase.add-to-cart.summary")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "api.purchase.add-to-cart.api-responses.200.description"),
        @ApiResponse(responseCode = "500", description = "api.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
    })
    @PostMapping(path = "cart", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> AddPurchase(@RequestBody @Valid ProductDto product) {  //добавление товара в корзину
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "api.purchase.delete-from-cart.summary")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "api.purchase.delete-from-cart.api-responses.200.description"),
        @ApiResponse(responseCode = "500", description = "api.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
    })
    @DeleteMapping("cart/{id}") 
    public ResponseEntity<Void> DeleteProduct(@PathVariable String id) { //удаление товара из каталога
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "api.purchase.get-total-cost.summary")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "api.purchase.get-total-cost.api-responses.200.description"),
        @ApiResponse(responseCode = "500", description = "api.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
    })
    @GetMapping("cart/total_cost")
    public ResponseEntity<Float> TotalCost() { //итоговая цена
        return ResponseEntity.ok(Mocks.Cost());
    }

    @Operation(summary = "api.purchase.get-time.summary")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "api.purchase.get-time.api-responses.200.description"),
        @ApiResponse(responseCode = "500", description = "api.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
    })
    @GetMapping("cart/time")
    public ResponseEntity<Integer> Time() { //получение времени доставки
        return ResponseEntity.ok(Mocks.Time());
    }
}
