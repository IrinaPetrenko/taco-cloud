package tacos.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.configurations.OrderProps;
import tacos.domain.Order;
import tacos.repository.OrderRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepository;
    private OrderProps orderProps;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrderProps orderProps) {
        this.orderRepository = orderRepository;
        this.orderProps = orderProps;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@RequestBody Order requested, @Valid Order order, Errors error,
                               SessionStatus sessionStatus) {
        order.appendFields(requested);
//        if (error.hasErrors()) {
//            return "orderForm";
//        }
        log.info("Order submitted: " + requested);
        log.info("This is test order property" + orderProps.getPageSize());
        orderRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
