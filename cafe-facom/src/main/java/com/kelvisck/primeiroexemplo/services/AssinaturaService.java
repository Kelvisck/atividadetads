package com.kelvisck.primeiroexemplo.services;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import org.springframework.stereotype.Service;

import com.kelvisck.primeiroexemplo.model.Assinatura;
import com.kelvisck.primeiroexemplo.model.exception.ResourceNotFoundException;
import com.kelvisck.primeiroexemplo.repository.AssinaturaRepository;
import com.kelvisck.primeiroexemplo.shared.AssinaturaDTO;

@Service
public class AssinaturaService {

    @Autowired
    private AssinaturaRepository assinaturaRepository;

    public List<AssinaturaDTO> obterTodos(){
        List<Assinatura> assinaturas = assinaturaRepository.findAll();
        return assinaturas.stream().map(p -> new ModelMapper().map(p, AssinaturaDTO.class)).collect(Collectors.toList());
    }

    public Optional<AssinaturaDTO> obterPorId(Integer id){
         Optional<Assinatura> assinatura = assinaturaRepository.findById(id);
         if(assinatura.isEmpty()){
            throw new ResourceNotFoundException("Assinatura com id: " + id + "naão encontrado");
         }
         AssinaturaDTO dto = new ModelMapper().map(assinatura.get(), AssinaturaDTO.class);
         return Optional.of(dto);
    }
    

   
    public void deletarAssinatura(Integer id){
        // verificar se ele existe

        Optional<Assinatura> assinatura = assinaturaRepository.findById(id);
        
        if(assinatura.isEmpty()){
            throw new ResourceNotFoundException
            ("Não foi possivel deletar o assinatura com o id: " + id + " assinatura não existe");
        }

        assinaturaRepository.deleteById(id);
    }

    public AssinaturaDTO adicionar(AssinaturaDTO assinaturaDTO){
        assinaturaDTO.setId(null);
        
        //criar objeto de mapeamento
        ModelMapper mapper = new ModelMapper();
        
        Assinatura assinatura = mapper.map(assinaturaDTO, Assinatura.class);
        
        assinatura = assinaturaRepository.save(assinatura);

        assinaturaDTO.setId(assinatura.getId());
        


        return assinaturaDTO;

    }

    public AssinaturaDTO atualizar(Integer id, AssinaturaDTO assinaturaDTO){

        
        assinaturaDTO.setId(id);
        ModelMapper mapper = new ModelMapper();
        
        Assinatura assinatura = mapper.map(assinaturaDTO, Assinatura.class);
        
        assinaturaRepository.save(assinatura);
        
        return assinaturaDTO;
    }




    
}
