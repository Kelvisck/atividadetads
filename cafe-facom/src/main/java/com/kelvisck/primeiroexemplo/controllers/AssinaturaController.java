package com.kelvisck.primeiroexemplo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kelvisck.primeiroexemplo.services.AssinaturaService;
import com.kelvisck.primeiroexemplo.shared.AssinaturaDTO;

import com.kelvisck.primeiroexemplo.view.model.AssinaturaRequest;
import com.kelvisck.primeiroexemplo.view.model.AssinaturaResponse;



@RestController
@RequestMapping("/api/assinaturas")
public class AssinaturaController {

    @Autowired
    private AssinaturaService assinaturaService;

    @GetMapping
    public ResponseEntity<List<AssinaturaResponse>> obterTodos(){
        List<AssinaturaDTO> assinaturas = assinaturaService.obterTodos();
        ModelMapper mapper = new ModelMapper();

        List<AssinaturaResponse> resposta = assinaturas.stream().map(p -> mapper.map(p, AssinaturaResponse.class)).
        collect(Collectors.toList());

        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AssinaturaResponse>> obterPorId(@PathVariable Integer id){
        
        Optional<AssinaturaDTO> dto = assinaturaService.obterPorId(id);

        AssinaturaResponse assinatura = new ModelMapper().map(dto.get(), AssinaturaResponse.class);
        return new ResponseEntity<Optional<AssinaturaResponse>>(Optional.of(assinatura), HttpStatus.OK);       
    }

    @PostMapping
    public ResponseEntity<AssinaturaResponse> adicionar(@RequestBody AssinaturaRequest assinaturaRequest){
        ModelMapper mapper = new ModelMapper();
        AssinaturaDTO dto =  mapper.map(assinaturaRequest, AssinaturaDTO.class);
        
        dto =  assinaturaService.adicionar(dto);
        
        return new ResponseEntity<>(mapper.map(dto, AssinaturaResponse.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){ 
        assinaturaService.deletarAssinatura(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<AssinaturaResponse> atualizar(@RequestBody AssinaturaRequest assinaturaRequest, @PathVariable Integer id){

        ModelMapper mapper = new ModelMapper();
        AssinaturaDTO dto = mapper.map(assinaturaRequest, AssinaturaDTO.class);

        dto = assinaturaService.atualizar(id, dto);

        return new ResponseEntity<>(
            mapper.map(dto, AssinaturaResponse.class), HttpStatus.OK
        ); 

    }



    
}
