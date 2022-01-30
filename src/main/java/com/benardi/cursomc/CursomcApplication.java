package com.benardi.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.benardi.cursomc.domain.Address;
import com.benardi.cursomc.domain.BoletoPayment;
import com.benardi.cursomc.domain.Category;
import com.benardi.cursomc.domain.City;
import com.benardi.cursomc.domain.Client;
import com.benardi.cursomc.domain.CreditCardPayment;
import com.benardi.cursomc.domain.ItemPurchase;
import com.benardi.cursomc.domain.Payment;
import com.benardi.cursomc.domain.Product;
import com.benardi.cursomc.domain.Purchase;
import com.benardi.cursomc.domain.State;
import com.benardi.cursomc.domain.enums.PaymentState;
import com.benardi.cursomc.domain.enums.TypeClient;
import com.benardi.cursomc.repositories.AddressRepository;
import com.benardi.cursomc.repositories.CategoryRepository;
import com.benardi.cursomc.repositories.CityRepository;
import com.benardi.cursomc.repositories.ClientRepository;
import com.benardi.cursomc.repositories.ItemPurchaseRepository;
import com.benardi.cursomc.repositories.PaymentRepository;
import com.benardi.cursomc.repositories.ProductRepository;
import com.benardi.cursomc.repositories.PurchaseRepository;
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
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private ItemPurchaseRepository itemPurchaseRepository;

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

        /* Client and Address */		
		Client cl1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", TypeClient.NATURALPERSON);
		cl1.getTelephones().addAll(Arrays.asList("27363323", "93838393"));

		Address adr1 = new Address(null, "38220834", "Jardim", "Rua Flores", "300", "Apto 303", cl1, c1);
		Address adr2 = new Address(null, "39777012", "Centro", "Avenida Matos", "105", "Sala 800", cl1, c2);

		cl1.getAddresses().addAll(Arrays.asList(adr1, adr2));
		
		clientRepository.saveAll(Arrays.asList(cl1));
		addressRepository.saveAll(Arrays.asList(adr1, adr2));
		
		/* Purchase and Payment */
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Purchase purch1 = new Purchase(null, sdf.parse("30/09/2007 10:32"), cl1, adr1);
		Purchase purch2 = new Purchase(null, sdf.parse("10/10/2017 19:35"), cl1, adr2);
		
		Payment pmt1 = new CreditCardPayment(null, PaymentState.PAID, purch1, 6);
		purch1.setPayment(pmt1);
		
		Payment pmt2 = new BoletoPayment(null, PaymentState.PENDING, purch2, sdf.parse("20/10/2017 00:00"), null);
		purch2.setPayment(pmt2);
		
		cl1.getPurchases().addAll(Arrays.asList(purch1, purch2));
		
		purchaseRepository.saveAll(Arrays.asList(purch1, purch2));
		paymentRepository.saveAll(Arrays.asList(pmt1, pmt2));
		
		ItemPurchase ip1 = new ItemPurchase(purch1, p1, 0.00, 1, 2000.00);
		ItemPurchase ip2 = new ItemPurchase(purch1, p3, 0.00, 2, 80.00);
		ItemPurchase ip3 = new ItemPurchase(purch2, p2, 100.00, 1, 800.00);
		
		purch1.getItems().addAll(Arrays.asList(ip1, ip2));
		purch2.getItems().addAll(Arrays.asList(ip3));
		
		p1.getItems().addAll(Arrays.asList(ip1));
		p2.getItems().addAll(Arrays.asList(ip3));
		p3.getItems().addAll(Arrays.asList(ip2));
		
		itemPurchaseRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
	}

}
