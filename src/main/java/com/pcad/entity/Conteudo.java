package com.pcad.entity;

import com.pcad.entity.enums.CategoriaConteudo;
import com.pcad.entity.enums.TipoConteudo;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Conteudo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String titulo;

    @Column(length = 1000)
    private String descricao;

    @Enumerated
    private TipoConteudo tipoConteudo;

    @Enumerated
    private CategoriaConteudo categoriaConteudo;

    private String urlArquivo;

    private LocalDateTime ultimaAtualizacao;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoConteudo getTipoConteudo() {
        return tipoConteudo;
    }

    public void setTipoConteudo(TipoConteudo tipoConteudo) {
        this.tipoConteudo = tipoConteudo;
    }

    public CategoriaConteudo getCategoriaConteudo() {
        return categoriaConteudo;
    }

    public void setCategoriaConteudo(CategoriaConteudo categoriaConteudo) {
        this.categoriaConteudo = categoriaConteudo;
    }

    public String getUrlArquivo() {
        return urlArquivo;
    }

    public void setUrlArquivo(String urlArquivo) {
        this.urlArquivo = urlArquivo;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
}
