package com.api.sistemacadastralunificado.services;


import com.api.sistemacadastralunificado.models.PacienteModel;
import com.api.sistemacadastralunificado.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }


    @Transactional
    public PacienteModel save(PacienteModel pacienteModel) {
        return pacienteRepository.save(pacienteModel);
    }

    public boolean existsByCpf(String cpf) {
        return pacienteRepository.existsByCpf(cpf);
    }

    public List<PacienteModel> findAll() {
        return pacienteRepository.findAll();
    }


    public Optional<PacienteModel> findById(String cpf) {
        return pacienteRepository.findById(cpf);
    }

    @Transactional
    public void delete(PacienteModel pacienteModel) {
        pacienteRepository.delete(pacienteModel);
    }
}
