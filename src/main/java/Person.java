import jdk.jshell.spi.SPIResolutionException;

public class Person {
    protected final String firstName;
    protected final String lastName;
    protected int age;
    protected boolean hasAge = false;
    protected String address;
    protected boolean hasAddress = false;

/*    public Person (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person (String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hasAge = true;
    }*/

    public Person (PersonBuilder personBuilder) {
        if (personBuilder.firstName == null || personBuilder.lastName == null) {
            throw new IllegalStateException("Fields firstName and lastName are required");
        }
        this.firstName = personBuilder.firstName;
        this.lastName = personBuilder.lastName;
        if (personBuilder.age != 0) {
            this.age = personBuilder.age;
            this.hasAge = true;
        }
        if (personBuilder.address != null && !personBuilder.address.equals("")) {
            this.address = personBuilder.address;
            this.hasAddress = true;
        }
    }

    public int getAge() {
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
            age++;
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
        return lastName + " " + firstName + " " + (hasAddress?address:"") + " "
                + (hasAge?age:"");
    }
}
