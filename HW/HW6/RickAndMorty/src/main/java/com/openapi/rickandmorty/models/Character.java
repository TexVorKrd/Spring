package com.openapi.rickandmorty.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Character {

    private Integer id; //The id of the character.
    private String name;//The name of the character.
    private	String status;//The status of the character ('Alive', 'Dead' or 'unknown').
    private	String species;//The species of the character.
    private	String type;//The type or subspecies of the character.
    private	String gender;//The gender of the character ('Female', 'Male', 'Genderless' or 'unknown').
    private	String image;//Link to the character's image. All images are 300x300px and most are medium shots or portraits since they are intended to be used as avatars.
    private	String url;//Link to the character's own URL endpoint
    private Date created;//Time at which the character was created in the database.
}
