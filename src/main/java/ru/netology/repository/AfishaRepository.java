package ru.netology.repository;

import ru.netology.domain.Movie;

public class AfishaRepository {
    private Movie[] films = new Movie[0];

    public Movie[] findAllR() {
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


    public void removeById(String id) {
        int length = films.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie film : films) {
            if (!film.getId().equals(id)) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        Movie[] tmp = new Movie[0];
        films = tmp;
    }

    public Movie[] findById(String id) {

        for (Movie film : films) {
            if (film.getId().equals(id)) {
                return new Movie[]{film};
            }
        }
        return null;
    }
}
