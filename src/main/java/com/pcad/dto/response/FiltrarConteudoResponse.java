package com.pcad.dto.response;

import com.pcad.entity.Conteudo;
import com.pcad.entity.enums.CategoriaConteudo;
import com.pcad.entity.enums.TipoConteudo;

import java.time.LocalDateTime;

public record FiltrarConteudoResponse(String titulo, String descricao, TipoConteudo tipoConteudo, CategoriaConteudo categoriaConteudo, String urlArquivo, LocalDateTime ultimaAtualizacao) {
    public static FiltrarConteudoResponse fromEntity(Conteudo conteudo) {
        return new FiltrarConteudoResponse(
                conteudo.getTitulo(),
                conteudo.getDescricao(),
                conteudo.getTipoConteudo(),
                conteudo.getCategoriaConteudo(),
                conteudo.getUrlArquivo(),
                conteudo.getUltimaAtualizacao()
        );
    }
}
