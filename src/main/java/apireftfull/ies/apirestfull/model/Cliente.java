package apireftfull.ies.apirestfull.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "nombre", length = 128, nullable = false)
	private String nombre;

	@Column(name = "info", length = 256)
	private String info;
	
	@OneToMany
	@Column(name = "ncoches")
	private List<Coches> ncoches;
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<Coches> getNcoches() {
		return ncoches;
	}

	public void setNcoches(List<Coches> ncoches) {
		this.ncoches = ncoches;
	}
	
	

}
