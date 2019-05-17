package com.cs425.mpweb.controller;

import com.cs425.mpweb.model.Product;
import com.cs425.mpweb.model.Supplier;
import com.cs425.mpweb.service.ProductService;
import com.cs425.mpweb.service.SupplierService;
import com.cs425.mpweb.service.impl.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
    @Autowired
    private SupplierService supplierService;


	@RequestMapping(value="/mweb/products", method = RequestMethod.GET)
	public ModelAndView students(Model model){
		List<Product> products = productService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		for(int i=0;i<products.size();i++){
			Supplier msup=supplierService.findOne(products.get(i).getSupplier().getSup_id());
			products.get(i).setName_supplier(msup.getName());
		}
		modelAndView.addObject("products", products);
		List<Supplier> suppliers = supplierService.findAll();
		/*
		logger.trace("A TRACE Message");
		logger.debug("A DEBUG Message");
		logger.info("An INFO Message");
		logger.warn("A WARN Message");
		logger.error("An ERROR Message");
		*/

		modelAndView.addObject("suppliers", suppliers);
		model.addAttribute("msup", new Supplier());
		modelAndView.setViewName("product/mlist");
		return modelAndView;
	}
    @RequestMapping(value="/mweb/listeX", method = RequestMethod.GET)
    public ModelAndView products(){
        List<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("product/mlist");
        return modelAndView;
    }
	
	@RequestMapping(value="/mweb/product", method = RequestMethod.GET)
	public String create(Model model){

		model.addAttribute("product", new Product());
		return "product/edit";
	}

	@RequestMapping(value = "/mweb/product", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("product") Product product,
                       BindingResult result, Model model)  {

		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addAttribute("errors", result.getAllErrors());
			return "product/edit";
		}
		Supplier msup=new Supplier();
		msup.setSup_id(product.getIdsup());
		product.setSupplier(msup);
        productService.save(product);
		return "redirect:/mweb/products";
	}	
	
	@RequestMapping(value="/mweb/product/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, Model model){
		model.addAttribute("pr", productService.findOne(id));
		return "product/edit";
	}
	
	@RequestMapping(value="/mweb/product/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model){
        productService.delete(id);
		return "redirect:/mweb/products";
	}	
}
