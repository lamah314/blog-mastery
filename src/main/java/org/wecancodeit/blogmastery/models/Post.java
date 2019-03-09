package org.wecancodeit.blogmastery.models;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;

	private String title;
	
	private String body;
	
	@ManyToMany(mappedBy= "posts")
	private Collection<Author> authors;
	
	private LocalDateTime date;
	
	@ManyToOne
	private Genre genre;
	
	@ManyToMany(mappedBy= "posts")
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
	
	public Post(String title, String body, Collection<Author> authors, Genre genre,
			Collection<Tag> tags) {
		this.title = title;
		this.body = body;
		this.authors = authors;
		this.date = LocalDateTime.now();
		this.genre = genre;
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", authors=" + authors + ", date=" + date
				+ ", genre=" + genre + ", tags=" + tags + "]";
	}
	
	
	
	
	
}
