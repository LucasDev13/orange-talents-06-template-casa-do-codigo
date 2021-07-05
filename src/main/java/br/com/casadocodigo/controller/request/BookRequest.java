package br.com.casadocodigo.controller.request;

import br.com.casadocodigo.config.validation.UniqueValue;
import br.com.casadocodigo.config.validation.ValueIdExists;
import br.com.casadocodigo.model.Author;
import br.com.casadocodigo.model.Book;
import br.com.casadocodigo.model.Category;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookRequest {

    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "title")
    private String title;

    @Size(max=500)
    @NotBlank
    private String bookSummary;
    private String summary;

    @DecimalMin("20.00")
    private BigDecimal price;

    @Min(value = 100)
    private int numberPages;

    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "isbn")
    private String isbn;
    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicationDate;

    @NotNull
    @ValueIdExists(domainClass = Category.class, fieldName = "id")
    private Long idCategory;

    @NotNull
    @ValueIdExists(domainClass = Author.class, fieldName = "id")
    private Long idAuthor;

    public BookRequest(String title, String bookSummary, String summary,
                       BigDecimal price, int numberPages, String isbn,
                       LocalDate publicationDate, Long idCategory,
                       Long idAuthor) {
        this.title = title;
        this.bookSummary = bookSummary;
        this.summary = summary;
        this.price = price;
        this.numberPages = numberPages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.idCategory = idCategory;
        this.idAuthor = idAuthor;
    }

    public Book toModel(EntityManager entityManager) {
        @NotNull Author author = entityManager.find(Author.class, idAuthor);
        @NotNull Category category = entityManager.find(Category.class, idCategory);

        return new Book(this.title, this.bookSummary,
                this.summary, this.price, this.numberPages,
                this.isbn, this.publicationDate,author, category);
    }

    /**
     * Esse método foi criado para ajudar o jackson a desserializar a data.
     * @param publicationDate
     */
    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
}
