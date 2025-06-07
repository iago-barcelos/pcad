package com.pcad.dto.request;

import com.pcad.entity.Conteudo;
import com.pcad.entity.enums.CategoriaConteudo;
import com.pcad.entity.enums.TipoConteudo;

public record FiltrarConteudoRequest(String titulo, String descricao, TipoConteudo tipoConteudo, CategoriaConteudo categoriaConteudo) {

}
