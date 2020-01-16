package com.kobera.votingsystem;

import com.kobera.votingsystem.to.VoteDto;

import java.time.LocalDate;
import java.util.List;

import static com.kobera.votingsystem.RestaurantTestHelper.RESTAURANT1_ID;
import static com.kobera.votingsystem.UserTestHelper.USER1_ID;
import static com.kobera.votingsystem.UserTestHelper.USER2_ID;
import static org.assertj.core.api.Assertions.assertThat;

public class VoteTestData {

    public static final int VOTE1_ID = 100015;
    public static final VoteDto VOTE1 = new VoteDto(VOTE1_ID, LocalDate.now(), USER1_ID, RESTAURANT1_ID);
    public static final VoteDto VOTE2 = new VoteDto(100016, LocalDate.of(2000, 01, 10), USER2_ID, 100004);

    public static final List<VoteDto> VOTES = List.of(VOTE2, VOTE1);

    public static void assertMatch(VoteDto actual, VoteDto expected) {
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    public static void assertMatch(Iterable<VoteDto> actual, VoteDto... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<VoteDto> actual, Iterable<VoteDto> expected) {
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }
}
