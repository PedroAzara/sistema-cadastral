package com.api.sistemacadastralunificado.controllers;

import com.api.sistemacadastralunificado.dtos.PacienteDto;
import com.api.sistemacadastralunificado.models.PacienteModel;
import com.api.sistemacadastralunificado.services.PacienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/paciente")
public class PacienteController {

    final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping (consumes = "application/json")
    public ResponseEntity <Object> savePaciente(@RequestBody @Valid PacienteDto pacienteDto) {
        if(pacienteService.existsByCpf(pacienteDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CONFLITO: esse CPF já está em uso!");
        }
        if(pacienteDto.getCpf().length() != 11){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: o CPF tem que ter 11 números!");
        } //Método post para salvar dados de pacientes

        var pacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteDto, pacienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(pacienteModel));


    }

    @GetMapping
    public ResponseEntity<List<PacienteModel>> getAllPacientes(){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.findAll());
    } //Método Get para listar todos os pacientes


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePacienteService(@PathVariable(value = "id") String cpf){
        Optional<PacienteModel> pacienteModelOptional = pacienteService.findById(cpf);
        if (!pacienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF não encontrado.");
        }
        pacienteService.delete(pacienteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Paciente deletado com sucesso!");
    }

    //Método Delete para deletar o paciente pelo CPF selecionado 
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePacienteService(@PathVariable(value= "id") String cpf,
                                                        @RequestBody @Valid PacienteDto pacienteDto){
        Optional<PacienteModel> pacienteModelOptional = pacienteService.findById(cpf);
        if (!pacienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF não encontrado");
        }
        var pacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteDto, pacienteModel);
        pacienteModel.setAltura(pacienteDto.getAltura());
        pacienteModel.setCpf(pacienteDto.getCpf());
        pacienteModel.setNascimento(pacienteDto.getNascimento());
        pacienteModel.setPeso(pacienteDto.getPeso());
        pacienteModel.setNome(pacienteDto.getNome());
        pacienteModel.setUf(pacienteDto.getUf());
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.save(pacienteModel));
    }

    //Método para editar o paciente pelo CPF selecionado
}
