package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.model.Categoria;
import com.example.ac1.model.Produto;
import com.example.ac1.repository.CategoriaRepository;
import com.example.ac1.repository.ProdutoRepository;

@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(@Autowired ProdutoRepository produtoRepository,
			@Autowired CategoriaRepository categoriaRepository) {
		return args -> {
			produtoRepository.inserir(new Produto(0, "Celular", 250));
			produtoRepository.inserir(new Produto(0, "Caneta", 400));

			System.out.println("\nExemple listar todos produtos");
			List<Produto> listaProdutos = produtoRepository.obterTodos();
			listaProdutos.forEach(System.out::println);

			System.out.println("\nExemplo listar produtos por id");
			Produto produtoSelecionado = produtoRepository.obterPorId(1);
			System.out.println(produtoSelecionado);

			categoriaRepository.inserir(new Categoria(0, "Eletrocinos", "Dipositivos eletronicos"));
			categoriaRepository.inserir(new Categoria(0, "Papelaria", "Produtos de papelaria"));

			System.out.println("\nExemple listar todas categorias");
			List<Categoria> listaCategorias = categoriaRepository.obterTodos();
			listaCategorias.forEach(System.out::println);

			System.out.println("\nExemplo listar categorias por id");
			Categoria categoriaSelecionada = categoriaRepository.obterPorId(1);
			System.out.println(categoriaSelecionada);

			Produto prod1 = produtoRepository.obterPorId(1);
			prod1.setId_categoria(categoriaSelecionada);
			produtoRepository.editar(prod1);

			Produto prod2 = produtoRepository.obterPorId(2);
			prod2.setId_categoria(categoriaRepository.obterPorId(2));
			produtoRepository.editar(prod2);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
