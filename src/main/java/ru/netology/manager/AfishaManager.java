package ru.netology.manager;


import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private int numberLastFilms;
    private AfishaRepository repository = new AfishaRepository();// вместо следующей строки
    // иначе NullPointerExeption

    //    private BillboardRepository repository;
//
    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager() {
        this.numberLastFilms = 10;
    }

    public AfishaManager(int numberLastFilms) {
        this.numberLastFilms = numberLastFilms;
    }


//    public Movie[] returnMovieByid(String id) {
//
//        Movie[] film = repository.findById(id);
//        return film;
//    }

    public void addFilm(Movie film) {
        repository.save(film);

    }

    public Movie[] getLast() {
        Movie[] films = repository.findAll();

        int resultLength = numberLastFilms;
        if (resultLength > films.length) {
            resultLength = films.length;
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}