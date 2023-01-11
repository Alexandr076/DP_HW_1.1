public class PersonBuilder {
    protected String firstName;
    protected String lastName;
    protected int age;
    private boolean hasAge = false;
    protected String address;

    public PersonBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder setLastName (String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder setAge (int age) {
        if (age<=0) {
            throw new IllegalStateException("Current age is invalid");
        }
        this.age = age;
        this.hasAge = true;
        return this;
    }

    public PersonBuilder setAddress (String address) {
        this.address = address;
        return this;
    }

    Person build() {
        return new Person(this);
    }
}
