package com.kobera.votingsystem;

import com.kobera.votingsystem.to.DishDto;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DishTestHelper {
    public static final int DISH1_ID = 100006;
    public static final DishDto DISH1 = new DishDto(DISH1_ID, "Dish1", LocalDate.now(), 135);
    public static final DishDto DISH2 = new DishDto(100007, "Dish2", LocalDate.now(), 139);
    public static final DishDto DISH3 = new DishDto(100008, "Dish3", LocalDate.of(2000, 01, 10), 249);

    public static final DishDto DISH4 = new DishDto(100009, "Dish4", LocalDate.now(), 150);
    public static final DishDto DISH5 = new DishDto(100010, "Dish5", LocalDate.now(), 196);
    public static final DishDto DISH6 = new DishDto(100011, "Dish6", LocalDate.of(2000, 01,10), 330);

    public static final DishDto DISH7 = new DishDto(100012, "Dish7", LocalDate.now(), 194);
    public static final DishDto DISH8 = new DishDto(100013, "Dish8", LocalDate.now(), 109);
    public static final DishDto DISH9 = new DishDto(100014, "Dish9", LocalDate.of(2000, 01,10), 389);

    public static final List<DishDto> DISHES = List.of(DISH3, DISH2, DISH1);

    public static void assertMatch(DishDto actual, DishDto expected) {
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    public static void assertMatch(Iterable<DishDto> actual, DishDto... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<DishDto> actual, Iterable<DishDto> expected) {
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }
}
