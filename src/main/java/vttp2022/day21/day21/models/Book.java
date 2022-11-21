package vttp2022.day21.day21.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Book {
    
    private String book_id;
    private String title;
    private String description;
    private float  rating;
    private String url;

    public String getBook_id() {
        return book_id;
    }
    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public static Book create(SqlRowSet rs) {
        Book b = new Book();

        b.setBook_id(rs.getString("book_id"));
        b.setDescription(rs.getString("description"));
        b.setRating(rs.getFloat("rating"));
        b.setTitle(rs.getString("title"));
        b.setUrl(rs.getString("image_url"));

        return b;
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
            .add("bookid", getBook_id())
            .add("title", getTitle())
            .add("description", getDescription())
            .add("url", getUrl())
            .add("rating", getRating())
            .build();
    }
}
