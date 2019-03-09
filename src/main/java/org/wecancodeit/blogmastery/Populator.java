package org.wecancodeit.blogmastery;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.blogmastery.models.Author;
import org.wecancodeit.blogmastery.models.Genre;
import org.wecancodeit.blogmastery.models.Post;
import org.wecancodeit.blogmastery.models.Tag;
import org.wecancodeit.blogmastery.repositories.AuthorRepository;
import org.wecancodeit.blogmastery.repositories.GenreRepository;
import org.wecancodeit.blogmastery.repositories.PostRepository;
import org.wecancodeit.blogmastery.repositories.TagRepository;
import org.wecancodeit.reviewsite.models.Review;
import org.wecancodeit.reviewsite.models.ReviewTag;

@Service
public class Populator implements CommandLineRunner {

	@Resource
	private PostRepository postRepo;
	@Resource
	private AuthorRepository authorRepo;
	@Resource
	private GenreRepository genreRepo;
	@Resource
	private TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {
		Author author1 = authorRepo.save(new Author("Anthony"));
		Author author0 = authorRepo.save(new Author("Tulasi"));
		
		Genre genre1 = genreRepo.save(new Genre("Fiction Writing"));
		Genre genre2 = genreRepo.save(new Genre("Non-Fiction Writing"));
		
		Tag tag1 = tagRepo.save(new Tag("Happy"));
		Tag tag2 = tagRepo.save(new Tag("Suspenseful"));
		
		postRepo.save(new Post("Anthony Lam", "He is great", author1, genre1, tag1));
		postRepo.save(new Post("Tulasi Pinjala", "She is great", author0, genre2, tag2));
	}
}
