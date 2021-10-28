package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
@AllArgsConstructor

public class Movie {
    private String id;
    private String imageUrl;
    private String name;
    private String genre;
}