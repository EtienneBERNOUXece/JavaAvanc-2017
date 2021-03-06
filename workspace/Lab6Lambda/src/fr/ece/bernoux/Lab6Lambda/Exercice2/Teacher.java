package fr.ece.bernoux.Lab6Lambda.Exercice2;

/**
 * class teacher
 * 
 * @author Etienne & Nicolas
 *
 */
public class Teacher {
	// attributes
	private final String name;
	private final Gender gender;

	// constructor
	public Teacher(String name, Gender gender) {
		super();
		this.name = name;
		this.gender = gender;
	}

	// getters
	public Gender getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	// method toString
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", gender=" + gender + "]";
	}

}
