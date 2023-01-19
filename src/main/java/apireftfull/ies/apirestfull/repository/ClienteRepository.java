package apireftfull.ies.apirestfull.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apireftfull.ies.apirestfull.model.Cliente;
 
@Repository
public interface ClienteRepository
        extends JpaRepository<Cliente, Long> {

    //PASO2
    //https://www.baeldung.com/spring-data-jpa-query
    /*@Query(
  value = "SELECT * FROM items u WHERE u.title=?1", 
  nativeQuery = true)*/
    @Query(
  value = "SELECT * FROM cliente u WHERE u.nombre LIKE %?1%", 
  nativeQuery = true)
    public List<Cliente> findByNombre(String nombre);
 
}
