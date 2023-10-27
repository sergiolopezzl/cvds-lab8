package co.edu.escuelaing.cvds.lab8.repository;

import co.edu.escuelaing.cvds.lab8.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario
}
