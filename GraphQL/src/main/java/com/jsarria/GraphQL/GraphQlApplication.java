package com.jsarria.GraphQL;

import com.jsarria.GraphQL.resolvers.Mutation;
import com.jsarria.GraphQL.resolvers.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphQlApplication {

    @Bean
    public Query query(){
        return new Query();
    }

    @Bean
    public Mutation mutation(){
        return new Mutation();
    }

    public static void main(String[] args) {
        SpringApplication.run(GraphQlApplication.class, args);


    }

}
