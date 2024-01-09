package com.doubleD.shopapp.controllers;

import com.doubleD.shopapp.models.Order;
import com.doubleD.shopapp.models.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/orders")
//@Validated
public class OrderController {
    //Tạo order
    //http://localhost:8088/api/v1/orders
    @PostMapping("")
    ResponseEntity<?> createOrder(
            @Valid @RequestBody Order order,
            BindingResult result
    ){
        try {
            if (result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            return ResponseEntity.ok().body("Create Order successfully");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    //Lấy thông tin order sử dụng user_id
    // http://localhost:8088/api/v1/orders/{user_id}
    @GetMapping("/{user_id}")
    ResponseEntity<?> getOrderUsingUserId(@Valid @PathVariable("user_id") Long user_id){
        try{
            return ResponseEntity.ok().body("Success get Order using user_id: " + user_id);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    //Cập nhật Order
    // Đây là công việc của người quản trị
    // http://localhost:8088/api/v1/orders/{id}
    @PutMapping("/{id}")
    ResponseEntity<?> updateOrderUsingId(
            @Valid @PathVariable("id") Long id,
            @Valid @RequestBody Order order
    ){
        try{
            return ResponseEntity.ok().body("Success update Order using id: " + id);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    //Xóa đơn hàng sử dụng id
    //Xóa mềm is_active = fail
    //http://localhost:8088/api/v1/orders
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteOrderUsingId(
            @Valid @PathVariable("id") Long id
    ){
        try{
            return ResponseEntity.ok().body("Success delete Order using id: " + id);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
