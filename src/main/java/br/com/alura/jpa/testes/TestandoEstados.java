package br.com.alura.jpa.testes;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {
	public static void main(String[] args) {
		//Transient
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setAgencia(46662);
		conta.setNumero(56546);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// Transisent -> Managed
		em.persist(conta);
		
		// Manager -> Removed
		em.remove(conta);
		
		em.getTransaction().commit();
	}
}
