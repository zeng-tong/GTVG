package com.homework.sbgtvg.Controller;


import com.homework.sbgtvg.Model.Order;
import com.homework.sbgtvg.Model.OrderLine;
import com.homework.sbgtvg.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderListController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/list")
    public String order(Model model){


        List<Order> orderList = orderService.findAll();

        Map<Integer,Double> map = new HashMap<>();

        for (Order order : orderList){

            Double sum = 0.0;

            for(OrderLine orderLine : order.getOrderLines()){
                sum += orderLine.getAmount()*Double.valueOf(orderLine.getPurchasePrice().toString());
            }
            map.put(order.getId(),sum);
        }

        model.addAttribute("orders",orderService.findAll());

        model.addAttribute("map",map);

        return "/order/list";
    }


}
