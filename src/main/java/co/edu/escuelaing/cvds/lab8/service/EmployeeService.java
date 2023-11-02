package co.edu.escuelaing.cvds.lab8.service;

import co.edu.escuelaing.cvds.lab8.model.Employee;
import co.edu.escuelaing.cvds.lab8.model.Empresa;
import co.edu.escuelaing.cvds.lab8.model.SexoBiologico;
import co.edu.escuelaing.cvds.lab8.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void createEmployees(Long id) {
        Employee employee = new Employee(id);
        employeeRepository.save(employee);
    }
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }
    public double getSumas(){
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            return 0.0; // Manejo de caso vacío para evitar divisiones por cero.
        }

        double totalSalario = employees.stream()
                .mapToDouble(employee -> Double.parseDouble(employee.getSalary()))
                .sum();

        return totalSalario / employees.size();

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

    public double calcularSalarioPromedio() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            return 0.0; // Manejo de caso vacío para evitar divisiones por cero.
        }

        double totalSalario = employees.stream()
                .mapToDouble(employee -> Double.parseDouble(employee.getSalary()))
                .sum();

        return totalSalario / employees.size();
    }


    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Long employeeId, Employee employee) {
    }


    public void setCantidad(int count) {


    }
}