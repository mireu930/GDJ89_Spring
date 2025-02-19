package com.root.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList() throws Exception {
		System.out.println("Product List");
		
		List<ProductDTO> ar = productService.getList();
//		model.addAttribute("list", ar);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", ar);
		
		modelAndView.setViewName("products/list");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(ModelAndView modelAndView) throws Exception {
		System.out.println("Prdocut Detail");
		
		ProductDTO productDTO = new ProductDTO();
		productDTO = productService.getDetail(productDTO);
		
		modelAndView.addObject("dto", productDTO);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		System.out.println("product add");
		
		return "products/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(ProductDTO productDTO) throws Exception {
		 int result = productService.add(productDTO);
		System.out.println(productDTO.getProductName());
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result > 0) {
			modelAndView.setViewName("redirect:./list");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(ProductDTO productDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("dto", productService.getDetail(productDTO));
		modelAndView.setViewName("products/update");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView udpate(ProductDTO productDTO) throws Exception {
		int result = productService.update(productDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result>0) {
			modelAndView.setViewName("redirect:./list");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public ModelAndView delete(ProductDTO productDTO) throws Exception {
		int result = productService.delete(productDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result>0) {
			modelAndView.setViewName("redirect:./list");
		}
		return modelAndView;
	}
}
