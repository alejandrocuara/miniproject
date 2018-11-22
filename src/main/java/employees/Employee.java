package employees;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Employee implements Serializable {
 
    private static final long serialVersionUID = -3009157732242241606L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 
    @Column(name = "firstname")
    private String firstName;
 
    @Column(name = "lastname")
    private String lastName;
    
    @Column(name = "status")
    private boolean status;
    
    protected Employee() {}

    public Employee(int id, String firstName, String lastName, boolean status) {
    	this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName +
                ", status=" + status +
                '}';
    }
 
}