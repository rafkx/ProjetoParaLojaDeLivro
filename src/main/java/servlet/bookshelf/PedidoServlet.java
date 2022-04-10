package servlet.bookshelf;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classe.bookshelf.Pedido;

@WebServlet("/PedidoServlet")
public class PedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList <Pedido> pedidos = new ArrayList<>();

    public PedidoServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		var acao = request.getParameter("acao");
		if (acao.equals("listar_pedido")) {
			request.setAttribute("pedidos", this.pedidos);
			request.getRequestDispatcher("/WEB-INF/views/lista_pedidos.jsp").forward(request, response);
			return;
		}
		if (acao.equals("editar")) {
			request.setAttribute("pedido", this.getPedidoById(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("/WEB-INF/views/pedido.jsp").forward(request, response);
			return;
		}
		if (acao.equals("remover")) {
			this.removerPedido(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("pedidos", this.pedidos);
			request.getRequestDispatcher("/WEB-INF/views/lista_pedidos.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		var nome = request.getParameter("nome");
		var end = request.getParameter("end");
		var book = request.getParameter("book");
		
		if (request.getParameter("id") == null) {
			var Pedido = new Pedido(getId(), nome,end,book);
			this.pedidos.add(Pedido);
			response.sendRedirect("http://localhost:8080/Bookshelf/PedidoServlet?acao=listar_pedido");
		} else {
			var pedidoId = Integer.parseInt(request.getParameter("id"));
			var Pedido = new Pedido (pedidoId, nome, end, book);
			this.atupedido(Pedido);
			response.sendRedirect("http://localhost:8080/Bookshelf/PedidoServlet?acao=listar_pedido");
		}
	}
	
	private void removerPedido(int id) {
		this.pedidos.remove(this.getPedidoById(id));
	}
	
	private void atupedido(Pedido pedido) {
		var indice = this.pedidos.indexOf(getPedidoById(pedido.getId()));
		this.pedidos.set(indice, pedido);
	}
	
	private Pedido getPedidoById(int id) {
		for (Pedido pedido : pedidos) {
			if (pedido.getId() == id) {
				return pedido;
			}
		}
		return null;
	}
	
	private int getId() {
		return this.pedidos.size() + 1; 
	}
}
