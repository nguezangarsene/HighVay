package com.cs425.mpweb.controller;

import com.cs425.mpweb.model.Product;
import com.cs425.mpweb.model.Supplier;
import com.cs425.mpweb.service.ProductService;
import com.cs425.mpweb.service.SupplierService;
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
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@RequestMapping(value = "/mweb/supplier", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("supplier") Supplier supplier,
					   BindingResult result, Model model) {

		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addAttribute("errors", result.getAllErrors());
			return "supplier/edit";
		}

		supplierService.save(supplier);
		return "redirect:/mweb/suppliers";


	}
	@RequestMapping(value="/mweb/suppliers", method = RequestMethod.GET)
	public ModelAndView suppliers(){
		List<Supplier> suppliers = supplierService.findAll();
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("suppliers", suppliers);
		modelAndView.setViewName("supplier/mlist");
		return modelAndView;
	}

}
