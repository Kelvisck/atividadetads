package com.kelvisck.primeiroexemplo.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.kelvisck.primeiroexemplo.shared.PlanoDTO;

//import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kelvisck.primeiroexemplo.model.Plano;
import com.kelvisck.primeiroexemplo.model.exception.ResourceNotFoundException;
import com.kelvisck.primeiroexemplo.repository.PlanoRepository;

@Service
public class PlanoService {
    
    @Autowired
    private PlanoRepository planoRepository;

    public List<PlanoDTO> obterTodos(){
        List<Plano> planos = planoRepository.findAll();
        return planos.stream().map(p -> new ModelMapper().map(p, PlanoDTO.class)).collect(Collectors.toList());
    }

    public Optional<PlanoDTO> obterPorId(Integer id){
         Optional<Plano> plano = planoRepository.findById(id);
         if(plano.isEmpty()){
            throw new ResourceNotFoundException("Plano com id: " + id + "naão encontrado");
         }
         PlanoDTO dto = new ModelMapper().map(plano.get(), PlanoDTO.class);
         return Optional.of(dto);
    }
    

   
    public void deletarPlano(Integer id){
        // verificar se ele existe

        Optional<Plano> plano = planoRepository.findById(id);
        
        if(plano.isEmpty()){
            throw new ResourceNotFoundException
            ("Não foi possivel deletar o plano com o id: " + id + " plano não existe");
        }

        planoRepository.deleteById(id);
    }

    public PlanoDTO adicionar(PlanoDTO planoDTO){
        planoDTO.setId(null);
        
        //criar objeto de mapeamento
        ModelMapper mapper = new ModelMapper();
        // converter o nosso PlanoDto em um plano
        Plano plano = mapper.map(planoDTO, Plano.class);
        //salvar o plano no banco
        plano = planoRepository.save(plano);

        planoDTO.setId(plano.getId());
        // retornar o plano atualizado


        return planoDTO;

    }

    public PlanoDTO atualizar(Integer id, PlanoDTO planoDTO){

        //passar o id para o plano dto
        planoDTO.setId(id);

        //criar um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();
        //converter o dto em um plano
        Plano plano = mapper.map(planoDTO, Plano.class);
        //atualizar o plano no banco
        planoRepository.save(plano);
        //retornar o plano atualizado
        return planoDTO;
    }



    
}
