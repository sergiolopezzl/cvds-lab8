package co.edu.escuelaing.cvds.lab8.repository;




import co.edu.escuelaing.cvds.lab8.model.Configuration;
import co.edu.escuelaing.cvds.lab8.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //public List<Employee> findByPropiedad(String propiedad);

}

