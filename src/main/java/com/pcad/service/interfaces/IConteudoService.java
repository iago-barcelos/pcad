package com.pcad.service.interfaces;

import com.pcad.dto.request.FiltrarConteudoRequest;
import com.pcad.dto.response.FiltrarConteudoResponse;
import com.pcad.entity.Conteudo;
import com.pcad.entity.enums.CategoriaConteudo;
import com.pcad.entity.enums.TipoConteudo;

import java.time.LocalDateTime;
import java.util.List;

public interface IConteudoService {
    List<FiltrarConteudoResponse> filtrar(FiltrarConteudoRequest filtro);
    FiltrarConteudoResponse buscarConteudoPorId(long id);
    List<FiltrarConteudoResponse> buscarConteudoPorCategoria(CategoriaConteudo categoriaConteudo);
    List<FiltrarConteudoResponse> buscarConteudoPorTipo(TipoConteudo tipoConteudo);
    List<FiltrarConteudoResponse> buscarAtualizadosDesde(LocalDateTime desde);
}
