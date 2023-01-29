import java.util.OptionalInt;

public class PersonBuilder {
    protected String firstName;
    protected String lastName;
    protected OptionalInt age;
    protected boolean hasAge = false;
    protected String address;
    protected boolean hasAddress = false;

    public PersonBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Current age is invalid");
        }
        this.age = OptionalInt.of(age);
        this.hasAge = true;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        this.hasAddress = true;
        return this;
    }

    Person build() {
        if (firstName != null && lastName != null) {
            return new Person(this);
        } else {
            throw new IllegalStateException("First or last name was missed");
        }
    }
}
