package com.grpc.demoGRPC.demoGRPC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @GetMapping("/item")
    public String getItem() {return "Item selected";}
}
