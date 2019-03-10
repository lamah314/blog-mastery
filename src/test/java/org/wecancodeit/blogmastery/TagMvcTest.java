package org.wecancodeit.blogmastery;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.blogmastery.controllers.PostController;
import org.wecancodeit.blogmastery.models.Post;
import org.wecancodeit.blogmastery.models.Tag;
import org.wecancodeit.blogmastery.repositories.AuthorRepository;
import org.wecancodeit.blogmastery.repositories.GenreRepository;
import org.wecancodeit.blogmastery.repositories.PostRepository;
import org.wecancodeit.blogmastery.repositories.TagRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class TagMvcTest<Portfolio> {
	 
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
	    private Tag tag;
	    
	    @Test
	    public void shouldRouteToIndiviualPostView() throws Exception {
	        Long tagId = 1L;
	        when(tagRepo.findById(tagId)).thenReturn(Optional.of(tag));
	        mvc.perform(get("/tag/1")).andExpect(view().name(is("/tag/individualTag")));
	    }
	     
	    @Test
	    public void shouldBeOkForIndividualPost() throws Exception {
	    	Long tagId = 1L;
	        when(tagRepo.findById(tagId)).thenReturn(Optional.of(tag));
	    	mvc.perform(get("/tag/1")).andExpect(status().isOk());
    }
     
	    @Test
	    public void shouldPutSinglePostIntoModel() throws Exception {
	    	Long tagId = 1L;
	        when(tagRepo.findById(tagId)).thenReturn(Optional.of(tag));
	        mvc.perform(get("/tag/1")).andExpect(model().attribute("post", is(tag)));
    }
}

