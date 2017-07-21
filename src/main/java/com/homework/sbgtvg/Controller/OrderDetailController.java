package com.homework.sbgtvg.Controller;


import com.homework.sbgtvg.Model.Order;
import com.homework.sbgtvg.Model.OrderLine;
import com.homework.sbgtvg.Services.CustomerService;
import com.homework.sbgtvg.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class OrderDetailController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/order/details")
    public String OrderDetail(@RequestParam("orderId")Integer id,
                              Model model){

        Order order = orderService.findById(id);





        Map<Integer,Double> map = new HashMap<>();

        Double sum = 0.0;

        for(OrderLine orderLine : order.getOrderLines()){

            sum += orderLine.getAmount()*Double.valueOf(orderLine.getPurchasePrice().toString());
        }
        map.put(order.getId(),sum);

        model.addAttribute("order",order);

        model.addAttribute("map",map);
        return "/order/details";
    }
}
