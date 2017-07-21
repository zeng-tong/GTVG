package com.homework.sbgtvg.Controller;


import com.homework.sbgtvg.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductListController {

    @Autowired
    private ProductService prods;
    @RequestMapping("/product/list")
    public String product(Model model){

        model.addAttribute("prods",prods.findAll());

        return "product/list";
    }

}
