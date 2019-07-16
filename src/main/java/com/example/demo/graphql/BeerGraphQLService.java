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



    @GraphQLQuery(name = "getAll")
    public List<Beer> getAll() {
        return beerService.getAll();
    }

    @GraphQLQuery(name = "get")
    public Beer getABeer(@GraphQLArgument(name = "id") final String id) {
        return beerService.getABeer(id);
    }

    @GraphQLMutation(name = "create")
    public Beer create(final Beer beer) {
        return beerService.create(beer);
    }

    @GraphQLMutation(name = "delete")
    public String delete(final String id) {
        return beerService.delete(id);
    }

    @GraphQLMutation(name = "update")
    public Beer update(final String id, final Beer beer) {
        return beerService.update(id, beer);
    }
}
