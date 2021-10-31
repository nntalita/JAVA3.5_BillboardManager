package ru.netology.repository;

import ru.netology.domain.Movie;

public class AfishaRepository {
    private Movie[] films = new Movie[0];

    public Movie[] findAll() {
        return films;
    }

    public void save(Movie film) {
        int length = films.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;


    }

    //        findById - возвращает объект по идентификатору (либо null, если такого объекта нет)
//    public Movie[] findById(String id) {
//
//        for (Movie film : films) {
//            if (film.getId().equals(id)) {
////                return new Movie[]{film};
//                return films;
//            }
//
//
//        }
//        Movie[] movies = null;
//        return movies;
//    }

}