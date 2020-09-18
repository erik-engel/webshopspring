package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private ProductService ps;
    /*
    @Autowired(required = true)
    @Qualifier(value = "productService")
    public ProductController(ProductService productService) {
        this.ps = productService;
    }
*/
    @GetMapping("/opretProduct")
    public String createFormProduct(Model model) {
        model.addAttribute("product",new Product());
        return "product";
    }

    @PostMapping("/createProduct")
    public String createProduct (@ModelAttribute Product product, Model model) {
        ps.createProduct(product);
        //model.addAttribute("product", readAllProducts())
        return "redirect:/index";
    }

    @GetMapping("/oversigtProduct")
    public String readAllProducts (Model model) {
        model.addAttribute("products", ps.readAlleProducts());
        return "index";
    }



    @PostMapping("opdaterProduct/{id}")
    public String updateProduct(@PathVariable("id") int id, Model model) {
        Product product = ps.readOneProduct(id);
        model.addAttribute("product", product);
        return "redigerProduct";
    }

    @GetMapping("sletProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        ps.deleteProduct(id);
        return "redirect:/index";
    }




}
