/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adalberto
 */
@WebServlet(name = "JurosComposto", urlPatterns = {"/juros-composto"})
public class JurosComposto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Juro Composto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form>");
            out.println("<fieldset>");
            out.println("<legend>Calculo de Juros Composto</legend>");
            out.println("Capital:\n"
                    + "<input type='number' name='c' step='0.01' style='margin-right: 1%'>");
            out.println("Taxa de Juros(%.a.m):\n"
                    + "<input type='number' name='j' step='0.0001' style='margin-right: 1%'>");
            out.println("Periodo(Meses):\n"
                    + "<input type='number' name='p' step='1' style='margin-right: 1%'>");
            out.println("<input type='submit' value='Calcular'>");
            out.println("</fieldset>");
            out.println("</form><br>");
            double c, j, p, m;
            p = 0; j = 0; m = 0;
            try{
               if(request.getParameter("c") != null || request.getParameter("j") != null || request.getParameter("p") != null) {
                   c = Double.parseDouble(request.getParameter("c"));
                   j = Double.parseDouble(request.getParameter("j"));
                   p = Double.parseDouble(request.getParameter("p"));
                   m = c;
                   
               }
            }
            catch(Exception Ex) {
                //MELHORAR TRATAMENTO DE ERRO
                out.println("<h2 style='color: red'>Dado(s) Inválido</h2>");
            }
            
            
            for(int i = 1; i <= p; i++) {
                if(i == 1)
                    out.println("<table border='1' width='80%' style='text-align:center; margin-left: 10%'><tr><th>Mês</th><th>Juros(R$)</th><th>Montante(R$)</th></tr>");
                out.println("<tr><td>"+ i +"</td><td>"+ new DecimalFormat("0.00").format(((j/100)*m)) +"</td><td>"+ new DecimalFormat("0.00").format(m + ((j/100)*m)) +"</td></tr>");
                m = m + ((j/100)*m);
                if(i == p)
                    out.println("</table>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
