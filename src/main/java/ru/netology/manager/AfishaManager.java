package ru.netology.manager;


import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private int numberLastFilms;
    private AfishaRepository repository = new AfishaRepository();// вместо следующей строки
    //    private AfishaRepository repository;
    // (иначе NullPointerException)


    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager() {
        this.numberLastFilms = 10;
    }

    public AfishaManager(int numberLastFilms) {
        this.numberLastFilms = numberLastFilms;
    }


    public void addFilm(Movie film) {
        repository.save(film);
    }

    public Movie[] getLast() {
        Movie[] films = repository.findAllR();

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

    public void removeById(String id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public Movie[] findById (String id){
        Movie[] film;
        film = repository.findById(id);
        return film;
    }
}