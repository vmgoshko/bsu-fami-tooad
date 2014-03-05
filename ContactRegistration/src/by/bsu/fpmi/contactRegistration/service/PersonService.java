package by.bsu.fpmi.contactRegistration.service;

import by.bsu.fpmi.contactRegistration.model.Person;

public class PersonService {

    public void saveFullName(Person person, String firstName, String lastName){
        person.setFirstName(firstName);
        person.setLastName(lastName);
    }

    public void saveCompany(Person person, String company){
        person.setCompany(company);
    }

    public void saveHobby(Person person, String hobby){
        person.setHobby(hobby);
    }
}
