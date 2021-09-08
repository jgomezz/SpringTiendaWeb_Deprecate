package pe.edu.tecsup.tienda.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.services.CategoriaService;
import pe.edu.tecsup.tienda.services.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	private Logger logger = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ProductoService productoService;

	@Value("${app.storage.path}")
    private String STORAGEPATH;

	
	@GetMapping("")
	public String index(Model model) throws Exception {
		logger.info("call index()");
		
		List<Producto> productos = productoService.findAll();
		model.addAttribute("productos", productos);
		
		return "productos/index";
	}

	@GetMapping("/create")
	public String create(Model model) throws Exception {
		logger.info("call create()");
		
		List<Categoria> categorias = categoriaService.findAll();
		model.addAttribute("categorias", categorias);
		
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		
		return "productos/create";
	}
	
	@PostMapping("/store")
	public String store(@ModelAttribute("producto") Producto producto, Errors errors, 
			@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttrs) throws Exception{
		logger.info("call store(producto: " + producto + ")");
		
		if(file != null && !file.isEmpty()) {
			String filename = System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			producto.setImagen_nombre(filename);
			if(Files.notExists(Paths.get(STORAGEPATH))){
		        Files.createDirectories(Paths.get(STORAGEPATH));
		    }
			Files.copy(file.getInputStream(), Paths.get(STORAGEPATH).resolve(filename), StandardCopyOption.REPLACE_EXISTING);
		}
		
		producto.setCreado(new Date());
		producto.setEstado(1);
		
		productoService.save(producto);
		
		redirectAttrs.addFlashAttribute("message", "Registro guardado correctamente");
		
		return "redirect:/productos/";
	}
	


}
