import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoContato {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public DaoContato() { //metodo q far� a conex�o com o hibernate
		emf = Persistence.createEntityManagerFactory("JPAPU");
		em = emf.createEntityManager();
	}
	
	public void salvar(Contato contato) {
		em.getTransaction().begin();
		em.persist(contato);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public Contato pegarUm(long id) {
		return em.find(Contato.class, id);
	}

	public boolean update(Contato contato) {		
		/*Contato contatoVindoDoBanco = em.find(Contato.class, contato.getId());
		contatoVindoDoBanco.setNome(contato.getNome());
		contatoVindoDoBanco.setEmail(contato.getEmail());
		contatoVindoDoBanco.setCelular(contato.getCelular());*/
		
		em.getTransaction().begin();
		em.merge(contato);
		em.getTransaction().commit();
		em.close();
		
		return true;
	}
	
}
