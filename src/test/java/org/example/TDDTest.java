package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create a function find in a TDD class that receives a list and a number and returns the index or -1 if not found
 */
@ExtendWith(MockitoExtension.class)
public class TDDTest {

    @Test
    public void instantiateClass() {
        TDD variable = new TDD();
    }

    @Test
    public void callMethod() {
        TDD variable = new TDD();
        variable.find(new ArrayList<>(), 2);
    }

    @Test
    public void methodReturnsAnInt() {
        TDD tdd = new TDD();
        int index = tdd.find(new ArrayList<>(), 2);
    }

    @Test
    public void returnMinusOneIfNotFound() {
        // GIVEN
        TDD tdd = new TDD();
        List<Integer> list = new ArrayList<>();
        int number = 2;

        // WHEN
        int index = tdd.find(list, number);

        // THEN
        Assertions.assertThat(index).isEqualTo(-1);
    }

    @Test
    public void returnIndexIfFound() {
        // GIVEN
        TDD tdd = new TDD();
        List<Integer> list = Arrays.asList(1, 3, 6);
        int number = 3;

        // WHEN
        int index = tdd.find(list, number);

        // THEN
        Assertions.assertThat(index).isEqualTo(1);
    }

    @Test
    public void returnMinusOneIfListIsNull() {
        // GIVEN
        TDD tdd = new TDD();
        List<Integer> list = null;
        int number = 2;

        // WHEN
        int index = tdd.find(list, number);

        // THEN
        Assertions.assertThat(index).isEqualTo(-1);
    }

    @Test
    public void findAllIndexes() {
        // GIVE
        TDD tdd = Mockito.mock(TDD.class);
        List<Integer> list = Arrays.asList(1, 3, 6);
        List<Integer> numbers = Arrays.asList(2, 3, 1);
        Mockito.when(tdd.findAll(list, numbers)).thenCallRealMethod();
        Mockito.when(tdd.find(list, 2)).thenReturn(-1);
        Mockito.when(tdd.find(list, 3)).thenReturn(1);
        Mockito.when(tdd.find(list, 1)).thenReturn(0);

        // WHEN
        List<Integer> result = tdd.findAll(list, numbers);

        // THEN
        Assertions.assertThat(result.get(0)).isEqualTo(-1); // because 2 is not in the list
        Assertions.assertThat(result.get(1)).isEqualTo(1); // because 3 is on index 1
        Assertions.assertThat(result.get(2)).isEqualTo(0); // because 1 is on index 0
    }
}
