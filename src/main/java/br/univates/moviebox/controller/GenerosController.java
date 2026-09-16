/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.moviebox.controller;

import br.univates.moviebox.models.Genero;
import java.util.ArrayList;
import br.univates.moviebox.models.DAO.GenerosDAO;
import br.univates.moviebox.utils.CONTROLLER_I;

/**
 *
 * @author mateus
 */
public class GenerosController implements CONTROLLER_I<Genero> {

    private GenerosDAO generosDAO = new GenerosDAO();


    @Override
    public boolean salvar(Genero o) {
        try {
            generosDAO.salvar(o);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public boolean editar(Genero o) {
        try {
            generosDAO.editar(o);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }

    }

    @Override
    public boolean excluir(int codigo) {
        try {
            generosDAO.excluir(codigo);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public Genero recuperaUm(int codigo) {
        try {
            return generosDAO.recuperaUm(codigo);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    @Override
    public ArrayList<Genero> recuperarTodos(String criterio) {
        try {
            return generosDAO.recuperarTodos(criterio);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }


}
