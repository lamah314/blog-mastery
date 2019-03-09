package org.wecancodeit.blogmastery.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy="authors")
	private Collection<Post> posts;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Post> getPosts() {
		return posts;
	}

	public Author() {}
	
	public Author(String name) {
		this.name = name;
	}
	
	public Author(String name, Post ...posts) {
		this.name = name;
		this.posts = Arrays.asList(posts);
	}
	
	public void addPosttoAuthor(Post post) {
		posts.add(post);
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", posts=" + posts + "]";
	}
	
}
