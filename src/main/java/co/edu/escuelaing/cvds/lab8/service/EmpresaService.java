
package co.edu.escuelaing.cvds.lab8.service;

import co.edu.escuelaing.cvds.lab8.model.Empresa;
import co.edu.escuelaing.cvds.lab8.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> getAll() {
        return empresaRepository.findAll();
    }

    public Empresa getEmpresaById(Long nitId) {
        return empresaRepository.findById(nitId).orElse(null);
    }

    public void createEmpresa(Empresa empresa) {
        empresaRepository.save(empresa);
    }

    public void updateEmpresa(Long nitId, Empresa empresa) {
        Empresa existingEmpresa = empresaRepository.findById(nitId).orElse(null);
        if (existingEmpresa != null) {
            existingEmpresa.setName(empresa.getName());
            existingEmpresa.setPhone(empresa.getPhone());
            existingEmpresa.setEmail(empresa.getEmail());
            existingEmpresa.setDirection(empresa.getDirection());
            empresaRepository.save(existingEmpresa);
        }
    }

    public void deleteEmpresa(Long nitId) {
        empresaRepository.deleteById(nitId);
    }
}
