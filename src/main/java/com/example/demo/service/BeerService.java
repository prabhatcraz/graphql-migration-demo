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
    private final AtomicInteger nextId = new AtomicInteger();
    private Map<String, Beer> beers = new HashMap<>();

    public String create(final Beer beer) {

        // BAD PRACTICE : ONLY FOR DEMO !!
        final String id = String.valueOf(nextId.getAndIncrement());

        // Add the beer to beer collection
        beers.put(id, beer.toBuilder()
                .id(id)
                .build());

        return id;
    }

    public List<Beer> getAll() {
        return new ArrayList<>(beers.values());
    }

    public Beer getABeer(final String id) {
        return beers.get(id);
    }
}
