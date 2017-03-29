package app.web.lv.persistence.dao;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import app.web.lv.business.model.Usuario;

public class UsuarioDAO {
	
	private Session session;
	private Transaction transaction;
	
	public UsuarioDAO() {
		this.criarSessao();
	}
	
	public void adiciona(Usuario usuario) {
		this.abrirTransacao();
		
		this.session.save(usuario);
		
		this.encerrarTransacao();
	}
	
	public void remover(Usuario usuario) {
		this.abrirTransacao();
		
		this.session.delete(usuario);
		
		this.encerrarTransacao();
	}
	
	public void atualizar(Usuario usuario) {
		this.abrirTransacao();
		
		this.session.merge(usuario);
		
		this.encerrarTransacao();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Usuario> listar() {
		return this.session.createCriteria(Usuario.class).list();
	}
	
	public Usuario buscar(Long id) {
		return (Usuario) session.load(Usuario.class, id);
	}
	
	private void criarSessao() {
		Configuration config = new AnnotationConfiguration();
		config.configure();
		
		SessionFactory factory = config.buildSessionFactory();
		this.session = factory.openSession();
	}
	
	private void abrirTransacao() {
		this.transaction = this.session.beginTransaction();
	}
	
	private void encerrarTransacao() {
		this.transaction.commit();
	}
}
