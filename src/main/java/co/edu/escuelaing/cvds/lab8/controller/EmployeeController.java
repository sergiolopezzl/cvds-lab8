package co.edu.escuelaing.cvds.lab8.controller;
import co.edu.escuelaing.cvds.lab8.model.Employee;
import co.edu.escuelaing.cvds.lab8.model.SexoBiologico;
import co.edu.escuelaing.cvds.lab8.service.ConfigurationService;
import co.edu.escuelaing.cvds.lab8.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping("/graficas")
    public String graficas(Model model) {
        double salarioPromedio = employeeService.calcularSalarioPromedio();
        model.addAttribute("salarioPromedio", salarioPromedio);
        return "graficas"; // Nombre de la vista para mostrar el salario promedio.
    }
    @GetMapping("/employees/creates")
    public String createEmployees(@RequestParam Long num){
        for (long employeeId = 1; employeeId <= num; employeeId++) {
            employeeService.createEmployees(employeeId);
        }
        return "redirect:/employees"; // Redirige a la página de lista de empleados después de la creación.
    }
    @GetMapping("/graficas/creates")
    public String graficas(@RequestParam Long num) {
        for (long employeeId = 1; employeeId <= num; employeeId++) {
            employeeService.createEmployees(employeeId);
        }
        for (long employeeId = 1; employeeId <= num; employeeId++) {
            int count = 0;
            if(employeeService.getEmployeeById(employeeId).getSexoBiologico() == SexoBiologico.MASCULINO){
                count +=1;
            };
            employeeService.setCantidad(count);
        }

        return "graficas"; // Nombre de la vista para mostrar el salario promedio.
    }

    @GetMapping("/employees")
    public String employees(Model model) {
        List<Employee> employeeList = employeeService.getAll();
        Double sumaList = employeeService.getSumas();

        // Calcula la suma de personas por sexo
        Double sumaMasculino = (double) employeeList.stream()
                .filter(e -> e.getSexoBiologico() == SexoBiologico.MASCULINO)
                .count();

        Double sumaFemenino = (double) employeeList.stream()
                .filter(e -> e.getSexoBiologico() == SexoBiologico.FEMENINO)
                .count();

        Double sumaIntersexual = (double) employeeList.stream()
                .filter(e -> e.getSexoBiologico() == SexoBiologico.INTERSEXUAL)
                .count();

        Double sumaNoEspecificado = (double) employeeList.stream()
                .filter(e -> e.getSexoBiologico() == SexoBiologico.NO_ESPECIFICADO)
                .count();

        model.addAttribute("employeeList", employeeList);
        model.addAttribute("sumaMasculino", sumaMasculino);
        model.addAttribute("sumaFemenino", sumaFemenino);
        model.addAttribute("sumaIntersexual", sumaIntersexual);
        model.addAttribute("sumaNoEspecificado", sumaNoEspecificado);
        model.addAttribute("sumaTotal", sumaList);

        return "employees";
    }
    @PostMapping("/employees/create")
    public String createEmployee(@RequestParam Long employeeId, String firstName,String lastName,SexoBiologico sexoBiologico, String role ,String salary, String idEmpresa){
        employeeService.createEmployee(employeeId, firstName, lastName,sexoBiologico, role, salary, idEmpresa);
        return "redirect:/employees"; // Redirige a la página de lista de empleados después de la creación.
    }

    @PostMapping("/employees/update")
    public String updateEmployee(@RequestParam Long employeeId, String firstName,String lastName,SexoBiologico sexoBiologico, String role ,String salary, String idEmpresa){
        employeeService.updateEmployee(employeeId, firstName, lastName, sexoBiologico, role, salary, idEmpresa);
        return "redirect:/employees"; // Redirige a la página de lista de empleados después de la actualización.
    }

    @PostMapping("/employees/delete")
    public String deleteEmployee(@RequestParam Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employees"; // Redirige a la página de lista de empleados después de la actualización.
    }

    
}

