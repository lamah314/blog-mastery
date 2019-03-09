package org.wecancodeit.blogmastery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.blogmastery.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

	Post findByTitle(String string);

}
