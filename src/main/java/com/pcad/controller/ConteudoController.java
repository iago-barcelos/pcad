package com.pcad.controller;

import com.pcad.dto.request.FiltrarConteudoRequest;
import com.pcad.dto.response.FiltrarConteudoResponse;
import com.pcad.service.ConteudoService;
import com.pcad.specification.ConteudoSpecification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/conteudo")
public class ConteudoController {
    private ConteudoService conteudoService;

    public ConteudoController(ConteudoService conteudoService) {
        this.conteudoService = conteudoService;
    }

    @GetMapping
    public ResponseEntity<List<FiltrarConteudoResponse>> listarConteudo(FiltrarConteudoRequest filtro) {
        List<FiltrarConteudoResponse> conteudos = conteudoService.filtrar(filtro);
        return ResponseEntity.ok(conteudos);
    }
}
