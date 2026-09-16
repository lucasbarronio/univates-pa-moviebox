/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.moviebox.controller;

import br.univates.moviebox.models.Filme;
import java.util.ArrayList;
import br.univates.moviebox.models.DAO.FilmesDAO;
import br.univates.moviebox.utils.CONTROLLER_I;

/**
 *
 * @author mateus
 */
public class FilmesController implements CONTROLLER_I<Filme> {

    private FilmesDAO filmesDAO = new FilmesDAO();


    @Override
    public boolean salvar(Filme o) {
        try {
            filmesDAO.salvar(o);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public boolean editar(Filme o) {
        try {
            filmesDAO.editar(o);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }

    }

    @Override
    public boolean excluir(int codigo) {
        try {
            filmesDAO.excluir(codigo);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public Filme recuperaUm(int codigo) {
        try {
            return filmesDAO.recuperaUm(codigo);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    @Override
    public ArrayList<Filme> recuperarTodos(String criterio) {
        try {
            return filmesDAO.recuperarTodos(criterio);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }


}
