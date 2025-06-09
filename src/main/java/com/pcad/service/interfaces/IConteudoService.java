package com.pcad.service.interfaces;

import com.pcad.dto.request.FiltrarConteudoRequest;
import com.pcad.dto.response.FiltrarConteudoResponse;
import com.pcad.entity.Conteudo;

import java.util.List;

public interface IConteudoService {
    List<FiltrarConteudoResponse> filtrar(FiltrarConteudoRequest filtro);

    FiltrarConteudoResponse buscarConteudoPorId(long id);
}
