package br.com.casadocodigo.controller.response;

import br.com.casadocodigo.config.validation.UniqueValue;
import br.com.casadocodigo.model.Author;
import br.com.casadocodigo.model.Book;
import br.com.casadocodigo.model.Category;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookResponseDetail {

    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Size(max=500)
    @NotBlank
    private String bookSummary;
    private String summary;

    @Column(nullable = false)
    @DecimalMin("20.00")
    private BigDecimal price;

    @Column(nullable = false)
    @Min(value = 100)
    private int numberPages;

    @Column(nullable = false)
    @NotBlank
    private String isbn;
    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicationDate;

    @NotNull
    @Valid
    private Category category;

    @NotNull
    @Valid
    private Author author;

    public BookResponseDetail(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
        this.bookSummary = book.getBookSummary();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.numberPages = book.getNumberPages();
        this.isbn = book.getIsbn();
        this.publicationDate = book.getPublicationDate();
        this.category = book.getCategory();
        this.author = book.getAuthor();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBookSummary() {
        return bookSummary;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }


}
