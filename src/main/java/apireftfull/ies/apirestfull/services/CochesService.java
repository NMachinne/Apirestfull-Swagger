package apireftfull.ies.apirestfull.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apireftfull.ies.apirestfull.exceptions.RecordNotFoundException;
import apireftfull.ies.apirestfull.model.Coches;
import apireftfull.ies.apirestfull.repository.CochesRepository;

@Service
public class CochesService {
     
    @Autowired
    CochesRepository repository;
     
    public List<Coches> getAllItems()
    {
        List<Coches> CocheList = repository.findAll();
         
        if(CocheList.size() > 0) {
            return CocheList;
        } else {
            return new ArrayList<Coches>();
        }
    }
     
    public Coches getCochesById(Long id) throws RecordNotFoundException
    {
        Optional<Coches> Coches = repository.findById(id);
         
        if(Coches.isPresent()) {
            return Coches.get();
        } else {
            throw new RecordNotFoundException("No student record exist for given id",id);
        }
    }
     
    public Coches createOrUpdateCoches(Coches entity) throws RecordNotFoundException
    {
    	    	
    	if(entity.getId()!=null)
    	{
    	  Optional<Coches> Coches = repository.findById(entity.getId());
        
    	if(Coches.isPresent())
        {
    		Coches newEntity = Coches.get();
            newEntity.setId(entity.getId());
            newEntity.setMarca(entity.getMarca());
            newEntity.setModelo(entity.getModelo());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    	}
    	
    	else
    	{
    		entity = repository.save(entity);
    		return entity;
    	}	    
 }
     
    public void deleteCochesById(Long id) throws RecordNotFoundException
    {
        Optional<Coches> Coches = repository.findById(id);
         
        if(Coches.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No item record exist for given id",id);
        }
    }

    //PASO 2
    public List<Coches> getCochesByMarca(String marca) {
        List<Coches> CochesList = repository.findByMarca(marca);
        if(CochesList.size() > 0) {
            return CochesList;
        } else {
            return new ArrayList<Coches>();
        }
    }
}
