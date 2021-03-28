package com.jsarria.GraphQL.repository;

import com.jsarria.GraphQL.models.SuperCharacter;
import com.jsarria.GraphQL.models.SuperGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class SuperCharacterRepository {

    @Autowired
    private SuperGroupRepository superGroupRepository;

    private List<SuperCharacter> theCharacterList = new ArrayList<>();

    public SuperCharacterRepository() {
        this.seedCharacterList();
    }

    public void seedCharacterList() {
        SuperCharacter c1 = SuperCharacter.builder()
                .id("1")
                .name("character 1")
                .age(55)
                .build();

        SuperCharacter c2 = SuperCharacter.builder()
                .id("2")
                .name("character 2")
                .age(24)
                .build();

        this.theCharacterList.addAll(List.of(c1, c2));
    }

    public List<SuperCharacter> getTheCharacterList() {
        return theCharacterList;
    }

    public SuperCharacter getCharacterById(String id) {
        return theCharacterList.stream().filter(c -> c.getId().equals(id)).findFirst().get();
    }


    public SuperCharacter addCharacter(String name, Integer age) {
        SuperCharacter aux = SuperCharacter.builder()
                .id("Char" + (this.theCharacterList.size() + 1))
                .name(name)
                .age(age)
                .build();

        log.info("mutacion.addCharacter name(" + name + ")");
        this.theCharacterList.add(aux);
        return aux;
    }

    public SuperCharacter addCharacter(String name, Integer age,String group) {
        SuperGroup g = null;
        if(group!=null){
            g = superGroupRepository.getGroupByName(group);
        }
        SuperCharacter aux = SuperCharacter.builder()
                .id("Char" + (this.theCharacterList.size() + 1))
                .name(name)
                .age(age)
                .group(g)
                .build();

        log.info("mutacion.addCharacter name(" + name + ")");
        this.theCharacterList.add(aux);
        if(g!=null){
            g.addMember(aux);
        }

        return aux;
    }
}
