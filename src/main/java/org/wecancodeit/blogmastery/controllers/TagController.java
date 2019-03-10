package org.wecancodeit.blogmastery.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.blogmastery.models.Author;
import org.wecancodeit.blogmastery.models.Post;
import org.wecancodeit.blogmastery.models.Tag;
import org.wecancodeit.blogmastery.repositories.AuthorRepository;
import org.wecancodeit.blogmastery.repositories.GenreRepository;
import org.wecancodeit.blogmastery.repositories.PostRepository;
import org.wecancodeit.blogmastery.repositories.TagRepository;

@Controller
@RequestMapping("/tag")
public class TagController {

	@Resource
	PostRepository postRepo;
	@Resource
	AuthorRepository authorRepo;
	@Resource
	GenreRepository genreRepo;
	@Resource
	TagRepository tagRepo;
	
	@GetMapping("/") 
	public String getTagHome(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		return "/tag/tagHome";
	}
	
	@GetMapping("/{tagId}") 
	public String getTag(Model model, @PathVariable Long tagId) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		model.addAttribute("tag", tagRepo.findById(tagId).get());
		return "/tag/individualTag";
	}
	
	@GetMapping("/{tagId}/addPostToTag")
	public String addPostToTag(Model model, @PathVariable Long tagId) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		model.addAttribute("tag", tagRepo.findById(tagId).get());
		return "tag/addPostToTag";
	}

	@PostMapping("/{tagId}/addPostToTag")
	public String addPostToAuthor(Model model, @PathVariable Long tagId, Long postId) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		model.addAttribute("tag", tagRepo.findById(tagId).get());

		Post postToAdd = postRepo.findById(postId).get();
		Tag tagToAdjust = tagRepo.findById(tagId).get();
		tagToAdjust.addPostToTag(postToAdd);
		postToAdd.addTagToPost(tagToAdjust);
		tagRepo.save(tagToAdjust);

		return "redirect:/tag/{tagId}";
	}
	
	@GetMapping("/addTag") 
	public String addTag(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		
		return "/tag/addTag";
	}
	
	@PostMapping("/addTag") 
	public String addTag(Model model, String tagName) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		
		
		for(Tag tag : tagRepo.findAll()) {
			if(tagName.equalsIgnoreCase(tag.getName())){
				return "redirect:/tag/";
			}
		}
		tagRepo.save(new Tag(tagName));
		return "redirect:/tag/";
	}
}
