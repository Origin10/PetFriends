package com.bookstore.controller;

import java.security.Principal;
import java.util.List;

import com.bookstore.domain.Mem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.domain.Book;
import com.bookstore.service.StuffService;
import com.bookstore.service.MemService;

@Controller
public class SearchController {
	@Autowired
	private MemService memService;
	
	@Autowired
	private StuffService stuffService;

	@RequestMapping("/searchByCategory")
	public String searchByCategory(
			@RequestParam("category") String category,
			Model model, Principal principal
			){
		if(principal!=null) {
			String username = principal.getName();
			Mem user = memService.findByMemname(username);
			model.addAttribute("user", user);
		}
		
		String classActiveCategory = "active"+category;
		classActiveCategory = classActiveCategory.replaceAll("\\s+", "");
		classActiveCategory = classActiveCategory.replaceAll("&", "");
		model.addAttribute(classActiveCategory, true);
		
		List<Book> bookList = stuffService.findByCategory(category);
		
		if (bookList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "bookshelf";
		}
		
		model.addAttribute("bookList", bookList);
		
		return "bookshelf";
	}
	
	@RequestMapping("/searchBook")
	public String searchBook(
			@ModelAttribute("keyword") String keyword,
			Principal principal, Model model
			) {
		if(principal!=null) {
			String username = principal.getName();
			Mem user = memService.findByMemname(username);
			model.addAttribute("user", user);
		}
		
		List<Book> bookList = stuffService.blurrySearch(keyword);
		
		if (bookList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "bookshelf";
		}
		
		model.addAttribute("bookList", bookList);
		
		return "bookshelf";
	}
}
