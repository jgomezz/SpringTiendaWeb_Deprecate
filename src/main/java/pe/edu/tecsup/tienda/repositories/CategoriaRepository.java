package pe.edu.tecsup.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.tecsup.tienda.entities.Categoria;

public interface CategoriaRepository 
		extends JpaRepository<Categoria, Long>{


}
