package org.wecancodeit.blogmastery.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy="tags")
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

	public Tag() {}
	
	public Tag(String name) {
		this.name = name;
	}
	
	public Tag(String name, Collection<Post> posts) {
		this.name = name;
		this.posts = posts;
	}
	
	public void addPostToTag(Post post) {
		posts.add(post);
	}
	
	public boolean checkPostsInTag(Post post) {
		return posts.contains(post);
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", posts=" + posts + "]";
	}

}
