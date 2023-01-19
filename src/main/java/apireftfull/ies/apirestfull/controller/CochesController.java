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
import apireftfull.ies.apirestfull.model.Coches;
import apireftfull.ies.apirestfull.services.CochesService;

import org.springframework.web.bind.annotation.RequestBody;
 
//https://techblogstation.com/spring-boot/spring-boot-mysql-hibernate/

@RestController
@RequestMapping("/coches")
public class CochesController
{
    @Autowired
    CochesService service;
 
    @GetMapping
    public ResponseEntity<List<Coches>> getAllCoches() {
        List<Coches> list = service.getAllItems();
 
        return new ResponseEntity<List<Coches>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Coches> getCochesById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	Coches entity = service.getCochesById(id);
 
        return new ResponseEntity<Coches>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    //PASO2
    @GetMapping("/search/{marca}")
    public ResponseEntity<List<Coches>> getItemByTitle(@PathVariable("title") String title)
                                                    throws RecordNotFoundException {
    	List<Coches> list  = service.getCochesByMarca(title);
 
        return new ResponseEntity<List<Coches>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
   @PostMapping
    public ResponseEntity<Coches> createOrUpdateCoches(@RequestBody Coches myItem)
                                                    throws RecordNotFoundException {
	   Coches updated = service.createOrUpdateCoches(myItem);
        return new ResponseEntity<Coches>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteItemById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteCochesById(id);
        return HttpStatus.OK;
    }
 
}
