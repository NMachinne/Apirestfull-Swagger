package apireftfull.ies.apirestfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apireftfull.ies.apirestfull.exceptions.RecordNotFoundException;
import apireftfull.ies.apirestfull.model.Cliente;
import apireftfull.ies.apirestfull.services.ClienteService;

import org.springframework.web.bind.annotation.RequestBody;
 
//https://techblogstation.com/spring-boot/spring-boot-mysql-hibernate/

@RestController
@RequestMapping("/cliente")
public class ClienteController
{
    @Autowired
    ClienteService service;
 
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> list = service.getAllClientes();
 
        return new ResponseEntity<List<Cliente>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientesById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	Cliente entity = service.getClientById(id);
 
        return new ResponseEntity<Cliente>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    //PASO2
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Cliente>> getClienteByNombre(@PathVariable("nombre") String title)
                                                    throws RecordNotFoundException {
    	List<Cliente> list  = service.getItemByNOmbre(title);
 
        return new ResponseEntity<List<Cliente>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
   @PostMapping
    public ResponseEntity<Cliente> createOrUpdateCliente(@RequestBody Cliente myItem)
                                                    throws RecordNotFoundException {
    	Cliente updated = service.createOrUpdateCliente(myItem);
        return new ResponseEntity<Cliente>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteClienteById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteClienteById(id);
        return HttpStatus.OK;
    }
 
}
