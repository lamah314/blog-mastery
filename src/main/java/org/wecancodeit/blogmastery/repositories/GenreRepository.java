package org.wecancodeit.blogmastery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.blogmastery.models.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {

	Genre findByName(String string);

}
