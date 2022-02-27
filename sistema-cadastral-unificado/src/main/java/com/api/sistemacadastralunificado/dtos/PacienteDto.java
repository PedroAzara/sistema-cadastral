package com.api.sistemacadastralunificado.dtos;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class PacienteDto {


    @Size(max = 11, min = 11)
    private String cpf;
    private String nome;
    @Size(max=2)
    private String uf;
    private LocalDateTime nascimento;
    private Float peso;
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
