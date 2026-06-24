package com.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Book name is required")
    private String bookName;

    @NotBlank(message = "Author is required")
    private String author;

    @Min(value = 1, message = "Price must be greater than 0")
    private double price;

    @Min(value = 0)
    private int quantity;

    @Column(unique = true)
    @NotBlank(message = "ISBN is required")
    private String isbn;

    private boolean available;

    private int copies;

    private String borrower;
}