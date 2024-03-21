package com.example.ac1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac1.model.Categoria;
import com.example.ac1.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping()
    public List<Categoria> mostrarTodos() {
        return categoriaRepository.obterTodos();
    }

    @PostMapping()
    public void inserir(@RequestBody Categoria categoria) {
        categoriaRepository.inserir(categoria);
    }

}
