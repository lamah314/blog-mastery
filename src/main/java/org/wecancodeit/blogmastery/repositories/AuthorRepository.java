package org.wecancodeit.blogmastery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.blogmastery.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

	Author findByName(String string);

}
