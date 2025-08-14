package com.controller;

import com.model.Empresa;
import com.repository.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/teste")
public String teste() {
    return "teste";
}


    @GetMapping("/")
    public String mostrarFormularioInicial(Model model) {
        model.addAttribute("empresa", new Empresa());
        return "empresa/form-empresa";
    }

    @GetMapping("/empresa/lista")
    public String listarEmpresas(Model model) {
        model.addAttribute("empresas", empresaRepository.findAll());
        return "empresa/lista-empresa";
    }

    @GetMapping("/empresa/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("empresa", new Empresa());
        return "empresa/form-empresa";
    }

    @PostMapping("/empresa/salvar")
    public String salvarEmpresa(@ModelAttribute Empresa empresa) {
        empresaRepository.save(empresa);
        return "redirect:/empresa/lista";
    }

    @GetMapping("/empresa/editar/{id}")
    public String editarEmpresa(@PathVariable Long id, Model model) {
        Empresa empresa = empresaRepository.findById(id).orElseThrow();
        model.addAttribute("empresa", empresa);
        return "empresa/update-empresa";
    }

    @PostMapping("/empresa/atualizar")
    public String atualizarEmpresa(@ModelAttribute Empresa empresa) {
        empresaRepository.save(empresa);
        return "redirect:/empresa/lista";
    }

    @GetMapping("/empresa/deletar/{id}")
    public String deletarEmpresa(@PathVariable Long id) {
        empresaRepository.deleteById(id);
        return "redirect:/empresa/lista";
    }
}