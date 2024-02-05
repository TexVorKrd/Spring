package com.openapi.rickandmorty.services;

import com.openapi.rickandmorty.models.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RMServiceImlp implements RMService {

    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    @Value("${data.parameter.api.rickamdmorty}")
    private  String characterApi; // = "https://rickandmortyapi.com/api"; // "/character"
    @Override
    public Characters getPageofCharacters(Long pageNumber) {
         String request = new StringBuilder()
                 .append(characterApi)
                 .append("/character")
                 .append("/?page=")
                 .append(pageNumber)
                 .toString();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(request, HttpMethod.GET,entity, Characters.class);
        return responce.getBody();
    }
}
