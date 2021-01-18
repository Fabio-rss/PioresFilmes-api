package br.com.fabio.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fabio.api.servico.LerPlanilhaServico;

@SpringBootApplication
public class PioresFilmesApiApplication implements CommandLineRunner {

	private LerPlanilhaServico servico;

	public PioresFilmesApiApplication(LerPlanilhaServico servico) {
		this.servico = servico;
	}

	public static void main(String[] args) {
		SpringApplication.run(PioresFilmesApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.servico.extrairDadosPlanilha("movielist.csv");
	}

}
