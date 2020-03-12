package com.nisum.webfluxbasic.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")
public class Person implements Serializable {
	@Id
	private int personId;
	private String name;
	private Address addres;
	private EmployementDetails employementDetails;

	public Person() {
		super();
	}

    public EmployementDetails getEmployementDetails() {
        return employementDetails;
    }

    public void setEmployementDetails(EmployementDetails employementDetails) {
        this.employementDetails = employementDetails;
    }

    public Person(int personId, String name, String designation) {
		super();
		this.personId = personId;
		this.name = name;
	}

	public Address getAddres() {
		return addres;
	}

	public void setAddres(Address addres) {
		this.addres = addres;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + personId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (personId != other.personId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + "]";
	}

}
