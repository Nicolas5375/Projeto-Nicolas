package controle.servlet;

import modelo.dao.usuario.UsuarioDao;
import modelo.dao.usuario.UsuarioDaoImpl;  // se sua implementação se chama assim
import modelo.entidade.usuario.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;


//@WebServlet(urlPatterns = {"/cadastro-usuario","/inserir-usuario","/login-usuario","/login","/homepage","/perfil-usuario"})
@WebServlet("/")
public class UsuarioServlet extends HttpServlet {
	
//	private static final long serialVersionUID = 1L;
	private UsuarioDao dao;

	public void init() {
		dao = new UsuarioDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
	

		try {
			
			switch (action) {
			
			case "/novo-usuario":
				mostrarTelaCadastroUsuario(request, response);
				break;
				
			case "/inserir-usuario":
				inserirUsuario(request, response);
				break;

			case "/login-usuario":
				mostrarTelaLoginUsuario(request, response);
				break;
				
			/*case"/login":	//tá certo isso arnaldo?
				loginUsuario(request, response);
				break;
				*/
			case "/homepage":
				mostrarHomepage(request, response);
				break;

			case "/perfil-usuario":
				mostrarTelaPerfilUsuario(request, response);
				break;

				/*
			case "/cadastro-emblema":
				mostrarTelaCadastroEmblema(request, response);
				break;
				
			case "/cadastro-animal":
				mostrarCadastroAnimal(request, response);
				break;
				
			case "/inserir-animal":
				inserirAnimal(request, response);
				break;
				
			case "/perfil-animal":
				mostrarTelaPerfilAnimal(request, response);
				break;
				
			case "/cadastro-evento":
				mostrarCadastroEvento(request, response);
				break;
				
			case "/inserir-evento":
				inserirEvento(request, response);
				break;
				
			case "/listar-animais":
				listarAnimaisCadastrados(request, response);
				break;
				*/
				
			default:
				mostrarTelaErro404(request, response);
				break;
			
			
				
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	
	
	private void mostrarTelaCadastroUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("novo-usuario.jsp");
		dispatcher.forward(request, response);
	}

	//ver esse com o professor
	private void inserirUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		/*
		String foto = request.getParameter("foto");
		
		//isso é o contato
		String telefone = request.getParameter("telefone");
		String instagram = request.getParameter("instagram");
		
		//isso é o endereço
		String logradouro= request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String complemento = request.getParameter("complemento");		
		String cep = request.getParameter("cep");

		Long id = ;
		
		dao.inserirFoto(new Foto(id, foto));
		dao.inserirEndereco(new Endereco(id, logradouro, numero, bairro, cidade, estado, complemento, cep));
		dao.inserirContato(new Contato(id, email, telefone, instagram));
		
		 */
		dao.inserirUsuario(new Usuario(nome, sobrenome, email, senha));
		response.sendRedirect("homepage");
		

	}		
	
	private void mostrarTelaLoginUsuario(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login-usuario.jsp");
		dispatcher.forward(request, response);
	
	}

	/*
	private void loginUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = dao.buscarUsuarioPorEmailESenha(email, senha);

		if (usuario != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			response.sendRedirect("homepage");
		} else {
			request.setAttribute("erro", "Email ou senha inválidos.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login-usuario.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	*/
	
	private void mostrarHomepage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarTelaPerfilUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("perfil-usuario.jsp");
		dispatcher.forward(request, response);
	}
		
	private void mostrarTelaCadastroEmblema(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro-emblema.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarTelaErro404(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("erro404.jsp");
		dispatcher.forward(request, response);
	}
	
	/*			
	priva	te void listarAnimaisCadastrados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Animal> animais = dao.recuperarAnimais();
		request.setAttribute("animais", animais);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-animais.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroAnimal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro-animal.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarCadastroEvento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro-evento.jsp");
		dispatcher.forward(request, response);
	}
	
	//ver esse com o professor
	private void inserirAnimal(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		
		//especia raça cor porte
		String especie = request.getParameter("especie");
		String raca = request.getParameter("raca");
		String cor = request.getParameter("cor");
		String porte = request.getParameter("porte");
		LocalDate dataCadastro = LocalDate.parse(request.getParameter("dataCadastro"));
		
		
		String foto = request.getParameter("foto");
		
		//isso é o endereço
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String complemento = request.getParameter("complemento");		
		String cep = request.getParameter("cep");


		dao.inserirAnimal(new Animal(especie, raca, cor, porte, dataCadastro));
		dao.inserirFoto(new Foto(foto));
		dao.inserirEndereco(new Endereco(logradouro, numero, bairro, cidade, estado, complemento, cep));

		

		response.sendRedirect("homepage");
		

	}	
	
	//ver esse com o professor
	private void inserirEvento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		
		int animalId = Integer.parseInt(request.getParameter("animal-id"));

		
		String tipo = request.getParameter("tipo");
		String descricao = request.getParameter("descricao");
		LocalDate dataEvento = LocalDate.parse(request.getParameter("dataEvento"));
		
		String foto = request.getParameter("foto");
		
		//isso é o endereço
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String complemento = request.getParameter("complemento");
		String cep = request.getParameter("cep");
		

		dao.inserirEvento(new Evento(animalId, tipo, descricao, dataEvento));
		dao.inserirFoto(new Foto(foto));
		dao.inserirEndereco(new Endereco(logradouro, numero, bairro, cidade, estado, complemento, cep));
		
		

		response.sendRedirect("perfil-animal?id=" + animalId);
	}

	
	private void mostrarTelaPerfilAnimal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("perfil-animal.jsp");
		dispatcher.forward(request, response);
	}

	*/


}