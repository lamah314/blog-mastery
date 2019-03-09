package org.wecancodeit.blogmastery.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.wecancodeit.blogmastery.models.Author;
import org.wecancodeit.blogmastery.models.Genre;
import org.wecancodeit.blogmastery.models.Post;
import org.wecancodeit.blogmastery.models.Tag;
import org.wecancodeit.blogmastery.repositories.AuthorRepository;
import org.wecancodeit.blogmastery.repositories.GenreRepository;
import org.wecancodeit.blogmastery.repositories.PostRepository;
import org.wecancodeit.blogmastery.repositories.TagRepository;

public class MainControllerTest {

	@InjectMocks
	private MainController underTest;
	
	@Mock
	private PostRepository postRepo;
	
	@Mock
	private Post post;
	
	@Mock
	private AuthorRepository authorRepo;
	
	@Mock
	private Author author;
	
	@Mock
	private TagRepository tagRepo;
	
	@Mock
	private Tag tag;
	
	@Mock
	private GenreRepository genreRepo;
	
	@Mock
	private Genre genre;
	
	@Mock
	private Model model;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

//	@Test
//	public void shouldAddPostAuthorGenreTagToModel() throws Exception {
//		Long postId = 1L;
//		Long authorId = 1L;
//		Long genreId = 1L;
//		Long tagId = 1L;
//		when(postRepo.findById(postId)).thenReturn(Optional.of(post));
//		when(authorRepo.findById(authorId)).thenReturn(Optional.of(author));
//		when(genreRepo.findById(genreId)).thenReturn(Optional.of(genre));
//		when(tagRepo.findById(tagId)).thenReturn(Optional.of(tag));
//		
//
//		underTest.getHome(model, postId, authorId, genreId, tagId);
//
//		verify(model).addAttribute("post", post);
//		verify(model).addAttribute("author", author);
//		verify(model).addAttribute("genre", genre);
//		verify(model).addAttribute("tag", tag);
//	}


}
