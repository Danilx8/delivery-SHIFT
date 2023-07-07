package ru.cft.shift.intensive.template.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ru.cft.shift.intensive.template.dto.ItemDto;
import ru.cft.shift.intensive.template.util.Mocks;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/orders/", produces = APPLICATION_JSON_VALUE)
public class PurchaseController {
    
    @PostMapping
    public ResponseEntity<List<String>> PurchaseCartItems(@RequestBody @Valid ItemDto item) {
        return ResponseEntity.ok(Mocks.CreatedPurchasesIds());
    }

    
}
