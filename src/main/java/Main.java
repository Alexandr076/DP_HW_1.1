import org.w3c.dom.ls.LSOutput;

import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        Person person0 = new PersonBuilder()
                .setFirstName("Владимир")
                .setLastName("Вай")
                .setAddress("Углич")
                .build();

        System.out.println(person0.toString());

        Person person1 = new PersonBuilder()
                .setFirstName("Имя")
                .setLastName("Фамилия")
                .setAge(23)
                .setAddress("Москва")
                .build();

        System.out.println(person1.toString());

        Person person2 = new PersonBuilder()
                .setFirstName("Name person2")
                .setLastName("Surname person2")
                .setAddress("Street")
                .build();

        System.out.println(person2.toString());

        Person childsPerson2 = person2.newChildBuilder()
                .setFirstName("Child`s firstName")
                .build();

        System.out.println(childsPerson2.toString());




        try {
            Person person = new PersonBuilder()
                    .setFirstName("Оля")
                    .setAge(13)
                    .build();
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
