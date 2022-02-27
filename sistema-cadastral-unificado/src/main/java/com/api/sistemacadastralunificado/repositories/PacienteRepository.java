package com.api.sistemacadastralunificado.repositories;

import com.api.sistemacadastralunificado.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, String> {
    boolean existsByCpf(String cpf);


}
