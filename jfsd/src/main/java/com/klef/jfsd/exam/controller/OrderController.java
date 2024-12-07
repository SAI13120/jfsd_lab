package com.klef.jfsd.exam.controller;

import com.klef.jfsd.exam.model.Order;
import com.klef.jfsd.exam.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        if (order.getOrderId() == null) {
            return new ResponseEntity<>("Order ID must not be null", HttpStatus.BAD_REQUEST);
        }
        orderService.addOrder(order);
        return new ResponseEntity<>("Order added successfully!", HttpStatus.CREATED);
    }
}