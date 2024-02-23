package ru.veb.web.model;

import java.util.List;
import java.util.UUID;

public class Msg {

    List<String> randomStrings;
    UUID uuid;
    String title;

    public static Msg  create(List<String> randomStrings, UUID uuid, String title){
        if (randomStrings==null||uuid==null||title==null) return null;
        return new Msg(randomStrings, uuid, title);
    }

    private  Msg(List<String> randomStrings, UUID uuid, String title) {
        this.randomStrings = randomStrings;
        this.uuid = uuid;
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(uuid.toString())
                .append(" | ")
                .append("(")
                .append(title)
                .append(")")
                .append(" | [");

        for (String str:randomStrings) {

            stringBuilder
                    .append("\"")
                    .append(str)
                    .append("\";");
        }
        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length())
                .append("]");



        return stringBuilder.toString();
    }
}
