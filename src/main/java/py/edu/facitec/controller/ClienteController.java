package py.edu.facitec.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.edu.facitec.dao.ClienteDAO;
import py.edu.facitec.model.Cliente;

@Transactional //Manejara Datos el controller
@Controller
public class ClienteController {
	
	@Autowired //inicializa el objeto dao
	//atravez de la inyeccion de dependencia
	private ClienteDAO dao;
					//url ubicada en el action del formulario
	@RequestMapping("/clientes")
	public String registrar(Cliente cliente){
		
		System.out.println("Cliente: "+cliente);
		
			dao.guardar(cliente);
			
		//carpeta   pagina.html
		return "view/cliente/ok";
	}

	
}
