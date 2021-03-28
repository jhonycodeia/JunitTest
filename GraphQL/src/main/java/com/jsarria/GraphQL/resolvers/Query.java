package com.jsarria.GraphQL.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jsarria.GraphQL.models.SuperCharacter;
import com.jsarria.GraphQL.models.SuperGroup;
import com.jsarria.GraphQL.repository.SuperCharacterRepository;
import com.jsarria.GraphQL.repository.SuperGroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class Query implements GraphQLQueryResolver {

    @Autowired
    private SuperCharacterRepository superCharacterRepository;

    @Autowired
    private SuperGroupRepository superGroupRepository;

    public List<SuperCharacter> characters() {
        return superCharacterRepository.getTheCharacterList();
    }

    public SuperCharacter characterById(String id) {
        return superCharacterRepository.getCharacterById(id);
    }

    public List<SuperGroup> groups() {
        return superGroupRepository.getGroups();
    }

    public SuperGroup groupByName(String name){
        return superGroupRepository.getGroupByName(name);
    }



}
