package pe.edu.tecsup.tienda.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	private Long categorias_id;
//	
//	public Long getCategorias_id() {
//		return categorias_id;
//	}
//	public void setCategorias_id(Long categorias_id) {
//		this.categorias_id = categorias_id;
//	}
	
	@ManyToOne
	@JoinColumn(name="categorias_id")
	private Categoria categoria;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer stock;
	private String imagen_nombre;
	private String imagen_tipo;
	private Long imagen_tamanio;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creado;
	private Integer estado;
	
	public boolean isValidoImagenNombre() {
		
		if (this.imagen_nombre == null || "".equals(this.imagen_nombre.trim())) {
			return false;
		} else {
			return true;
		}
		
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", categoria=" + categoria + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", stock=" + stock + ", imagen_nombre=" + imagen_nombre + ", imagen_tipo="
				+ imagen_tipo + ", imagen_tamanio=" + imagen_tamanio + ", creado=" + creado + ", estado=" + estado + "]";
	}


}
