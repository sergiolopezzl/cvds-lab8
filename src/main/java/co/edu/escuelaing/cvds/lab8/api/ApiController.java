package co.edu.escuelaing.cvds.lab8.api;

import co.edu.escuelaing.cvds.lab8.model.Employee;
import co.edu.escuelaing.cvds.lab8.model.Empresa;
import co.edu.escuelaing.cvds.lab8.service.EmployeeService;
import co.edu.escuelaing.cvds.lab8.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    @PutMapping("/employee/{employeeId}")
    public void updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) {
        employeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/employee/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @GetMapping("/empresas")
    public List<Empresa> getAllEmpresas() {
        return empresaService.getAll();
    }

    @GetMapping("/empresa/{nitId}")
    public Empresa getEmpresa(@PathVariable Long nitId) {
        return empresaService.getEmpresaById(nitId);
    }
}
