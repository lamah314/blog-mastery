package org.wecancodeit.blogmastery.models;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;

	private String title;
	
	private String body;
	
	@ManyToMany
	@JoinTable(name = "post_author",
	joinColumns = { @JoinColumn(name = "post") },
	inverseJoinColumns = { @JoinColumn(name = "author") })
	private Collection<Author> authors;
	
	private LocalDateTime date;
	
	@ManyToOne
	private Genre genre;
	
	@ManyToMany
//	@JoinTable(name = "post_tag",
//	joinColumns = { @JoinColumn(name = "post") },
//	inverseJoinColumns = { @JoinColumn(name = "tag") })
	private Collection<Tag> tags;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public Collection<Author> getAuthors() {
		return authors;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public Genre getGenre() {
		return genre;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public Post() {}
	
	public Post(String title, String body, Author author, Genre genre,
			Tag tag) {
		this.title = title;
		this.body = body;
		this.authors = Arrays.asList(author);
		this.date = LocalDateTime.now();
		this.genre = genre;
		this.tags = Arrays.asList(tag);
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", authors=" + authors + ", date=" + date
				+ ", genre=" + genre + ", tags=" + tags + "]";
	}
	
	
	
	
	
}
