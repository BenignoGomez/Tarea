package py.edu.facitec.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Anotaciones @
@Entity //Indicamos que se tratara de una tabla

public class Cliente {
	
	@Id //Indicamos que se trata de la clave primaria
	@GeneratedValue //Genera automaticamente el codigo
	private Integer id;
	private String nombre;
	private String correo;
	
	//Relacion de uno para muchos
	//Relacion bidireccional con mappedby
	//objeto cliente dentro de pedido
	@OneToMany(mappedBy="cliente")
	private List<Pedido>pedidos;
	public Cliente() {
		id=0;
		nombre="";
		correo="";
		
	}
	public Integer getId() {
		return id;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
