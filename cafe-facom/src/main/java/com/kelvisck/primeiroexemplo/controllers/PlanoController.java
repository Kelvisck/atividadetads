package com.kelvisck.primeiroexemplo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//import org.apache.catalina.connector.Response;
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


import com.kelvisck.primeiroexemplo.services.PlanoService;
import com.kelvisck.primeiroexemplo.shared.PlanoDTO;
import com.kelvisck.primeiroexemplo.view.model.PlanoRequest;
import com.kelvisck.primeiroexemplo.view.model.PlanoResponse;

@RestController
@RequestMapping("/api/planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @GetMapping
    public ResponseEntity<List<PlanoResponse>> obterTodos(){
        List<PlanoDTO> planos = planoService.obterTodos();
        ModelMapper mapper = new ModelMapper();

        List<PlanoResponse> resposta = planos.stream().map(p -> mapper.map(p, PlanoResponse.class)).
        collect(Collectors.toList());

        //retornando uma resposa com lista de response e status ok, objeto devolvido como deseja.
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PlanoResponse>> obterPorId(@PathVariable Integer id){
        
        Optional<PlanoDTO> dto = planoService.obterPorId(id);

        PlanoResponse plano = new ModelMapper().map(dto.get(), PlanoResponse.class);
        return new ResponseEntity<Optional<PlanoResponse>>(Optional.of(plano), HttpStatus.OK);       
    }

    @PostMapping
    public ResponseEntity<PlanoResponse> adicionar(@RequestBody PlanoRequest planoReq){
        ModelMapper mapper = new ModelMapper();
        PlanoDTO dto =  mapper.map(planoReq, PlanoDTO.class);
        
        dto =  planoService.adicionar(dto);
        
        return new ResponseEntity<>(mapper.map(dto, PlanoResponse.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){ 
        planoService.deletarPlano(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<PlanoResponse> atualizar(@RequestBody PlanoRequest planoReq, @PathVariable Integer id){

        ModelMapper mapper = new ModelMapper();
        PlanoDTO dto = mapper.map(planoReq, PlanoDTO.class);

        dto = planoService.atualizar(id, dto);

        return new ResponseEntity<>(
            mapper.map(dto, PlanoResponse.class), HttpStatus.OK
        ); 

    }
    
}
