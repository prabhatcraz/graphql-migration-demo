package com.example.demo;

import com.example.demo.service.BeerService;
import io.leangen.graphql.annotations.GraphQLQuery;
import javafx.scene.chart.ValueAxis;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class BeerEndPoint {
    private final BeerService beerService;

    @Deprecated
    @GetMapping("/beers")
    public ResponseEntity<List<Beer>> getBeers() {
        return ResponseEntity.ok(beerService.getAll());
    }

    @GetMapping("/beer/{id}")
    public ResponseEntity<Beer> get(@PathVariable final String id) {
        return ResponseEntity.ok(beerService.getABeer(id));
    }

    @PostMapping(value = "/beer", consumes = {"application/json"})
    public ResponseEntity<Beer> create(@RequestBody final Beer beer) {
        return ResponseEntity.ok(beerService.create(beer));
    }

    @DeleteMapping(value = "/beer/{id}")
    public ResponseEntity<String> delete(@PathVariable final String id) {
        return ResponseEntity.ok(beerService.delete(id));
    }

    @PutMapping(value = "/beer/{id}")
    public ResponseEntity<Beer> update(@RequestBody final Beer beer, @PathVariable final String id) {
        return ResponseEntity.ok(beerService.update(id, beer));
    }

}
