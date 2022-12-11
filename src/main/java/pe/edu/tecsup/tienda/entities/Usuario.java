package pe.edu.tecsup.tienda.entities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 167872004852974767L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="roles_id")
	private Rol rol;
	
	private String email;
	
	private String password;
	
	private String nombres;
	
	private String apellidos;
	
	private String sexo;
	
	private Date fecnacimiento;
	
	private String telefono;
	
	private String direccion;
	
	private Integer estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFecnacimiento() {
		return fecnacimiento;
	}

	public void setFecnacimiento(Date fecnacimiento) {
		this.fecnacimiento = fecnacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", rol=" + rol + ", email=" + email + ", password=" + password + ", nombres="
				+ nombres + ", apellidos=" + apellidos + ", sexo=" + sexo + ", fecnacimiento=" + fecnacimiento
				+ ", telefono=" + telefono + ", direccion=" + direccion + ", estado=" + estado + "]";
	}

	@Override
	public List<Rol> getAuthorities() {
		List<Rol> authorities = new ArrayList<>();
		authorities.add(this.rol);
		return authorities;
	}

	@Override
	public String getUsername() {
		return this.email;	// Change username field
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;	// false: User account has expired
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;	// false: User account is locked
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;	// false: User credentials have expired
	}

	@Override
	public boolean isEnabled() {
		return this.estado != null && this.estado == 1;	// false: User is disabled
	}

}
