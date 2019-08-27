package ru.eltex.laba7.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eltex.laba2.Order;
import ru.eltex.laba7.services.OrderService;

@RestController
public class UserController {

    private OrderService OrderService;

    public UserController(OrderService orderService) {
        OrderService = orderService;
    }

    @GetMapping(params = "command=readall")
    public String readAll() {
        return OrderService.readAll();
    }

    @GetMapping(params = "command=readById")
    public String readById(String order_id) {
        return OrderService.readById(order_id);
    }

    @GetMapping(params = "command=addToCard")
    public String addToCard(String card_id) {
        return OrderService.addToCard(card_id);
    }

    @GetMapping(params = "command=delById")
    public String delById(String order_id) {
        return OrderService.delById(order_id);
    }
}