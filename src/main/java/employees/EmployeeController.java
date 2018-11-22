package employees;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repository;
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody @Valid Employee employee) {
	
		return repository.save(employee);
    }
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public List<Employee> getEmployees() {
		
		List<Employee> employees = new ArrayList<Employee>();
		repository.getActiveEmployees().forEach(employees::add);
 
		return employees;
    }
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable(value = "id") int id) {
		
		return repository.getEmployeeByIdAndActive(id);
    }
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public void deleteEmployeeById(@PathVariable(value = "id") int id) {
	
		repository.deleteById(id);
    }
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public void updateEmployeeById(@PathVariable(value = "id") int id,
    					@RequestBody Employee employee) {
		
		repository.updateEmployeeById(employee.getFirstName(), employee.getLastName(), employee.isStatus(), id);
    }

}
