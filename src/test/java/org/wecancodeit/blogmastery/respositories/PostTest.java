package org.wecancodeit.blogmastery.respositories;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.blogmastery.models.Author;
import org.wecancodeit.blogmastery.models.Post;
import org.wecancodeit.blogmastery.repositories.AuthorRepository;
import org.wecancodeit.blogmastery.repositories.GenreRepository;
import org.wecancodeit.blogmastery.repositories.PostRepository;
import org.wecancodeit.blogmastery.repositories.TagRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class PostTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	PostRepository postRepo;
	@Resource
	AuthorRepository authorRepo;
	@Resource
	GenreRepository genreRepo;
	@Resource
	TagRepository tagRepo;

	@Test
	public void shouldSaveAndLoadPost() {
		Author author = new Author("Anthony");
		Post post = postRepo
				.save(new Post("Anthony Lam", "Hello World", ));

		entityManager.persist(post);
		entityManager.flush();
		entityManager.clear();

		Post postFromDB = postRepo.findByTitle("Anthony Lam");

		assertThat(postFromDB.getTitle(), is("Anthony Lam"));
	}
}
