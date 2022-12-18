package pe.edu.tecsup.tienda.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private Integer orden;

	@OneToMany(mappedBy="categoria")
	private List<Producto> productos = new ArrayList<Producto>();

	// add toString()
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", orden=" + orden + "]";
	}
	
}
