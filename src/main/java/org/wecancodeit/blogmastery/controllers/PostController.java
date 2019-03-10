package org.wecancodeit.blogmastery.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.blogmastery.models.Post;
import org.wecancodeit.blogmastery.repositories.AuthorRepository;
import org.wecancodeit.blogmastery.repositories.GenreRepository;
import org.wecancodeit.blogmastery.repositories.PostRepository;
import org.wecancodeit.blogmastery.repositories.TagRepository;

@Controller
@RequestMapping("/post")
public class PostController {

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
		return "/post/postHome";
	}
	
	@GetMapping("/{postId}") 
	public String getPost(Model model, @PathVariable Long postId) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		model.addAttribute("post", postRepo.findById(postId).get());
		return "/post/individualPost";
	}
	@GetMapping("/addPost") 
	public String addPost(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		
		return "/post/addPost";
	}
	
	@PostMapping("/addPost") 
	public String addPost(Model model, String postTitle, String postBody, Long authorId, Long genreId, Long tagId) {
		model.addAttribute("authors", authorRepo.findAll());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("genres", genreRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		
		
		for(Post post : postRepo.findAll()) {
			if(postTitle.equalsIgnoreCase(post.getTitle())){
				return "redirect:/post/";
			}
		}
		postRepo.save(new Post(postTitle, postBody, authorRepo.findById(authorId).get(), genreRepo.findById(genreId).get(), tagRepo.findById(tagId).get()));
		return "redirect:/post/";
	}
}
