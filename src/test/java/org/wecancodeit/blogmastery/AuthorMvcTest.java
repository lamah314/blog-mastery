package org.wecancodeit.blogmastery;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.blogmastery.controllers.AuthorController;
import org.wecancodeit.blogmastery.models.Author;
import org.wecancodeit.blogmastery.models.Post;
import org.wecancodeit.blogmastery.repositories.AuthorRepository;
import org.wecancodeit.blogmastery.repositories.GenreRepository;
import org.wecancodeit.blogmastery.repositories.PostRepository;
import org.wecancodeit.blogmastery.repositories.TagRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorMvcTest<Portfolio> {

	@Resource
	private MockMvc mvc;

	@MockBean
	private PostRepository postRepo;

	@MockBean
	private AuthorRepository authorRepo;

	@MockBean
	private GenreRepository genreRepo;

	@MockBean
	private TagRepository tagRepo;

	@Mock
	private Author author;

	@Test
	public void shouldRouteToIndiviualAuthorView() throws Exception {
		Long authorId = 1L;
		when(authorRepo.findById(authorId)).thenReturn(Optional.of(author));
		mvc.perform(get("/author/1")).andExpect(view().name(is("/author/individualAuthor")));
	}

	@Test
	public void shouldBeOkForIndividualAuthor() throws Exception {
		Long authorId = 1L;
		when(authorRepo.findById(authorId)).thenReturn(Optional.of(author));
		mvc.perform(get("/author/1")).andExpect(status().isOk());
	}

	@Test
	public void shouldPutSingleAuthorIntoModel() throws Exception {
		Long authorId = 1L;
		when(authorRepo.findById(authorId)).thenReturn(Optional.of(author));
		mvc.perform(get("/author/1")).andExpect(model().attribute("author", is(author)));
	}
}
