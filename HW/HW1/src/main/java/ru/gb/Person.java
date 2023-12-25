package ru.gb;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.lang.reflect.Field;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Реализован hashCode с помощью org.apache.commons.lang3.builder.hashCodeBuilder.
     * И механизма рефлексии.
     *
     * @return
     */
    @Override
    public int hashCode() {

        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(17, 37);

        Field[] fields = this.getClass().getDeclaredFields();

        for (Field fl : fields) {
            try {
                hashCodeBuilder.append(fl.get(this));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return hashCodeBuilder.toHashCode();
    }

    /**
     * Реализован equals с помощью org.apache.commons.lang3.builder.EqualsBuilder.
     * И механизма рефлексии.
     *
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }

        Person rhs = (Person) obj;

        EqualsBuilder equalsBuilder = new EqualsBuilder();

        Field[] fields = this.getClass().getDeclaredFields();

        for (Field fl : fields) {
            fl.setAccessible(true);
            try {
                equalsBuilder.append(fl.get(this), fl.get(rhs));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return equalsBuilder.isEquals();
    }

    /**
     * Реализован toString с помощью org.apache.commons.lang3.builder.ToStringBuilder.
     * И механизма рефлексии.
     *
     * @return
     */
    @Override
    public String toString() {

        ToStringBuilder msg = new ToStringBuilder(this);
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field fl : fields) {
            fl.setAccessible(true);
            try {
                msg.append(fl.getName(), fl.get(this));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return msg.toString();
    }

    /**
     * Сериализация с помощью Gson. Без обработки.
     *
     * @return - JSON String
     */
    public static String toJson(Person person) {
        return new Gson().toJson(person);
    }

    /**
     * Десериализация с помощью Gson. Без обработки.
     *
     * @param strJson -JSON String
     * @return - Persone
     */
    public static Person fromJson(String strJson) {
        return new Gson().fromJson(strJson, Person.class);
    }
}
