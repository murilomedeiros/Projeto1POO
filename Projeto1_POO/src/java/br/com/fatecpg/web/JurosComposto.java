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
//

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
            out.println("<!DOCTYPE html><html lang='pt-br'> <head> <meta charset='utf-8'> <meta http-equiv='X-UA-Compatible' content='IE=edge'> <meta name='viewport' content='width=device-width, initial-scale=1'> <title>Calculadora Juros</title> <link rel='icon' href='res/images/calculator_46872.png'> <link href='res/styles/bootstrap.min.css' rel='stylesheet' type='text/css'/> <link href='res/styles/style.css' rel='stylesheet' type='text/css'/> </head> <body> <nav class='navbar navbar-fixed-top navbar-inverse navbar-transparent'> <div class='container'> <div class='navbar-header'> <button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#nav-bar'> <span class='sr-only'>alterar navegacao</span> <span class='icon-bar'></span> <span class='icon-bar'></span> <span class='icon-bar'></span> </button> <a href='/Projeto1_POO/Home' class='navbar-brand'> <img id='logo-img' src='res/images/calculator_46872.png' alt=''> </a> </div><div class='collapse navbar-collapse' id='nav-bar'> <ul class='nav navbar-nav navbar-right'> <li><a href='/Projeto1_POO/Home'>Home</a></li><li><a id=\"aboutLink\" href='#text-interestS'>Sobre</a></li><li><a id=\"calGo\" href='#containerJC'>Calculadora</a></li><li class='divisor' role='separator'></li><li><a href='/Projeto1_POO/juros-simples'>Juros Simples</a></li><li><a href='/Projeto1_POO/juros-composto'>Juros Compostos</a></li></ul> </div></div></nav> <section id='text-interestS'> <div id='calc' class='container-fluid'> <div id='calculatorS' class='col-md-12'> <h1 id='titleDi' class='whiteC textCenter' ></h1><br><h4 class='whiteC textCenter'><strong>Juros compostos são os juros de um determinado período somados ao capital para o cálculo de novos juros nos períodos seguintes.</strong> </h4><h4 class='whiteC textCenter'><strong>M: montante / C: capital / i: taxa de juros / t: tempo de aplicação.</strong></h4><br><br><br><h4 class='whiteC textCenter'><strong>Fórmula: M = C * (1 + i)^t</strong></h4><br><div style='margin-bottom:30px;' class='graficos col-md-7 col-md-offset-2' ><canvas id=\"myCharta\" ></canvas></div></div></div></section> <section id='containerJC'> <div class='container'> <div class='row container-equip'> <h2 class='text-center'>Calculadora de Juros Composto</h2> <hr class='bottom-line3'>");
            out.println("<form id='formC'class='form-inline'>");

            out.println("<div class='form-group'><label>Capital :</label>\n"
                    + "<input type='number' name='c' step='0.01'  class='form-control' placeholder='R$' autocomplete='off' required> </div>");

            out.println("<div class='form-group'>\n"
                    + "                            <label>Taxa de Juros :</label>\n"
                    + "<input type='number' class='form-control' placeholder='%.a.m' name='j' step='0.0001' autocomplete='off'> </div>");

            out.println("<div class='form-group'>\n"
                    + "                            <label>Período :</label>\n"
                    + "<input type='number' class='form-control' placeholder='Meses' name='p' step='1' autocomplete='off'>\n"
                    + "                        </div>");

            out.println("<input id='submit' type='submit' value='Calcular'><br><br><br><br>");

            out.println("</form>\n" +
"                </div>");
            double c, j, p, m;
            p = 0;
            j = 0;
            m = 0;
            try {
                if (request.getParameter("c") != null && request.getParameter("j") != null && request.getParameter("p") != null) {
                    c = Double.parseDouble(request.getParameter("c"));
                    j = Double.parseDouble(request.getParameter("j"));
                    p = Double.parseDouble(request.getParameter("p"));
                    m = c;
                    for (int i = 1; i <= p; i++) {
                        if (i == 1) {
                            out.println("<div class='row'>\n"
                                    + "                    <div class='col-md-12' ><table id='table-interestS' class='table table-hover table-condensed table-bordered table-striped blackCH'><thead><tr><th>Mês</th><th>Juros(R$)</th><th>Montante(R$)</th></tr></thead>");
                        }
                        out.println("<tbody><tr><td>" + i + "</td><td>" + new DecimalFormat("0.00").format(((j / 100) * m)) + "</td><td>" + new DecimalFormat("0.00").format(m + ((j / 100) * m)) + "</td></tr>");
                        m = m + ((j / 100) * m);
                        if (i == p) {
                            out.println("</tbody></table></div>\n"
                                    + "                </div>");
                        }
                    }
                }
            } catch (Exception Ex) {
                out.println("<h3 style='color: red'>Ocorreu um erro</h3>");
            }

           out.println("</div></section><div class='container-fluid' id='footer'> <div class='row' > <div class='col-md-12' id='black' style='; padding-left:5%; padding-right: 5%;'> <div class='row' style=''> <div class='col-md-4' style=''> <img style='width: 40px; height: 40px' src='res/images/LogoTransp.png' alt=''/> </div><div class='col-md-6' style='margin-right: -5px; padding-left: 0px;'> <ul class='nav'> <li><a href='/Projeto1_POO/Home'>Home</a></li><li class='divisor' role='separator'></li><li><a href='/Projeto1_POO/Home#team'>Equipe</a></li><li class='divisor' role='separator'></li><li><a href='/Projeto1_POO/juros-simples'>Juros Simples</a></li><li class='divisor' role='separator'></li><li><a href='/Projeto1_POO/juros-composto'>Juros Compostos</a></li></ul> </div></div><p class='text-center'>Copyright&copy; 2017 - Desenvolvido pela TGS</p></div></div></div><script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script><script src='res/scripts/Chart.min.js' type='text/javascript'></script> <script src='res/scripts/bootstrap.min.js' type='text/javascript'></script> <script type='text/javascript'> var $doc=$('html, body'); $('#aboutLink').click(function (){$doc.animate({scrollTop: $($.attr(this, 'href')).offset().top}, 600); return false;}); $('#calGo').click(function (){$doc.animate({scrollTop: $($.attr(this, 'href')).offset().top}, 600); return false;}); function typeWritter(texto, idElemento, tempo){var char=texto.split('').reverse(); var typer=setInterval(function (){if (!char.length) return clearInterval(typer); var next=char.pop(); document.getElementById(idElemento).innerHTML +=next;}, tempo);}typeWritter('Juros Compostos', 'titleDi', 100); </script><script>var ctx=document.getElementById('myCharta').getContext('2d'); var myCharta=new Chart(ctx,{type: 'line', data:{labels: ['0','1', '2', '3', '4', '6', '7'], datasets: [{label: 'Montante em R$', data: [1000.00,1100.00, 1210.00, 1331.00, 1464.10, 1610.51, 1771.56], backgroundColor: [ 'transparent'], borderColor: [ 'rgba(0,0,0,1)'], borderWidth: 2}]}, options:{scales:{yAxes: [{ticks:{beginAtZero: true}}]}}}); </script> </body></html>");
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
