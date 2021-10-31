package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.manager.AfishaManager;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

//@ExtendWith(MockitoExtension.class)
class AfishaMockTest {
//    @Mock
    private AfishaRepository repository = Mockito.mock(AfishaRepository.class);
    private AfishaManager manager = new AfishaManager(repository);
//    @InjectMocks


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
    public void shouldGetLast() {
        manager.addFilm(first);
        manager.addFilm(second);

        Movie[] returned = new Movie[]{first,second};
        doReturn(returned).when(repository).findAllR();
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{second,first};

        assertArrayEquals(actual, expected);
    }

}