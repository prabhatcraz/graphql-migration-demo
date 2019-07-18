package com.prabhat.ing.demo.graphql;

import com.example.demo.graphql.BeerGraphQLService;
import com.example.demo.graphql.GraphQLEndPoint;
import com.example.demo.service.BeerService;
import org.junit.Test;

public class GraphQLEndPointTest {
    @Test
    public void testSchemaGeneration() {
        BeerService beerService = new BeerService();
        BeerGraphQLService beerGraphQLService = new BeerGraphQLService(beerService);
        GraphQLEndPoint endPoint = new GraphQLEndPoint(beerGraphQLService);

        endPoint.createGraphQLObject(); // running the postconstruct

        System.out.println(endPoint.getSchema());
    }
}