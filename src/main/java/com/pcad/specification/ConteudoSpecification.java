package com.pcad.specification;

import com.pcad.dto.request.FiltrarConteudoRequest;
import com.pcad.entity.Conteudo;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

public class ConteudoSpecification {

    public static Specification<Conteudo> comFiltros(FiltrarConteudoRequest filtro) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filtro.titulo() != null) {
                predicates.add(cb.like(cb.lower(root.get("titulo")), "%" + filtro.titulo().toLowerCase() + "%"));
            }
            if (filtro.descricao() != null) {
                predicates.add(cb.like(cb.lower(root.get("descricao")), "%" + filtro.descricao().toLowerCase() + "%"));
            }
            if (filtro.tipoConteudo() != null) {
                predicates.add(cb.equal(root.get("tipoConteudo"), filtro.tipoConteudo()));
            }
            if (filtro.categoriaConteudo() != null) {
                predicates.add(cb.equal(root.get("categoriaConteudo"), filtro.categoriaConteudo()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

