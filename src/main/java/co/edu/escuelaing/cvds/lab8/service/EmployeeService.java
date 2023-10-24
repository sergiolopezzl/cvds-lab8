package co.edu.escuelaing.cvds.lab8.service;

import co.edu.escuelaing.cvds.lab8.model.Employee;
import co.edu.escuelaing.cvds.lab8.model.SexoBiologico;
import co.edu.escuelaing.cvds.lab8.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(Long id, String name, String lastname, SexoBiologico sexoBiologico, String role, String salary, String idEmpresa){
        Employee employee = new Employee(id, name, lastname, sexoBiologico, role, salary, idEmpresa);
        employeeRepository.save(employee);
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public void updateEmployee(Long id, String name,String lastname,SexoBiologico sexoBiologico, String role,String salary, String idEmpresa){
        Employee employee = employeeRepository.getReferenceById(id);

        employee.setFirstName(!name.isEmpty() ? name : employee.getFirstName());
        employee.setLastName(!lastname.isEmpty() ? lastname : employee.getLastName());
        employee.setSexoBiologico(sexoBiologico != null ? sexoBiologico : employee.getSexoBiologico());
        employee.setRole(!role.isEmpty() ? role : employee.getRole());
        employee.setSalary(!salary.isEmpty() ? salary : employee.getSalary());
        employee.setIdEmpresa(!idEmpresa.isEmpty() ? idEmpresa : employee.getIdEmpresa());

        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }




}