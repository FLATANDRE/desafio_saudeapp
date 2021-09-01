package com.saude.servlet;

import com.saude.dao.RegrasAutorizacaoDAO;
import com.saude.dao.SolicitacaoAutorizacaoDAO;
import com.saude.entity.RegraAutorizacao;
import com.saude.entity.SolicitacaoAutorizacao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "solicitacaoAutorizacao", urlPatterns = {"/solicitacao-autorizacao","/solicitacao-autorizacao/new"} )
public class SolicitacaoAutorizacaoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/solicitacao-autorizacao/new":
                    novaSolicitacao(request, response);
                    break;
                default:
                    listaSolicitacao(request, response);
                    break;
            }
        }catch (ServletException|IOException ex) {
            throw new ServletException(ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
        int idProcedimento = Integer. parseInt(request.getParameter("idProcedimento"));
        int idade = Integer.parseInt(request.getParameter("idade"));
        char sexo = request.getParameter("sexo").toCharArray()[0];
        RegraAutorizacao regra = RegrasAutorizacaoDAO.getInstance().getRegraValido(idProcedimento,idade,sexo);
        String url = "/solicitacao-autorizacao/form-solicitacao.jsp";

        if (Objects.isNull(regra)) {
            request.setAttribute("erro", "Não existe uma regra disponível para a solicitação.");

        } else if (regra.isPermitido()) {
            System.out.println("Regra encontrada e valida. Salvando registro");
            SolicitacaoAutorizacao solicitacaoAutorizacao =
                    SolicitacaoAutorizacao.builder()
                    .idProcedimento(idProcedimento)
                    .idade(idade)
                    .sexo(sexo)
                    .build();

            SolicitacaoAutorizacaoDAO.getInstance().save(solicitacaoAutorizacao);
            request.setAttribute("sucesso", "Solicitação cadastrada com sucesso!");
            listaSolicitacao(request, response);

        } else {
            request.setAttribute("erro", "Não foi possível realizar o cadastro da solicitação, devido a regra N° " + regra.getIdRegra());
        }


        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    private void novaSolicitacao(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = "/solicitacao-autorizacao/form-solicitacao.jsp";
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    private void listaSolicitacao(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<SolicitacaoAutorizacao> listaSolicitacao = SolicitacaoAutorizacaoDAO.getInstance().findAll();
        request.setAttribute("listaSolicitacao", listaSolicitacao);

        String url = "/solicitacao-autorizacao/lista-solicitacao.jsp";
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    public void destroy() {
    }
}
