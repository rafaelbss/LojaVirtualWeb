package app.web.lv.main;

import java.util.List;

import app.web.lv.business.facade.UsuarioFacade;
import app.web.lv.business.model.Usuario;

public class TesteUsuario {

	public static void main(String[] args) {
		UsuarioFacade usuarioFacade = new UsuarioFacade();
		
		TesteUsuario.listarUsuarios(usuarioFacade);
		TesteUsuario.buscarUsuario(usuarioFacade);
	}
	
	@SuppressWarnings("unused")
	private static void adicionarUsuarios(UsuarioFacade usuarioFacade) {
		Usuario usuario = new Usuario();
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		
		System.out.printf("Adicionando usuário: %s\n", usuario);
		usuarioFacade.adiciona(usuario);
		
		usuario = new Usuario();
		usuario.setLogin("rafael");
		usuario.setSenha("rafael");
		
		System.out.printf("Adicionando usuário: %s\n", usuario);
		usuarioFacade.adiciona(usuario);
	}
	
	private static void listarUsuarios(UsuarioFacade usuarioFacade) {
		List<Usuario> usuarios = (List<Usuario>) usuarioFacade.listar();
		
		for(Usuario usuario : usuarios) {
			System.out.printf("Imprimindo usuário do banco de dados: [%d] %s\n", usuario.getId(), usuario);
		}
	}
	
	private static void buscarUsuario(UsuarioFacade usuarioFacade) {
		Usuario usuario = usuarioFacade.buscar(4l);
		
		System.out.printf("Usuário encontrado no banco de dados: [%d] %s\n", usuario.getId(), usuario);
	}
}
