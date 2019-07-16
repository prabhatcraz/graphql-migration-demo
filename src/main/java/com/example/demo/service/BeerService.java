package com.example.demo.service;

import com.example.demo.Beer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BeerService {
    private final AtomicInteger nextId = new AtomicInteger(1);
    private Map<String, Beer> beers = new HashMap<>();

    public Beer create(final Beer beer) {

        // BAD PRACTICE : ONLY FOR DEMO !!
        final String id = String.valueOf(nextId.getAndIncrement());

        // Add the beer to beer collection
        final Beer beerToCreate = beer.toBuilder()
            .id(id)
            .build();
        beers.put(id, beerToCreate);

        return beerToCreate;
    }

    public List<Beer> getAll() {
        return new ArrayList<>(beers.values());
    }

    public Beer getABeer(final String id) {
        return beers.get(id);
    }

    public String delete(final String id) {
        this.beers.remove(id);
        return id;
    }

    public Beer update(String id, final Beer beer) {
        beers.put(id, beer.toBuilder()
            .id(id)
            .build());

        return beers.get(id);
    }
}
