package org.example;

import java.util.ArrayList;
import java.util.List;

public class TDD {

    public int find(List<Integer> list, int number) {
        System.out.println("find " + number);
        if (list == null || !list.contains(number)) {
            return -1;
        }
        return list.indexOf(number);
    }

    /**
     * return list of indexes for each number
     *
     * @param list
     * @param numbers
     * @return
     */
    public List<Integer> findAll(List<Integer> list, List<Integer> numbers) {
        System.out.println("find all");
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            result.add(find(list, number));
        }
        return result;
    }
}
