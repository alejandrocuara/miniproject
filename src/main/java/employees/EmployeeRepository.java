package employees;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
 
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Employee e SET e.firstName=?2, e.lastName=?3, e.status=?4 WHERE e.id = ?1")
	void updateEmployeeById(int id, String firstname, String lastname, boolean status);
	
	@Query("SELECT e FROM Employee e WHERE e.status=1")
	List<Employee> getActiveEmployees();
	
	@Transactional
	@Modifying
	@Query("UPDATE Employee e SET e.status=0 WHERE e.id = ?1")
	void deleteById(int id);
	
	@Query("SELECT e FROM Employee e WHERE e.id=?1 AND e.status=1")
	Employee getEmployeeByIdAndActive(int id);
}
