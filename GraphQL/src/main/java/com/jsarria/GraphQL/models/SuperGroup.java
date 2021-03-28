package com.jsarria.GraphQL.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuperGroup {

    private String name;
    private Orientation orientation;
    private List<SuperCharacter> members;

    public void addMember(SuperCharacter character) {
        if (members == null) {
            members = new ArrayList<>();
        }
        if (character != null) {
            members.add(character);
        }
    }

    public void removeMember(SuperCharacter character) {
        members.removeIf(c->c.getName().equalsIgnoreCase(character.getName()));
    }
}
