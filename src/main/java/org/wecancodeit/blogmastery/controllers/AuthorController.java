package org.wecancodeit.blogmastery.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.blogmastery.models.Author;
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
	public String getAuthorHome(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		return "/author/authorHome";
	}

	@GetMapping("/{authorId}")
	public String getAuthor(Model model, @PathVariable Long authorId) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		model.addAttribute("author", authorRepo.findById(authorId).get());
		return "/author/individualAuthor";
	}

	@GetMapping("/addAuthor")
	public String addTag(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());

		return "/author/addAuthor";
	}

	@PostMapping("/addAuthor")
	public String addAuthor(Model model, String authorName) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());

		for (Author author : authorRepo.findAll()) {
			if (authorName.equalsIgnoreCase(author.getName())) {
				return "redirect:/author/";
			}
		}
		authorRepo.save(new Author(authorName));
		return "redirect:/author/";
	}
}
