package org.wecancodeit.blogmastery.respositories;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.blogmastery.models.Tag;
import org.wecancodeit.blogmastery.repositories.AuthorRepository;
import org.wecancodeit.blogmastery.repositories.GenreRepository;
import org.wecancodeit.blogmastery.repositories.PostRepository;
import org.wecancodeit.blogmastery.repositories.TagRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class TagTest {

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
		Tag tag = tagRepo.save(new Tag("Anthony"));

		entityManager.persist(tag);
		entityManager.flush();
		entityManager.clear();

		Tag tagFromDB = tagRepo.findByName("Anthony");

		assertThat(tagFromDB.getName(), is("Anthony"));
	}
}
