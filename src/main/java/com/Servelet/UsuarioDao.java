package com.Servelet;

public interface UsuarioDao {
	
	void inserirUsuario(Usuario usuario);

	void deletarUsuario(Usuario usuario);

	void atualizarNomeUsuario(Usuario usuario, String novoNome);

	void atualizarEmailUsuario(Usuario usuario, String novoEmail);

	void atualizarSobrenomeUsuario(Usuario usuario, String novoSobrenome);

	void atualizarSenhaUsuario(Usuario usuario, String novaSenha);

}
