package py.edu.facitec.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;

import org.hibernate.annotations.Entity;
import org.springframework.stereotype.Repository;

import py.edu.facitec.model.Cliente;

@Repository //Indicamos a Spring que manejara datos
public class ClienteDAO extends DAOGenerico<Cliente> {
	
	public ClienteDAO(Class<Cliente> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext //contexto de Persistencia
	private EntityManager manager;

public void save(Cliente cliente){
	
	//Insertar un dato
	manager.persist(cliente);
}

@Override
protected EntityManager getEntityManager() {
	// TODO Auto-generated method stub
	return manager;
}
	
	

}
