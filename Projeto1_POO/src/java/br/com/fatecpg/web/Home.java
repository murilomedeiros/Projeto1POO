/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author murilo
 */
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends HttpServlet {

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
            out.println("<!DOCTYPE html><html lang='pt-br'> <head> <meta charset='utf-8'> <meta http-equiv='X-UA-Compatible' content='IE=edge'> <meta name='viewport' content='width=device-width, initial-scale=1'> <title>Calculadora Juros</title> <link rel='icon' href='res/images/calculator_46872.png'> <link href='res/styles/bootstrap.min.css' rel='stylesheet' type='text/css'/> <link href='res/styles/style.css' rel='stylesheet' type='text/css'/> </head> <body> <nav class='navbar navbar-fixed-top navbar-inverse navbar-transparent'> <div class='container'> <div class='navbar-header'> <button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#nav-bar'> <span class='sr-only'>alterar navegacao</span> <span class='icon-bar'></span> <span class='icon-bar'></span> <span class='icon-bar'></span> </button> <a href='/Projeto1_POO/Home' class='navbar-brand'> <img id='logo-img' src='res/images/calculator_46872.png' alt=''> </a> </div><div class='collapse navbar-collapse' id='nav-bar'> <ul class='nav navbar-nav navbar-right'> <li><a id='homeLink' href='#text-cover'>Home</a></li><li><a id='teamLink' href='#team'>Equipe</a></li><li class='divisor' role='separator'></li><li><a href='/Projeto1_POO/JuroSimples2'>Juros Simples</a></li><li><a href='/Projeto1_POO/juros-composto'>Juros Compostos</a></li></ul> </div></div></nav> <section id='text-cover'> <div class='container cover'> <div class='row'> <div class='col-md-12' > <div class='text-cover'> <h1 id='titleDi'></h1><br><h3>Essa aplicacao WEB tem como finalidade calcular o montante de uma aplicacao inicial tanto aplicando em juros simples quanto juros composto.</h3> <a href='/Projeto1_POO/JuroSimples2' id='btn-simple' class='btn btn-default btn-custom btn-lg'>Calcular juros simples</a> <a href='/Projeto1_POO/juros-composto' id='btn-compound' class='btn btn-warning btn-custom btn-lg'>Calcular juros Composto</a> </div></div></div></div></section> <section id='team'> <div class='container'> <div class='row container-equip'> <h2 class='text-center' style='color: grey;'>Equipe</h2> <hr class='bottom-line3'><br><br><div class='col-md-3 member-team'> <img src='res/images/member1.jpg' alt=''/> <h2>Adalberto Junior</h2> <p class='title'>CIO</p><p>Responsavel desenvolvimento da logica do juros composto (Back-end).</p><p>Some text that describes .</p><a href='https://www.facebook.com/adalberto.rodriguesteixeirajunior' target='_blank'><img class='icons' src='res/images/facebook.png' alt=''/></a> <a href='https://www.linkedin.com/in/adalberto-j-597249114' target='_blank'><img class='icons' src='res/images/linkedin.png' alt=''/></a> <a href='https://github.com/AdalbertoRodrigues' target='_blank'><img class='icons' src='res/images/github.png' alt=''/></a> </div><div class='col-md-3 member-team' > <img src='res/images/member3.jpg' alt=''/> <h2>Diogo Pacheco</h2> <p class='title'>CTO</p><p>Responsavel desenvolvimento da logica do juros simples (Back-end).</p><p>diogopereira1992@outlook.com</p><a href='https://www.facebook.com/diogo.pacheco.184' target='_blank'><img class='icons' src='res/images/facebook.png' alt=''/></a> <a href='https://github.com/DiogoPachecoPereira' target='_blank'><img class='icons' src='res/images/github.png' alt=''/></a> </div><div class='col-md-3 member-team'> <img src='res/images/member2.jpg' alt=''/> <h2>Murilo Medeiros</h2> <p class='title'>CEO & Founder</p><p>Responsavel desenvolvimento da aparencia da interface (Front-end).</p><p>murilo_medeiros98@hotmail.com</p><a href='https://www.facebook.com/murilo.meedeiros' target='_blank'><img class='icons' src='res/images/facebook.png' alt=''/></a> <a href='https://www.linkedin.com/in/murilo-medeiros-630219135/' target='_blank'><img class='icons' src='res/images/linkedin.png' alt=''/></a> <a href='https://github.com/murilomedeiros' target='_blank'><img class='icons' src='res/images/github.png' alt=''/></a> </div></div></div></section> <div class='container-fluid' id='footer'> <div class='row' > <div class='col-md-12' id='black' style=' padding-left:5%; padding-right: 5%;'> <div class='row' > <div class='col-md-4'> <img style='width: 40px; height: 40px' src='res/images/LogoTransp.png' alt=''/> </div><div class='col-md-6' style='margin-right: -5px; padding-left: 0px;'> <ul class='nav'> <li><a href='index.html'>Home</a></li><li class='divisor' role='separator'></li><li><a href='index.html#team'>Equipe</a></li><li class='divisor' role='separator'></li><li><a href='simples.html'>Juros Simples</a></li><li class='divisor' role='separator'></li><li><a href='/Projeto1_POO/juros-composto'>Juros Compostos</a></li></ul> </div></div><p class='text-center'>Copyright&copy; 2017 - Desenvolvido pela TGS</p></div></div></div><script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script> <script src='res/scripts/jquery-3.2.1.min.js' type='text/javascript'></script> <script src='res/scripts/bootstrap.min.js' type='text/javascript'></script> <script type='text/javascript'> var $doc=$('html, body'); $('#teamLink').click(function (){$doc.animate({scrollTop: $($.attr(this, 'href')).offset().top}, 600); return false;}); $('#homeLink').click(function (){$doc.animate({scrollTop: $($.attr(this, 'href')).offset().top}, 600); return false;}); function typeWritter(texto, idElemento, tempo){var char=texto.split('').reverse(); var typer=setInterval(function (){if (!char.length) return clearInterval(typer); var next=char.pop(); document.getElementById(idElemento).innerHTML +=next;}, tempo);}typeWritter('Calculadora de Juros', 'titleDi', 100); </script> </body></html>");
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
