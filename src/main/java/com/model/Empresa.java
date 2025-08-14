package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.validation.constraints.*;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da empresa é obrigatório")
    @Size(max = 25, message = "O nome pode ter no máximo 25 caracteres")
    private String nome;

    @NotBlank(message = "O CNPJ é obrigatório")
    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter exatamente 14 números")
    private String cnpj;

    @Email(message = "E-mail inválido")
    @Size(max = 30, message = "O e-mail pode ter no máximo 30 caracteres")
    private String email;

    @Pattern(regexp = "^(\\(?\\d{2}\\)?\\s?\\d{5}-?\\d{4})$", message = "Telefone inválido. Deve conter 11 dígitos, com ou sem formatação")     
    private String telefone;

    @NotBlank(message = "O nome do responsável é obrigatório")
    @Size(max = 50, message = "O nome do responsável pode ter no máximo 5   0 caracteres")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "O nome do responsável deve conter apenas letras e espaços")
    private String responsavel;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
