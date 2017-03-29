package app.web.lv.business.facade;

import java.util.Collection;

import app.web.lv.business.model.Usuario;
import app.web.lv.persistence.dao.UsuarioDAO;

public class UsuarioFacade {
	
	private UsuarioDAO usuarioDAO;
	
	public UsuarioFacade() {
		this.usuarioDAO = new UsuarioDAO();
	}
	
	public void adiciona(Usuario usuario) {
		this.usuarioDAO.adiciona(usuario);
	}
	
	public void remover(Usuario usuario) {
		this.usuarioDAO.remover(usuario);
	}
	
	public void atualizar(Usuario usuario) {
		this.usuarioDAO.remover(usuario);
	}
	
	public Collection<Usuario> listar() {
		return this.usuarioDAO.listar();
	}
	
	public Usuario buscar(Long id) {
		return this.usuarioDAO.buscar(id);
	}
}
