package com.example.demo.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.SchemaPrinter;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
public class GraphQLEndPoint {
    private final BeerGraphQLService beerService;

    private GraphQL graphQL;
    private GraphQLSchema schema;

    @PostConstruct
    public void createGraphQLObject() {
        schema = new GraphQLSchemaGenerator()
                .withResolverBuilders(
                        new AnnotatedResolverBuilder()
                ).withOperationsFromSingleton(beerService, BeerGraphQLService.class)
                .withValueMapperFactory(new JacksonValueMapperFactory())
                .generate();
        graphQL = new GraphQL.Builder(schema)
                .build();
    }


    @PostMapping(value = "/data")
    public ResponseEntity<Object> data(@RequestBody final String query) {
        return new ResponseEntity<>(graphQL.execute(query), HttpStatus.OK);
    }

    @GetMapping("/internal/schema")
    public String getSchema() {
        return new SchemaPrinter().print(schema);
    }
}
