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


@WebServlet(name = "JurosSimples", urlPatterns = {"/JurosSimples"})
public class JurosSimples extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JurosSimples</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Juros Simples </h1>");
            
            out.println("<form>");
            out.println("Capital:\n"
                    + "<input type='number' name='c' step='0.01' min= 1 style='margin-right: 1%' required><br/><br/>");
                        
            out.println("Taxa de Juros:\n"
                    + "<input type='number' name='i' step='0.0001' style='margin-right: 1%' required>"
                    + "<select name='base_juros'> <option value='a.d'> ao dia</option>"
                    + "<option value='a.m'> ao mês</option>"
                    + "<option value='a.a'> ao ano</option> </select><br/>"
                    +"<br/>");
            
            
            out.println("Periodo:\n" 
                    + "<input type='number' name='t' step='1' min=1 style='margin-right: 1%' required>"
                    + "<select name='base_tempo'> <option value='Dias'> Dias</option>"
                    + "<option value='Meses'> Meses</option>"
                    + "<option value='Ano'> Ano</option> </select><br/><br/>");
                        
            
            
            out.println("<input type='submit' value='Calcular'><br/>");
            
            out.println("</form><br>");
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
                out.println("<h3 style='color: red'>Ocorreu um erro</h3>");
                out.println("<h2><a href='index.html>Voltar </a></h2>'");
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
            out.println("<h3 style='color: green'>Valor Total de juros Simples ("+ base_juros +") :" +  new DecimalFormat("0.00").format(j) + "</h3>");
            c=c+j;
            out.println("<h3 style='color: green'>Valor Final: " + new DecimalFormat("0.00").format(c) + "</h3>");
            out.println("</body>");
            out.println("</html>");
       
        }
    }

}

