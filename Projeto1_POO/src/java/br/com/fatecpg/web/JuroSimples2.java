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
 * @author muril
 */
@WebServlet(name = "JuroSimples2", urlPatterns = {"/juros-simples"})
public class JuroSimples2 extends HttpServlet {

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
            out.println("<html lang='pt-br'> <head> <meta charset='utf-8'> <meta http-equiv='X-UA-Compatible' content='IE=edge'> <meta name='viewport' content='width=device-width, initial-scale=1'> <title>Calculadora Juros</title> <link rel='icon' href='res/images/calculator_46872.png'> <link href='res/styles/bootstrap.min.css' rel='stylesheet' type='text/css'/> <link href='res/styles/style.css' rel='stylesheet' type='text/css'/> </head> <body> <nav class='navbar navbar-fixed-top navbar-inverse navbar-transparent'> <div class='container'> <div class='navbar-header'> <button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#nav-bar'> <span class='sr-only'>alterar navegacao</span> <span class='icon-bar'></span> <span class='icon-bar'></span> <span class='icon-bar'></span> </button> <a href='/Projeto1_POO/Home' class='navbar-brand'> <img id='logo-img' src='res/images/calculator_46872.png' alt=''> </a> </div><div class='collapse navbar-collapse' id='nav-bar'> <ul class='nav navbar-nav navbar-right'> <li><a href='/Projeto1_POO/Home'>Home</a></li><li><a id='aboutLink' href='#text-interestS'>Sobre</a></li><li><a id='calGo' href='#containerJ'>Calculadora</a></li><li class='divisor' role='separator'></li><li><a href='/Projeto1_POO/juros-simples'>Juros Simples</a></li><li><a href='/Projeto1_POO/juros-composto'>Juros Compostos</a></li></ul> </div></div></nav> <section id='text-interestS'> <div id='calc' class='container-fluid' > <div id='calculatorS' class='col-md-12' > <h1 id='titleDi' class='whiteC textCenter' ></h1><br><h3 class='whiteC textCenter'><strong>Na matemática financeira, os juros simples consistem num percentual calculado a partir de um valor inicial. Esse rendimento é aplicado sobre uma quantia de dinheiro emprestado, como um aluguel pelo empréstimo daquele dinheiro. M: montante / C: capital / i: taxa de juros / t: tempo de aplicação/ J=juros</strong></h3> <h4 class='whiteC textCenter'><strong>Fórmulas: J = C * i * t </strong></h4> <h4 class='whiteC textCenter'><strong>M = C + J</strong></h4> <div style='margin-top: 10px; display: block; height: 52%; width: 70%; background-color: white; color: black; border-radius: 10px;' class='graficos col-md-5 col-md-offset-2'><canvas id='myCharta'></canvas></div></div></div></section> <section id='containerJ' > <div class='container'> <div class='row container-equip' > <h2 class='text-center'>Calculadora de Juros Simples</h2> <hr class='bottom-line3'><br><br>");            
            out.println("<form id='formS' class='form-inline' >");
            out.println("<div style=' margin-left:-50px; width:120%;'><div class='form-group' >\n" +
"                            <label class=''>Capital :</label>"
                    + "<input type='number' class='form-control' placeholder='R$' autocomplete='off' name='c' step='0.01' min= 1 required>");
                        
            out.println("</div>\n" +
"                        <div class='form-group' >\n" +
"                            <label  class='' >Taxa de Juros :</label>"
                    + "<input type='number' class='form-control'  placeholder='%' autocomplete='off' name='i' step='0.0001' required>"
                    + "<select style='margin-left:5px' class='form-control' name='base_juros'> <option value='a.d'> ao dia</option>"
                    + "<option value='a.m'> ao mês</option>"
                    + "<option value='a.a'> ao ano</option> </select>");
            
            
            out.println("</div>\n" +
"                        <div class='form-group' >\n" +
"                            <label class=''>Período :</label>\n" +
"" 
                    + "<input type='number' class='form-control'placeholder='Dia/Mes/Ano' type='number' name='t' step='1' min=1 required>"
                    + "<select style='margin-left:5px' class='form-control' name='base_tempo'> <option value='Dias'> dia(s)</option>"
                    + "<option value='Meses'> meses</option>"
                    + "<option value='Ano'> ano</option> </select>"
                    + "");
                        
            
            
