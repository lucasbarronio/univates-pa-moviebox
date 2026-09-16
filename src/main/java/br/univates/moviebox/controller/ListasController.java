/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.moviebox.controller;

import br.univates.moviebox.models.Lista;
import java.util.ArrayList;
import br.univates.moviebox.models.DAO.ListasDAO;
import br.univates.moviebox.utils.CONTROLLER_I;

/**
 *
 * @author mateus
 */
public class ListasController implements CONTROLLER_I<Lista> {

    private ListasDAO listasDAO = new ListasDAO();


    @Override
    public boolean salvar(Lista o) {
        try {
            listasDAO.salvar(o);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public boolean editar(Lista o) {
        try {
            listasDAO.editar(o);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }

    }

    @Override
    public boolean excluir(int codigo) {
        try {
            listasDAO.excluir(codigo);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public Lista recuperaUm(int codigo) {
        try {
            return listasDAO.recuperaUm(codigo);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    @Override
    public ArrayList<Lista> recuperarTodos(String criterio) {
        try {
            return listasDAO.recuperarTodos(criterio);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }


}
