package apireftfull.ies.apirestfull.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apireftfull.ies.apirestfull.exceptions.RecordNotFoundException;
import apireftfull.ies.apirestfull.model.Cliente;
import apireftfull.ies.apirestfull.repository.ClienteRepository;
 
@Service
public class ClienteService {
     
    @Autowired
    ClienteRepository repository;
     
    public List<Cliente> getAllClientes()
    {
        List<Cliente> ClientList = repository.findAll();
         
        if(ClientList.size() > 0) {
            return ClientList;
        } else {
            return new ArrayList<Cliente>();
        }
    }
     
    public Cliente getClientById(Long id) throws RecordNotFoundException
    {
        Optional<Cliente> cliente = repository.findById(id);
         
        if(cliente.isPresent()) {
            return cliente.get();
        } else {
            throw new RecordNotFoundException("No se ha encontrado ningun id con :",id);
        }
    }
     
    public Cliente createOrUpdateCliente(Cliente entity) throws RecordNotFoundException
    {
    	    	
    	if(entity.getId()!=null)
    	{
    	  Optional<Cliente> cliente = repository.findById(entity.getId());
        
    	if(cliente.isPresent())
        {
            Cliente newEntity = cliente.get();
            newEntity.setId(entity.getId());
            newEntity.setNombre(entity.getNombre());
            newEntity.setInfo(entity.getInfo());
            newEntity.setNcoches(entity.getNcoches());
 
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
     
    public void deleteClienteById(Long id) throws RecordNotFoundException
    {
        Optional<Cliente> item = repository.findById(id);
         
        if(item.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No se ha encontrado ningun id con :",id);
        }
    }

    //PASO 2
    public List<Cliente> getItemByNOmbre(String title) {
        List<Cliente> itemList = repository.findByNombre(title);
        if(itemList.size() > 0) {
            return itemList;
        } else {
            return new ArrayList<Cliente>();
        }
    }
}
