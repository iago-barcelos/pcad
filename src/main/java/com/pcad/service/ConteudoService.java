package com.pcad.service;

import com.pcad.dto.request.FiltrarConteudoRequest;
import com.pcad.dto.response.FiltrarConteudoResponse;
import com.pcad.entity.Conteudo;
import com.pcad.repository.ConteudoRepository;
import com.pcad.service.interfaces.IConteudoService;
import com.pcad.specification.ConteudoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConteudoService implements IConteudoService {
    private final ConteudoRepository conteudoRepository;

    @Autowired
    public ConteudoService(ConteudoRepository conteudoRepository) {
        this.conteudoRepository = conteudoRepository;
    }

    @Override
    public List<FiltrarConteudoResponse> filtrar(FiltrarConteudoRequest filtro) {
        Specification<Conteudo> spec = ConteudoSpecification.comFiltros(filtro);

        return conteudoRepository.findAll(spec).stream().map(FiltrarConteudoResponse:: fromEntity).toList();
    }
}
