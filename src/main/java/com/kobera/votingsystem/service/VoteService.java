package com.kobera.votingsystem.service;

import com.kobera.votingsystem.model.Restaurant;
import com.kobera.votingsystem.model.User;
import com.kobera.votingsystem.model.Vote;
import com.kobera.votingsystem.repository.RestaurantRepository;
import com.kobera.votingsystem.repository.VoteRepository;
import com.kobera.votingsystem.util.exception.NotFoundException;
import com.kobera.votingsystem.util.exception.VotingTimeExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class VoteService {

    private static final LocalTime STOP = LocalTime.of(11, 0);

    private final VoteRepository repository;

    private final RestaurantRepository restaurantRepository;

    private final Clock clock;

    @Autowired
    public VoteService(VoteRepository repository, RestaurantRepository restaurantRepository, Clock clock) {
        this.repository = repository;
        this.restaurantRepository = restaurantRepository;
        this.clock = clock;
    }

    public Vote save(User user, int restaurantId) {
        LocalDate now = LocalDate.now(clock);
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(NotFoundException::new);

        Vote vote = repository.findByDateAndUserId(now, user.getId())
                .orElse(new Vote(null, LocalDate.now(clock), user, restaurant));

        if (!vote.isNew() && LocalTime.now(clock).isAfter(STOP)) {
            throw new VotingTimeExpiredException();
        } else {
            vote.setRestaurant(restaurant);
        }

        return repository.save(vote);
    }

    public Vote get(User user) {
        return repository.findByDateAndUserId(LocalDate.now(clock), user.getId()).orElseThrow(NotFoundException::new);
    }

    public List<Vote> findAllByRestaurantId(int restaurantId) {
        return repository.findAllByRestaurantIdOrderByDateDesc(restaurantId);
    }

    public List<Vote> findAllByDate(LocalDate date) {
        return repository.findAllByDateOrderByRestaurantIdAsc(date);
    }
}
