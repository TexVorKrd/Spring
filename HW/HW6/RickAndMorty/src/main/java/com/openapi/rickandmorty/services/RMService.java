package com.openapi.rickandmorty.services;

import com.openapi.rickandmorty.models.Characters;

public interface RMService {
    Characters getPageofCharacters(Long pageNumber);
}
