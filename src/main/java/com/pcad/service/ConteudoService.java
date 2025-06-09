package com.pcad.service;

import com.pcad.dto.request.FiltrarConteudoRequest;
import com.pcad.dto.response.FiltrarConteudoResponse;
import com.pcad.entity.Conteudo;
import com.pcad.entity.enums.CategoriaConteudo;
import com.pcad.entity.enums.TipoConteudo;
import com.pcad.repository.ConteudoRepository;
import com.pcad.service.interfaces.IConteudoService;
import com.pcad.specification.ConteudoSpecification;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public FiltrarConteudoResponse buscarConteudoPorId(long id) {
        Conteudo conteudo = conteudoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conteudo não foi encontrado"));
        return FiltrarConteudoResponse.fromEntity(conteudo);
    }

    @Override
    public List<FiltrarConteudoResponse> buscarConteudoPorCategoria(CategoriaConteudo categoriaConteudo) {
        List<Conteudo> conteudos = conteudoRepository.findByCategoriaConteudo(categoriaConteudo);

        return conteudos.stream()
                .map(FiltrarConteudoResponse::fromEntity)
                .toList();
    }

    @Override
    public List<FiltrarConteudoResponse> buscarConteudoPorTipo(TipoConteudo tipoConteudo) {
        List<Conteudo> conteudos = conteudoRepository.findByTipoConteudo(tipoConteudo);

        return conteudos.stream()
                .map(FiltrarConteudoResponse::fromEntity)
                .toList();
    }

    @Override
    public List<FiltrarConteudoResponse> buscarAtualizadosDesde(LocalDateTime desde) {
        return conteudoRepository.findByUltimaAtualizacaoAfter(desde)
                .stream()
                .map(FiltrarConteudoResponse::fromEntity)
                .toList();
    }

}
