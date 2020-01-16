package com.kobera.votingsystem;

import com.kobera.votingsystem.to.RestaurantDto;
import com.kobera.votingsystem.to.RestaurantWithDishesDto;

import java.util.List;

import static com.kobera.votingsystem.DishTestHelper.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantTestHelper {


    public static final int RESTAURANT1_ID = 100003;
    public static final RestaurantDto RESTAURANT1 = new RestaurantDto(RESTAURANT1_ID, "Restaurant1");
    public static final RestaurantDto RESTAURANT2 = new RestaurantDto(100004, "Restaurant2");
    public static final RestaurantDto RESTAURANT3 = new RestaurantDto(100005, "Restaurant3");

    public static final List<RestaurantDto> RESTAURANTS = List.of(RESTAURANT3, RESTAURANT2, RESTAURANT1);

    public static final RestaurantWithDishesDto RESTAURANT1_MENU = new RestaurantWithDishesDto(RESTAURANT1_ID, "Restaurant1", List.of(DISH2, DISH1));
    public static final RestaurantWithDishesDto RESTAURANT2_MENU = new RestaurantWithDishesDto(100004, "Restaurant2", List.of(DISH7, DISH8));
    public static final RestaurantWithDishesDto RESTAURANT3_MENU = new RestaurantWithDishesDto(100005, "Restaurant3", List.of(DISH5, DISH4));

    public static final List<RestaurantDto> RESTAURANTS_MENU = List.of(RESTAURANT3_MENU, RESTAURANT2_MENU, RESTAURANT1_MENU);

    public static void assertMatch(RestaurantDto actual, RestaurantDto expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "dishes");
    }

    public static void assertMatch(Iterable<RestaurantDto> actual, RestaurantDto... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<RestaurantDto> actual, Iterable<RestaurantDto> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("dishes").isEqualTo(expected);
    }
}
