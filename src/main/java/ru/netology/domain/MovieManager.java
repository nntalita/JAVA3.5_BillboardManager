package ru.netology.domain;


public class MovieManager {
    private int numberLastFilms;

    public MovieManager() {
        this.numberLastFilms = 10;
    }

    public MovieManager(int numberLastFilms) {
        this.numberLastFilms = numberLastFilms;
    }


    private Movie[] films = new Movie[0];


    public void addFilm(Movie film) {
        int length = films.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Movie[] get10Last() {

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