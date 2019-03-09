package org.wecancodeit.blogmastery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.blogmastery.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

	Tag findByName(String string);

}