            out.println("</div><input  margin-top:0%;' id='submit' type='submit' value='Calcular'><br><br><br><br>");
            
            out.println("</div></form><br>");
            double c, j, t, i;
            String base_tempo=""; String base_juros="";
            t = 0; j = 0; i = 0;c=0;
            try{
               if(request.getParameter("c") != null && request.getParameter("i") != null && request.getParameter("t") != null) {
                   c = Double.parseDouble(request.getParameter("c"));
                   i = Double.parseDouble(request.getParameter("i"));
                   t = Double.parseDouble(request.getParameter("t"));
                   j = c;
                   base_tempo = request.getParameter("base_tempo");
                   base_juros = request.getParameter("base_juros");
                   
               }    
            }
            catch(Exception Ex) {
                out.println("<h3 class='textCenter' style='color: red'>Ocorreu um erro</h3>");
            }
          
                switch(base_tempo){
                    case "Dias":
                        if(base_juros.equals("a.m")){
                            i = i/30;
                        
                        }else if(base_juros.equals("a.a")){
                            i=i/360;
                            
                        }
                        break;
                    case "Meses":
                        if(base_juros.equals("a.d")){
                            t=30*t;
                            
                        }else if(base_juros.equals("a.a")){
                            t=t/12;
                            
                        }
                        break;
                    case"Ano":
                        
                        if(base_juros.equals("a.d")){
                            t=t*360;
                            
                        }
                        if(base_juros.equals("a.m")){
                            t=t*12;
                                                       
                        }
                        break;
                    
            }
            i= i/100;
            j=c*i*t;
            out.println("<h3 class='textCenter'>Valor Total de juros Simples ("+ base_juros +") : R$ " +  new DecimalFormat("0.00").format(j) +  "</h3>");
            c=c+j;
            out.println("<h3 class='textCenter'>Valor Final: R$ " + new DecimalFormat("0.00").format(c) + "</h3>");
            out.println(" </div></div></section> <div class='container-fluid' id='footer'> <div class='row' > <div class='col-md-12' id='black' style='; padding-left:5%; padding-right: 5%;'> <div class='row' style=''> <div class='col-md-4' style=''> <img style='width: 40px; height: 40px' src='res/images/LogoTransp.png' alt=''/> </div><div class='col-md-6' style='margin-right: -5px; padding-left: 0px;'> <ul class='nav'> <li><a href='/Projeto1_POO/Home'>Home</a></li><li class='divisor' role='separator'></li><li><a href='/Projeto1_POO/Home#team'>Equipe</a></li><li class='divisor' role='separator'></li><li><a href='/Projeto1_POO/juros-simples'>Juros Simples</a></li><li class='divisor' role='separator'></li><li><a href='/Projeto1_POO/juros-composto'>Juros Compostos</a></li></ul> </div></div><p class='text-center'>Copyright&copy; 2017 - Desenvolvido pela TGS</p></div></div></div><script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script> <script src='res/scripts/Chart.min.js' type='text/javascript'></script> <script src='res/scripts/bootstrap.min.js' type='text/javascript'></script> <script type='text/javascript'> var $doc=$('html, body'); $('#calGo').click(function (){$doc.animate({scrollTop: $($.attr(this, 'href')).offset().top}, 600); return false;}); $('#aboutLink').click(function (){$doc.animate({scrollTop: $($.attr(this, 'href')).offset().top}, 600); return false;}); function typeWritter(texto, idElemento, tempo){var char=texto.split('').reverse(); var typer=setInterval(function (){if (!char.length) return clearInterval(typer); var next=char.pop(); document.getElementById(idElemento).innerHTML +=next;}, tempo);}typeWritter('Juros Simples', 'titleDi', 100); </script> <script>var ctx=document.getElementById('myCharta').getContext('2d'); var myCharta=new Chart(ctx,{type: 'line', data:{labels: ['0','1', '2', '3', '4', '6', '7'], datasets: [{label: 'Montante em R$', data: [1000.00, 1100.00, 1200.00, 1300.00, 1400.00, 1500.00, 1600.00], backgroundColor: [ 'transparent'], borderColor: [ 'rgba(0,0,0,1)'], borderWidth: 2}]}, options:{scales:{yAxes: [{ticks:{beginAtZero: true}}]}}}); </script> </body></html>");
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
