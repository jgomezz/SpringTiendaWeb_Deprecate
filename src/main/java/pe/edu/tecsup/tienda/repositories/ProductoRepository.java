package pe.edu.tecsup.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.tecsup.tienda.entities.Producto;

public interface ProductoRepository 
		extends JpaRepository<Producto, Long>{

	
}
