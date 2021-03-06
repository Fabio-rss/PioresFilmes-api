package br.com.fabio.api.recurso;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabio.api.dominio.dto.MinMaxDTO;
import br.com.fabio.api.servico.PremiacaoServico;

@RestController
@RequestMapping(value = "/premiacoes")
public class PremiacaoRecurso {

	private PremiacaoServico premiacaoServico;
	
	public PremiacaoRecurso(PremiacaoServico premiacaoServico) {
		this.premiacaoServico = premiacaoServico;
	}
	
	@GetMapping
	public ResponseEntity<MinMaxDTO> premiacao() {
		return ResponseEntity.ok(this.premiacaoServico.buscarVitoriosos());
	}
}
