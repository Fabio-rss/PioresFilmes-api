package br.com.fabio.api.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fabio.api.dominio.Filme;
import br.com.fabio.api.dominio.Produtor;
import br.com.fabio.api.dominio.dto.MinMaxDTO;
import br.com.fabio.api.dominio.dto.VitoriaProdutorDTO;
import br.com.fabio.api.repositorio.ProdutorRepositorio;

@Service
public class PremiacaoServico {

	private ProdutorRepositorio produtorRepo;

	public PremiacaoServico(ProdutorRepositorio produtorRepo) {
		this.produtorRepo = produtorRepo;
	}

	public MinMaxDTO buscarVitoriosos() {
		List<Produtor> produtores = this.produtorRepo.somenteProdutoresComVitorias();
		List<VitoriaProdutorDTO> lista = new ArrayList<>();

		for (Produtor p : produtores) {
			VitoriaProdutorDTO dto = new VitoriaProdutorDTO(p.getNome(), 0, 9999, 0);

			for (Filme f : p.getFilmes()) {
				if (f.getAno() < dto.getPreviousWin()) {
					dto.setPreviousWin(f.getAno());
				}

				if (f.getAno() > dto.getFollowingWin()) {
					dto.setFollowingWin(f.getAno());
				}
			}

			if (dto.getInterval() > 0) {
				lista.add(dto);
			}
		}

		MinMaxDTO respostaDTO = new MinMaxDTO();

		Collections.sort(lista);
		respostaDTO.setMin(new ArrayList<>(lista));
		Collections.sort(lista, Collections.reverseOrder());
		respostaDTO.setMax(lista);

		return respostaDTO;
	}
}
