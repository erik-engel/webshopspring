package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepositoryI;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private ProductService productService;

    /*
    @Autowired(required = true)
    @Qualifier(value = "productService")
    public void setProductService(ProductService ps) {
        this.productService = ps;
    }
    */
    public ProductController(ProductService ps){
        this.productService = ps;
    }

    @GetMapping("/opretProduct")
    public String createFormProduct(Model model) {
        model.addAttribute("product",new Product());
        return "product";
    }

    @PostMapping("/createProduct")
    public String createProduct (@ModelAttribute Product product, Model model) {
        productService.createProduct(product);
        //model.addAttribute("product", readAllProducts())
        return "redirect:/oversigtProduct";
    }

    @GetMapping("/oversigtProduct")
    public String readAllProducts (Model model) {
        //model.addAttribute("product",new Product());
        model.addAttribute("products", productService.readAlleProducts());
        return "/index";
    }


    @PostMapping("opdaterProduct/{id}")
    public String updateProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.readOneProduct(id);
        model.addAttribute("product", product);
        return "redigerProduct";
    }

    @GetMapping("sletProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/oversigtProduct";
    }




}
