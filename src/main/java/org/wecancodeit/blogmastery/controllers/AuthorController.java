package org.wecancodeit.blogmastery.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.blogmastery.repositories.AuthorRepository;
import org.wecancodeit.blogmastery.repositories.GenreRepository;
import org.wecancodeit.blogmastery.repositories.PostRepository;
import org.wecancodeit.blogmastery.repositories.TagRepository;

@Controller
@RequestMapping("/author")
public class AuthorController {

	@Resource
	PostRepository postRepo;
	@Resource
	AuthorRepository authorRepo;
	@Resource
	GenreRepository genreRepo;
	@Resource
	TagRepository tagRepo;
	
	@GetMapping("/") 
	public String getAuthor(Model model, Long postId, Long authorId, Long genreId, Long tagId) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		model.addAttribute("post", postRepo.findById(postId).get());
		model.addAttribute("author", authorRepo.findById(authorId).get());
		model.addAttribute("genre", genreRepo.findById(genreId).get());
		model.addAttribute("tag", tagRepo.findById(tagId).get());
		return "/author/home";
	}
}
