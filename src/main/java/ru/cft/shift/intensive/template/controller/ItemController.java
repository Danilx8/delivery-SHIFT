package ru.cft.shift.intensive.template.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import ru.cft.shift.intensive.template.dto.ItemDto;
import ru.cft.shift.intensive.template.dto.PurchaseDto;
import ru.cft.shift.intensive.template.util.Mocks;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@Validated
@RestController
@RequestMapping(value = "/store/", produces = APPLICATION_JSON_VALUE)
@Tag(name = "{api.item.tag.name}", description = "{api.item.tag.description}")
public class ItemController {
    
    @Operation(summary = "{api.item.items.summary}")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "{api.item.items.api-responses.200.description}"),
        @ApiResponse(responseCode = "500", description = "{api.server.error}", 
            content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
    })
    @GetMapping
    public ResponseEntity<List<ItemDto>> AllProducts() {
        return ResponseEntity.ok(Mocks.AllItems());
    }

    @Operation(summary = "{api.item.get-by-name.summary}")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "{api.item.get-by-name.api-responses.200.description}"),
        @ApiResponse(responseCode = "404", description = "{api.item.get-by-name.api-responses.404.description}", 
            content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))}),
        @ApiResponse(responseCode = "500", description = "api.server.error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
    })
    @GetMapping("{name}")
    public ResponseEntity<ItemDto> ItemByName(@PathVariable String name) {
        return ResponseEntity.ok(Mocks.ItemByName(name));
    }

    @Operation(summary = "api.item.add-to-cart.summary")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "api.item.add-to-cart.api-responses.200.description"),
        @ApiResponse(responseCode = "404", description = "api.item.get-by-name.api-responses.404.description", 
            content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorControllerAdvice.ErrorResponse.class))})
    })
    @PutMapping("cart")
    public ResponseEntity<Void> AddPurchase(@RequestBody @Valid ItemDto item) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("cart/{id}")
    public ResponseEntity<Void> DeleteUser(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("cart")
    public ResponseEntity<List<PurchaseDto>> AllPurchases() {
        return ResponseEntity.ok(Mocks.AllPurchases());
    }

    @GetMapping("cart/total_cost")
    public ResponseEntity<Float> TotalCost() {
        return ResponseEntity.ok(Mocks.Cost());
    }

    @GetMapping("cart/time")
    public ResponseEntity<Integer> Time() {
        return ResponseEntity.ok(Mocks.Time());
    }
}
