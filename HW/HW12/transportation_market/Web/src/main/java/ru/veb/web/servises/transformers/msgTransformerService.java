package ru.veb.web.servises.transformers;

import org.springframework.integration.core.GenericTransformer;
import ru.veb.web.model.Msg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class msgTransformerService implements GenericTransformer {
    @Override
    public Object transform(Object source) {

        Random random= new Random();
        List<String> msges = new ArrayList<>();
        for (int i = 0; i <random.nextInt(10) ; i++) {
            msges.add(Integer.toString(i));
        }

        return Msg.create(msges,UUID.randomUUID(),new String((String)source).toUpperCase()).toString();

    }
}
