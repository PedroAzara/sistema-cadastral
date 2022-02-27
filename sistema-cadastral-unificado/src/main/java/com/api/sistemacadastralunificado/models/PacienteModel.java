package com.api.sistemacadastralunificado.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


// Criação do model Paciente 
@Entity
@Table(name="Pacientes")
public class PacienteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 2)
    private String uf;
    @Column(nullable = false)
    private LocalDateTime nascimento;
    @Column(nullable = false)
    private Float peso;
    @Column(nullable = false)
    private Float altura;


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public LocalDateTime getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDateTime nascimento) {
        this.nascimento = nascimento;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }
}
