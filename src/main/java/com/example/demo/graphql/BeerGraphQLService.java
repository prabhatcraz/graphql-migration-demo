package com.example.demo.graphql;

import com.example.demo.Beer;
import com.example.demo.service.BeerService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BeerGraphQLService {
    private final BeerService beerService;

    @GraphQLMutation(name = "create")
    public String create(final Beer beer) {
        return beerService.create(beer);
    }

    @GraphQLQuery(name = "getAll")
    public List<Beer> getAll() {
        return beerService.getAll();
    }

    @GraphQLQuery(name = "get")
    public Beer getABeer(@GraphQLArgument(name = "id") final String id) {
        return beerService.getABeer(id);
    }
}
