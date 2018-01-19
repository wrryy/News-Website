package pl.wrryy.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    @NotNull
    @ManyToMany(mappedBy = "articles", fetch = FetchType.EAGER)
    private List<Category> category;

    @NotNull
    @Size(min = 500)
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;
    public String getDate() {
        return Arrays.toString(created.toString().split("T"));
    }
    public Article() {
        this.created = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public List<Category> getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
