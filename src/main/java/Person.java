import jdk.jshell.spi.SPIResolutionException;

import java.util.OptionalInt;

public class Person {
    protected final String firstName;
    protected final String lastName;
    protected OptionalInt age;
    protected boolean hasAge = false;
    protected String address;
    protected boolean hasAddress = false;

    public Person(PersonBuilder personBuilder) {
        this.firstName = personBuilder.firstName;
        this.lastName = personBuilder.lastName;
        if (personBuilder.hasAge) {
            this.age = personBuilder.age;
            this.hasAge = true;
        }
        if (personBuilder.hasAddress) {
            this.address = personBuilder.address;
            this.hasAddress = true;
        }
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void happyBurthday() {
        if (hasAge) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    public boolean hasAge() {
        return hasAge;
    }

    public boolean hasAddress() {
        return hasAddress;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setLastName(this.lastName).setAddress(this.address);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + (hasAddress ? address : "") + " "
                + (hasAge ? age.getAsInt() : "");
    }
}
