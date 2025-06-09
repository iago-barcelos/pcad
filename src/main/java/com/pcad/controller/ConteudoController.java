package com.pcad.controller;

import com.pcad.dto.request.FiltrarConteudoRequest;
import com.pcad.dto.response.FiltrarConteudoResponse;
import com.pcad.entity.enums.CategoriaConteudo;
import com.pcad.entity.enums.TipoConteudo;
import com.pcad.service.ConteudoService;
import com.pcad.specification.ConteudoSpecification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/conteudo")
@Tag(name = "Conteúdos", description = "Operações relacionadas a conteúdos educacionais")
public class ConteudoController {
    private ConteudoService conteudoService;

    public ConteudoController(ConteudoService conteudoService) {
        this.conteudoService = conteudoService;
    }

    @Operation(summary = "Listar conteúdos", description = "Lista os conteúdos com base em filtros combináveis")
    @GetMapping
    public ResponseEntity<List<FiltrarConteudoResponse>> listarConteudo(FiltrarConteudoRequest filtro) {
        List<FiltrarConteudoResponse> conteudos = conteudoService.filtrar(filtro);
        return ResponseEntity.ok(conteudos);
    }

    @Operation(summary = "Buscar conteúdo por ID", description = "Retorna um conteúdo específico pelo seu ID")
    @GetMapping("/{id}")
    public ResponseEntity<FiltrarConteudoResponse> buscarConteudoPorId(@PathVariable long id) {
        return ResponseEntity.ok(conteudoService.buscarConteudoPorId(id));
    }

    @Operation(summary = "Buscar conteúdo por categoria", description = "Retorna uma lista de conteúdos de uma categoria")
    @GetMapping("/por-categoria")
    public List<FiltrarConteudoResponse> buscarPorCategoria(@RequestParam CategoriaConteudo categoriaConteudo) {
        return conteudoService.buscarConteudoPorCategoria(categoriaConteudo);
    }

    @Operation(summary = "Buscar conteúdo por tipo", description = "Retorna uma lista de conteúdos de uma tipo")
    @GetMapping("/por-tipo")
    public List<FiltrarConteudoResponse> buscarPorCategoria(@RequestParam TipoConteudo tipoConteudo) {
        return conteudoService.buscarConteudoPorTipo(tipoConteudo);
    }

    @GetMapping("/sync")
    @Operation(
            summary = "Sincronizar conteúdos atualizados",
            description = "Retorna os conteúdos cuja última atualização seja maior ou igual à data fornecida. A data respeita o formato ISO: yyyy-MM-ddTHH:mm:ss. Por exemplo 2025-05-01T00:00:00"
    )
    public List<FiltrarConteudoResponse> sincronizarConteudos(@RequestParam("desde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde) {
        return conteudoService.buscarAtualizadosDesde(desde);
    }

}
