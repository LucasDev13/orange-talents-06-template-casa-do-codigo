package br.com.casadocodigo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    private Category category;

    @NotNull
    @Valid
    @ManyToOne
    private Author author;

    @Deprecated
    public Book() {
    }

    public Book(String title, String bookSummary,
                String summary, BigDecimal price,
                Integer numberPages, String isbn,
                LocalDate publicationDate, Author author,
                Category category
                ) {
        this.title = title;
        this.bookSummary = bookSummary;
        this.summary = summary;
        this.price = price;
        this.numberPages = numberPages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.category = category;
        this.author = author;
    }
}
