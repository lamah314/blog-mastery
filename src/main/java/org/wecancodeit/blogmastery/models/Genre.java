package org.wecancodeit.blogmastery.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy= "genre")
	private Collection<Post> posts = new ArrayList<Post>();

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Post> getPosts() {
		return posts;
	}

	public Genre() {}
	
	public Genre(String name) {
		this.name = name;
	}
	
	public Genre(String name, Collection<Post> posts) {
		this.name = name;
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + ", posts=" + posts + "]";
	}
	
}
