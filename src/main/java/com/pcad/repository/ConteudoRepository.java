package com.pcad.repository;

import com.pcad.entity.Conteudo;
import com.pcad.entity.enums.CategoriaConteudo;
import com.pcad.entity.enums.TipoConteudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long>, JpaSpecificationExecutor<Conteudo> {
    List<Conteudo> findByCategoriaConteudo(CategoriaConteudo categoriaConteudo);
    List<Conteudo> findByTipoConteudo(TipoConteudo tipoConteudo);
    List<Conteudo> findByUltimaAtualizacaoAfter(LocalDateTime data);
}
