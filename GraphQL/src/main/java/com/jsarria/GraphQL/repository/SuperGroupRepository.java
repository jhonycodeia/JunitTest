package com.jsarria.GraphQL.repository;

import com.jsarria.GraphQL.models.Orientation;
import com.jsarria.GraphQL.models.SuperGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class SuperGroupRepository {

    private List<SuperGroup> superGroupList =new ArrayList<>();

    public SuperGroupRepository() {
        seedGroups();
    }

    public void seedGroups() {
        SuperGroup s1 = SuperGroup.builder()
                .name("galacticos")
                .orientation(Orientation.VILLAIN)
                .build();

        SuperGroup s2 = SuperGroup.builder()
                .name("Necros")
                .orientation(Orientation.HERO)
                .build();
        superGroupList.addAll(List.of(s1, s2));
    }

    public List<SuperGroup> getGroups() {
        return superGroupList;
    }

    public SuperGroup getGroupByName(String name){
        return superGroupList.stream().filter(s->s.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    public SuperGroup addGroup(String name,Orientation orientation){
        SuperGroup s1 = SuperGroup.builder()
                .name(name)
                .orientation(orientation)
                .build();
        superGroupList.add(s1);

        return s1;
    }


}
