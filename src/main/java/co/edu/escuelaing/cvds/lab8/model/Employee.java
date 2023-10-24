package co.edu.escuelaing.cvds.lab8.model;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @Column(name = "employeeId")
    private Long employeeId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "sexoBiologico")
    private SexoBiologico sexoBiologico;
    @Column(name = "role")
    private String role;
    @Column(name = "salary")
    private String salary;
    @Column(name = "idEmpresa")
    private String idEmpresa;


    public Employee() {

    }

    public Employee(Long employeeId, String firstName, String lastName, SexoBiologico sexoBiologico, String role, String salary, String idEmpresa) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sexoBiologico = sexoBiologico;
        this.role = role;
        this.salary = salary;
        this.idEmpresa = idEmpresa;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public SexoBiologico getSexoBiologico() {
        return sexoBiologico;
    }

    public void setSexoBiologico(SexoBiologico sexoBiologico) {
        this.sexoBiologico = sexoBiologico;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    // Getters and setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && sexoBiologico == employee.sexoBiologico && Objects.equals(role, employee.role) && Objects.equals(salary, employee.salary) && Objects.equals(idEmpresa, employee.idEmpresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, sexoBiologico, role, salary, idEmpresa);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sexoBiologico=" + sexoBiologico +
                ", role='" + role + '\'' +
                ", salary='" + salary + '\'' +
                ", idEmpresa='" + idEmpresa + '\'' +
                '}';
    }
}
