package com.saude.servlet;

import com.saude.entity.RegraAutorizacao;
import com.saude.dao.RegrasAutorizacaoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "regraAutorizacao", value = "/regra-autorizacao")
public class RegrasAutorizacaoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String action = request.getServletPath();

        switch (action) {
            default:
                listaRegras(request, response);
                break;
        }
    }

    private void listaRegras(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<RegraAutorizacao> listaRegras = RegrasAutorizacaoDAO.getInstance().findAll();
        request.setAttribute("listaRegras", listaRegras);

        System.out.println("Qtd lista " + listaRegras!=null ? listaRegras.size() : "0");

        String url = "/regra-autorizacao/lista-regra.jsp";
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}
