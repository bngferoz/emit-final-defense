package com.feroz.ecommerce.controller;


import com.feroz.ecommerce.dto.Purchase;
import com.feroz.ecommerce.dto.PurchaseResponse;
import com.feroz.ecommerce.service.CheckoutService;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    @Autowired
    private Environment env;
    
    
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping("status/check")
    public String status() {
    	return "Working on port : "+env.getProperty("local.server.port");
    }
    
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }

}









