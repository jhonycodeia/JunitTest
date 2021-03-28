package com.jsarria.GraphQL.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.jsarria.GraphQL.models.Orientation;
import com.jsarria.GraphQL.models.SuperCharacter;
import com.jsarria.GraphQL.models.SuperGroup;
import com.jsarria.GraphQL.repository.SuperCharacterRepository;
import com.jsarria.GraphQL.repository.SuperGroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private SuperCharacterRepository superCharacterRepository;

    @Autowired
    private SuperGroupRepository superGroupRepository;

    public SuperCharacter addCharacter(String name,Integer age){
        return superCharacterRepository.addCharacter(name,age);
    }

    public SuperCharacter addCharacterGroup(String name,Integer age,String group){
        return superCharacterRepository.addCharacter(name,age,group);
    }

    public SuperGroup addGroup(String name, Orientation orientation){
        return superGroupRepository.addGroup(name, orientation);
    }
}
