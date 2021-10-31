package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.manager.AfishaManager;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfishaTest {

    AfishaManager manager = new AfishaManager();
    private Movie first = new Movie("фильм1", "картинка1", "Бладшот", "боевик");
    private Movie second = new Movie("фильм2", "картинка2", "Вперед", "мультфильм");
    private Movie third = new Movie("фильм3", "картинка3", "Отель  Пелград", "комедия");
    private Movie fourth = new Movie("фильм4", "картинка4", "Джентльмены", "боевик");
    private Movie fifth = new Movie("фильм5", "картинка5", "Отель Белград", "комедия");
    private Movie sixth = new Movie("фильм6", "картинка6", "Семейка Аддамс", "мультфильм");
    private Movie seventh = new Movie("фильм7", "картинка7", "Человек-невидимка", "ужасы");
    private Movie eighth = new Movie("фильм8", "картинка8", "Возращение", "драма");
    private Movie ninth = new Movie("фильм9", "картинка9", "Веном", "фантастика");
    private Movie tenth = new Movie("фильм10", "картинка10", "Кот-в-сапогах", "мульфильм");
    private Movie eleventh = new Movie("фильм11", "картинка11", "Дюна", "фантастика");
    private Movie twelfth = new Movie("фильм12", "картинка12", "Изчезнувший", "триллер");


    @Test
    public void shouldRemoveById() {
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        manager.addFilm(twelfth);
        manager.removeById("фильм6");
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{twelfth, eleventh, tenth, ninth, eighth, seventh, fifth, fourth, third, second};
        assertArrayEquals(actual, expected);
    }


    @Test
    public void shouldRemoveAll() {
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        manager.addFilm(twelfth);
        manager.removeAll();
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[0];
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldReturnMovieById() {

        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        manager.addFilm(twelfth);

        Movie[] expected = manager.findById("фильм12");
        Movie[] actual = new Movie[]{twelfth};
        assertArrayEquals(actual, expected);

    }


    @Test
    public void shouldAddFilmsMoreThan10() {

        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        manager.addFilm(twelfth);
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldAddFilmsLessThan10() {

        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        manager.addFilm(twelfth);
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{twelfth, eleventh, tenth, ninth, eighth};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldAddFilmsOne() {

        manager.addFilm(eighth);

        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{eighth};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldAddFilmsNull() {

        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[0];

        assertArrayEquals(actual, expected);
    }
}