package com.root.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model) throws Exception {
		System.out.println("Product List");
		
		List<ProductDTO> ar = productService.getList();
		model.addAttribute("list", ar);
		
		return "products/list";	
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail() throws Exception {
		System.out.println("Prdocut Detail");
		
		return "products/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		System.out.println("product add");
		
		return "products/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add2(ProductDTO productDTO) throws Exception {
		 int result = productService.add(productDTO);
		System.out.println(productDTO.getProductName());
		
		String path = "";
		
		if(result > 0) {
			path = "redirect:./list";
		}
		
		return path;
	}
}
