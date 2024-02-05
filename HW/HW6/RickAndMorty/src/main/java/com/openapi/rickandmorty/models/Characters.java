package com.openapi.rickandmorty.models;

import lombok.Data;

import java.util.List;

@Data
public class Characters
{
    Info info;
    private List<Character> characters;
}
