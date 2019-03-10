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

public class AuthorControllerTest {

	@InjectMocks
	private AuthorController underTest;
	
	@Mock
	private PostRepository postRepo;
	
	@Mock
	private Post post;
	
	@Mock
	private Iterable<Post> posts;
	
	@Mock
	private AuthorRepository authorRepo;
	
	@Mock
	private Author author;
	
	@Mock
	private Iterable<Author> authors;
	
	@Mock
	private TagRepository tagRepo;
	
	@Mock
	private Tag tag;
	
	@Mock
	private Iterable<Tag> tags;
	
	@Mock
	private GenreRepository genreRepo;
	
	@Mock
	private Genre genre;
	
	@Mock
	private Iterable<Genre> genres;
	
	@Mock
	private Model model;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldPullPostsAuthorsGenresTagsToModel() throws Exception {
		when(postRepo.findAll()).thenReturn(posts);
		when(authorRepo.findAll()).thenReturn(authors);
		when(genreRepo.findAll()).thenReturn(genres);
		when(tagRepo.findAll()).thenReturn(tags);
		
		underTest.getAuthorHome(model);

		verify(model).addAttribute("posts", posts);
		verify(model).addAttribute("authors", authors);
		verify(model).addAttribute("genres", genres);
		verify(model).addAttribute("tags", tags);
	}
	
	@Test
	public void shouldAddAuthorToModel() {
		Long authorId = 1L;
		when(authorRepo.findById(authorId)).thenReturn(Optional.of(author));

		underTest.getAuthor(model, authorId);

		verify(model).addAttribute("author", author);
	}
	
	@Test
	public void shouldPullPostsAuthorsGenresTagsToAddModel() throws Exception {
		when(postRepo.findAll()).thenReturn(posts);
		when(authorRepo.findAll()).thenReturn(authors);
		when(genreRepo.findAll()).thenReturn(genres);
		when(tagRepo.findAll()).thenReturn(tags);
		
		underTest.addAuthor(model);

		verify(model).addAttribute("posts", posts);
		verify(model).addAttribute("authors", authors);
		verify(model).addAttribute("genres", genres);
		verify(model).addAttribute("tags", tags);
	}


}
