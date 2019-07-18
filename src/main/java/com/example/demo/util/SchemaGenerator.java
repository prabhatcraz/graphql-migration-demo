package com.example.demo.util;

import com.example.demo.graphql.BeerGraphQLService;
import com.example.demo.graphql.GraphQLEndPoint;
import com.example.demo.service.BeerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SchemaGenerator {
    public static void main(String[] args) throws IOException {
        BeerService beerService = new BeerService();
        BeerGraphQLService beerGraphQLService = new BeerGraphQLService(beerService);
        GraphQLEndPoint endPoint = new GraphQLEndPoint(beerGraphQLService);

        endPoint.createGraphQLObject(); // running the postconstruct

        Path path = Paths.get("/Users/vb05mj/Desktop/schema.graphql");
        Files.write(path, endPoint.getSchema().getBytes());
    }
}
