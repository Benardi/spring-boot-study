package com.benardi.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.benardi.cursomc.domain.Category;
import com.benardi.cursomc.domain.City;
import com.benardi.cursomc.domain.Product;
import com.benardi.cursomc.domain.State;
import com.benardi.cursomc.repositories.CategoryRepository;
import com.benardi.cursomc.repositories.CityRepository;
import com.benardi.cursomc.repositories.ProductRepository;
import com.benardi.cursomc.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category ctg1 = new Category(null, "Informática");
		Category ctg2 = new Category(null, "Escritório");

		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);

		ctg1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		ctg2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(ctg1));
		p2.getCategories().addAll(Arrays.asList(ctg1, ctg2));
		p3.getCategories().addAll(Arrays.asList(ctg1));

		categoryRepository.saveAll(Arrays.asList(ctg1, ctg2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		/* State and City */
		State est1 = new State(null, "Minas Gerais");
		State est2 = new State(null, "São Paulo");

		City c1 = new City(null, "Uberlândia", est1);
		City c2 = new City(null, "São Paulo", est2);
		City c3 = new City(null, "Campinas", est2);

		est1.getCities().addAll(Arrays.asList(c1));
		est2.getCities().addAll(Arrays.asList(c2, c3));

		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
	}

}
